package iitu.kz.schoolscheduleservice.service.impl;

import iitu.kz.schooldbstruct.model.Subject;
import iitu.kz.schooldbstruct.model.User;
import iitu.kz.schoolscheduleservice.model.EventDTO;
import iitu.kz.schoolscheduleservice.service.SchoolScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolScheduleServiceImpl implements SchoolScheduleService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<EventDTO> getSchedule(String day) {

        List<EventDTO> eventList = new ArrayList<>();

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        Subject[] subjects = restTemplate.getForObject("http://school-db-struct/subjecst/" + day, Subject[].class);

        for (Subject subject: subjects) {
            EventDTO event = restTemplate.getForObject("http://school-schedule-service/schedule/" + day, EventDTO.class);
            User teacher = restTemplate.getForObject("http://school-db-struct/user/" + subject, User.class);
            event.setTeacherId(teacher.getId());
            event.setTeacherName(teacher.getFirstName() + ' ' + teacher.getLastName());
            event.setSubjectId(subject.getId());
            event.setGroup(subject.getGroup().getName()); //not fully correct
            event.setStartDate(subject.getStartDate());
            event.setEndDate(subject.getEndDate());
            eventList.add(event);
        }
        return eventList;
    }
}
