package iitu.kz.schoolreportservice.service.impl;

import iitu.kz.schoolreportservice.model.Report;
import iitu.kz.schoolreportservice.service.SchoolReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.Subject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolReportServiceImpl implements SchoolReportService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Report getReport(Long studentId) {
        Report report = new Report();

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        User student = restTemplate.getForObject("http://localhost:8081/student/" + studentId, User.class);

        Group group = restTemplate.getForObject("http://localhost:8081/group/" + studentId, Group.class);

        List<Subject> subjects = restTemplate.getForObject("http://localhost:8081/subjects/" + studentId, Subject.class);

        for (Subject subject: subjects) {
            Grade grade = restTemplate.getForObject("http://localhost:8082/grade/" + studentId, Subject.class);
           report.setSubjectId(subject.getId());
           report.setSubjectName(subject.getName());
           report.setGrade(grade.getValue());
        }

        report.setUserId(student.getId());
        report.setUserFullName(student.getFullName());
        report.setEffectiveDate(date);
        report.setGroupName(group);

        return report;
    }
}
