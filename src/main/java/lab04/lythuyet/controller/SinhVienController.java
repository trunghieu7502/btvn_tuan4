package lab04.lythuyet.controller;

import lab04.lythuyet.entity.SinhVien;
import lab04.lythuyet.services.LopService;
import lab04.lythuyet.services.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sinhvien")
public class SinhVienController {
    @Autowired
    private SinhVienService sinhVienService;
    @Autowired
    private LopService lopService;

    @GetMapping
    public String showAllLop(Model model){
        List<SinhVien> dsSV = sinhVienService.getAllSinhVien();
        model.addAttribute("dsSV", dsSV);
        return "sinhvien/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("sv", new SinhVien());
        model.addAttribute("lops", lopService.getAllLop());
        return "sinhvien/add";
    }

    @PostMapping("/add")
    public String addSinhVien(@ModelAttribute("sv") SinhVien sv, BindingResult result){
        if(result.hasErrors()){
            return "sinhvien/add";
        }
        sinhVienService.addSinhVien(sv);
        return "redirect:/sinhvien";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        SinhVien sinhVien = sinhVienService.getSinhVienById(id);
        if(sinhVien != null){
            model.addAttribute("sv", sinhVien);
            model.addAttribute("lops", lopService.getAllLop());
            return "sinhvien/edit";
        }
        return "redirect:/sinhvien";
    }

    @PostMapping("/edit/{id}")
    public String updateSinhVien(@PathVariable("id") Long id, @ModelAttribute("sv") SinhVien svDetails, BindingResult result){
        if(result.hasErrors()){
            return "sinhvien/edit/{id}";
        }
        SinhVien sinhVien = sinhVienService.getSinhVienById(id);
        if(sinhVien != null){
            sinhVien.setHoTen(svDetails.getHoTen());
            sinhVien.setEmail(svDetails.getEmail());
            sinhVien.setNgaySinh(svDetails.getNgaySinh());
            sinhVien.setLop(svDetails.getLop());
            sinhVienService.updateSinhVien(sinhVien);
        }
        return "redirect:/sinhvien";
    }

    @GetMapping("/delete/{id}")
    public String deleteSinhVien(@PathVariable("id") Long id){
        SinhVien sinhVien = sinhVienService.getSinhVienById(id);
        if(sinhVien != null){
            sinhVienService.deleteSinhVien(id);
        }
        return "redirect:/sinhvien";
    }
}
