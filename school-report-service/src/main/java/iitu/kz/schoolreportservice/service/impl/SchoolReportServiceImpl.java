package iitu.kz.schoolreportservice.service.impl;

import iitu.kz.schooldbstruct.model.Grades;
import iitu.kz.schooldbstruct.model.Group;
import iitu.kz.schooldbstruct.model.Subject;
import iitu.kz.schooldbstruct.model.User;
import iitu.kz.schoolreportservice.model.Report;
import iitu.kz.schoolreportservice.service.SchoolReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SchoolReportServiceImpl implements SchoolReportService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Report getReport(Long studentId) {
        Report report = new Report();

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        User student = restTemplate.getForObject("http://school-db-struct/student/" + studentId, User.class);

        Group group = restTemplate.getForObject("http://school-db-struct/group/" + student.getGroup().getId(), Group.class);

        Subject[] subjects = restTemplate.getForObject("http://school-db-struct/subjects/" + studentId, Subject[].class);

        for (Subject subject: subjects) {
            Grades grade = restTemplate.getForObject("http://school-db-struct/grade/" + studentId, Grades.class);
           report.setSubjectId(subject.getId());
           report.setSubjectName(subject.getName());
           report.setGrade(grade.getValue());
        }

        report.setUserId(student.getId());
        report.setUserFullName(student.getFirstName() + ' ' + student.getLastName());
        report.setEffectiveDate(date);
        report.setGroupName(group.getName());

        return report;
    }
}
