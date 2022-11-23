package myboot.app1.dao;

import myboot.app1.model.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface CurriculumeVitaeRepository extends JpaRepository<CV, Integer> {

}
