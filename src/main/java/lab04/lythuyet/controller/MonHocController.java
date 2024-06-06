package lab04.lythuyet.controller;

import lab04.lythuyet.entity.Lop;
import lab04.lythuyet.entity.MonHoc;
import lab04.lythuyet.services.LopService;
import lab04.lythuyet.services.MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/monhoc")
public class MonHocController {
    @Autowired
    private MonHocService monHocService;

    @GetMapping
    public String showAllMonHoc(Model model){
        List<MonHoc> dsMH = monHocService.getAllMonHoc();
        model.addAttribute("dsMH", dsMH);
        return "monhoc/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("mon", new MonHoc());
        return "monhoc/add";
    }

    @PostMapping("/add")
    public String addMonHoc(@ModelAttribute("mon") MonHoc mon){
        monHocService.addMonHoc(mon);
        return "redirect:/monhoc";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model){
        MonHoc mon = monHocService.getMonHocById(id);
        if(mon != null){
            model.addAttribute("mon", mon);
            return "monhoc/edit";
        }
        return "redirect:/monhoc";
    }

    @PostMapping("/edit/{id}")
    public String updateMonHoc(@PathVariable("id") String id, @ModelAttribute("mon") MonHoc monDetails){
        MonHoc mon = monHocService.getMonHocById(id);
        if(mon != null){
            mon.setTenMonHoc(monDetails.getTenMonHoc());
            monHocService.updateMonHoc(mon);
        }
        return "redirect:/monhoc";
    }

    @GetMapping("/delete/{id}")
    public String deleteMonHoc(@PathVariable("id") String id){
        MonHoc mon = monHocService.getMonHocById(id);
        if(mon != null){
            monHocService.deleteMonHoc(id);
        }
        return "redirect:/monhoc";
    }
}
