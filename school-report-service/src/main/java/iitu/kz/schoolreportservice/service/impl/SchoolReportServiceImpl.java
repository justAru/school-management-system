package iitu.kz.schoolreportservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import iitu.kz.schooldbstruct.model.Grades;
import iitu.kz.schooldbstruct.model.Group;
import iitu.kz.schooldbstruct.model.Subject;
import iitu.kz.schooldbstruct.model.User;
import iitu.kz.schoolreportservice.model.ReportDTO;
import iitu.kz.schoolreportservice.service.SchoolReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class SchoolReportServiceImpl implements SchoolReportService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(
            fallbackMethod = "getReport",
            threadPoolKey = "getAlternativeReport",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueuesize", value = "50"),
            })
    public ReportDTO getReport(Long studentId) {
        ReportDTO report = new ReportDTO();

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

    public ReportDTO getAlternativeReport(Long id) {
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setGrade(0.00);
        reportDTO.setGroupName("Group not found!");
        reportDTO.setSubjectName("Subjects not found!");
        reportDTO.setUserFullName("User not found!");

        return reportDTO;
    }
}
