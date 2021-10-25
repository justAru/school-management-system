package iitu.kz.schooltestservice.repository;

import iitu.kz.schooldbstruct.model.Grades;
import iitu.kz.schooldbstruct.model.TestUserMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapRepository extends JpaRepository<TestUserMap, Long> {
    TestUserMap deleteByTestIdAndStudentId(Long testId, Long studentId);
    TestUserMap getByTestIdAndStudentId(Long testId, Long studentId);
    List<TestUserMap> getAllByTestIdOrderByScore(Long testId);
    List<TestUserMap> getAllByTestId(Long testId);
}
