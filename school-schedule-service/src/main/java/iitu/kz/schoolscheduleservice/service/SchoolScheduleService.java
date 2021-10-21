package iitu.kz.schoolscheduleservice.service;

import iitu.kz.schoolscheduleservice.model.EventDTO;

import java.util.List;

public interface SchoolScheduleService {

    List<EventDTO> getSchedule(String weekDay);

}
