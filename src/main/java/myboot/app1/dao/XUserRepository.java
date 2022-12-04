package myboot.app1.dao;

import myboot.app1.model.XUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface XUserRepository extends JpaRepository<XUser,String> {


}
