package iitu.kz.schooltestservice.repository;

import iitu.kz.schooldbstruct.model.Grades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradesRepository extends JpaRepository<Grades, Long> {

}
