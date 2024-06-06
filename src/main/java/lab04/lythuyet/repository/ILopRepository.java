package lab04.lythuyet.repository;

import lab04.lythuyet.entity.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILopRepository extends JpaRepository<Lop, Long> { }


