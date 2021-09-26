package iitu.kz.schoolscheduleservice.service.impl;

import iitu.kz.schoolscheduleservice.model.Event;
import iitu.kz.schoolscheduleservice.service.SchoolScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.Subject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolScheduleServiceImpl implements SchoolScheduleService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Event> getSchedule(String day) {

        List<Event> eventList = new ArrayList<>();

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        List<Subject> subjects = restTemplate.getForObject("http://localhost:8081/subjects/" + day, Subject.class);

        for (Subject subject: subjects) {
            Event event = restTemplate.getForObject("http://school-schedule-service/schedule/" + day, Event.class);
            User teacher = restTemplate.getForObject("http://localhost:8081/teacher/" + subject, User.class);
            event.setTeacherId(teacher.getId());
            event.setTeacherName(teacher.getFullName());
            event.setSubjectId(subject.getId());
            event.setGroup(subject.getGroup()); //not fully correct
            event.setStartDate(subject.getStartDate());
            event.setEndDate(subject.getEndDate());
            eventList.add(event);
        }
        return eventList;
    }
}
