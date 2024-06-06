package lab04.lythuyet.controller;

import lab04.lythuyet.entity.Lop;
import lab04.lythuyet.services.LopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lop")
public class LopController {
    @Autowired
    private LopService lopService;

    @GetMapping
    public String showAllLop(Model model){
        List<Lop> dsLop = lopService.getAllLop();
        model.addAttribute("dsLop", dsLop);
        return "lop/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("lop", new Lop());
        return "lop/add";
    }

    @PostMapping("/add")
    public String addLop(@ModelAttribute("lop") Lop lop, BindingResult result){
        if(result.hasErrors()){
            return "lop/add";
        }
        lopService.addLop(lop);
        return "redirect:/lop";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        Lop lop = lopService.getLopById(id);
        if(lop != null){
            model.addAttribute("lop", lop);
            return "lop/edit";
        }
        return "redirect:/lop";
    }

    @PostMapping("/edit/{id}")
    public String updateLop(@PathVariable("id") Long id, @ModelAttribute("lop") Lop lopDetails, BindingResult result){
        if(result.hasErrors()){
            return "lop/edit/{id}";
        }
        Lop lop = lopService.getLopById(id);
        if(lop != null){
            lop.setTenLop(lopDetails.getTenLop());
            lopService.updateLop(lop);
        }
        return "redirect:/lop";
    }

    @GetMapping("/delete/{id}")
    public String deleteLop(@PathVariable("id") Long id){
        Lop lop = lopService.getLopById(id);
        if(lop != null){
            lopService.deleteLop(id);
        }
        return "redirect:/lop";
    }
}
