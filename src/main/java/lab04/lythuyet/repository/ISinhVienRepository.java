package lab04.lythuyet.repository;

import lab04.lythuyet.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISinhVienRepository extends JpaRepository<SinhVien, Long> { }
