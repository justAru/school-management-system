package iitu.kz.schoolscheduleservice.service;

import iitu.kz.schoolscheduleservice.model.Event;

import java.util.List;

public interface SchoolScheduleService {

    List<Event> getSchedule(String weekDay);

}
