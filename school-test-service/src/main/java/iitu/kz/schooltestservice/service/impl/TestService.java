package iitu.kz.schooltestservice.service.impl;

import iitu.kz.schooldbstruct.model.Subject;
import iitu.kz.schooldbstruct.model.Test;
import iitu.kz.schooldbstruct.model.TestUserMap;
import iitu.kz.schooldbstruct.model.User;
import iitu.kz.schooltestservice.repository.SubjectRepository;
import iitu.kz.schooltestservice.repository.TestMapRepository;
import iitu.kz.schooltestservice.repository.TestRepository;
import iitu.kz.schooltestservice.repository.UserRepository;
import iitu.kz.schooltestservice.service.iTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements iTestService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestMapRepository testMapRepository;

    @Override
    public Test createTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public TestUserMap addStudentTest(Long testId, Long studentId) {
        TestUserMap testUserMap = new TestUserMap();
        testUserMap.setTestId(testId);
        testUserMap.setStudentId(studentId);
        return testMapRepository.save(testUserMap);
    }

    @Override
    public TestUserMap deleteStudentTest(Long testId, Long studentId) {
        return testMapRepository.deleteByTestIdAndStudentId(testId, studentId);
    }

    @Override
    public TestUserMap gradeStudent(Long testId, Long studentId, Double score) {
        TestUserMap testUserMap = testMapRepository.getByTestIdAndStudentId(testId, studentId);
        testUserMap.setScore(score);
        return testMapRepository.save(testUserMap);
    }

    @Override
    public List<TestUserMap> getResultsOrderByScore(Long testId) {
        return testMapRepository.getAllByTestIdOrderByScore(testId);
    }
}
