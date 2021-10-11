package iitu.kz.schooladministrationservice.repository;

import iitu.kz.schooldbstruct.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
