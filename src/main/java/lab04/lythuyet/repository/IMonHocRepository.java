package lab04.lythuyet.repository;

import lab04.lythuyet.entity.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMonHocRepository extends JpaRepository<MonHoc, String> { }
