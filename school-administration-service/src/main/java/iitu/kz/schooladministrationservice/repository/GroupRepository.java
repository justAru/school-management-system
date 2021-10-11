package iitu.kz.schooladministrationservice.repository;

import iitu.kz.schooldbstruct.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}
