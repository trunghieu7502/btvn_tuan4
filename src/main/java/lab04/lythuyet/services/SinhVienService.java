package lab04.lythuyet.services;

import lab04.lythuyet.entity.SinhVien;
import lab04.lythuyet.repository.ISinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SinhVienService {
    @Autowired
    private ISinhVienRepository sinhVienRepository;

    public List<SinhVien> getAllSinhVien(){
        return sinhVienRepository.findAll();
    }

    public SinhVien getSinhVienById(Long id){
        return sinhVienRepository.findById(id).orElse(null);
    }

    public void addSinhVien (SinhVien sinhVien){
        sinhVienRepository.save(sinhVien);
    }

    public void deleteSinhVien (Long id){
        sinhVienRepository.deleteById(id);
    }

    public void updateSinhVien (SinhVien sinhVien){
        sinhVienRepository.save(sinhVien);
    }
}
