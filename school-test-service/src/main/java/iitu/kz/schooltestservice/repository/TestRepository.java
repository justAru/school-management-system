package iitu.kz.schooltestservice.repository;

import iitu.kz.schooldbstruct.model.Grades;
import iitu.kz.schooldbstruct.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
