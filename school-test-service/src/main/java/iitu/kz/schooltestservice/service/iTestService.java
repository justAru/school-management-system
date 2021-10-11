package iitu.kz.schooltestservice.service;

import iitu.kz.schooldbstruct.model.Test;
import iitu.kz.schooldbstruct.model.TestUserMap;

import java.util.List;

public interface iTestService {
    Test createTest(Test test);
    TestUserMap addStudentTest(Long testId, Long studentId);
    TestUserMap deleteStudentTest(Long testId, Long studentId);
    TestUserMap gradeStudent(Long testId, Long studentId, Double score);
    List<TestUserMap> getResultsOrderByScore(Long testId);
}
