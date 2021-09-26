package iitu.kz.schoolscheduleservice.controller;

import iitu.kz.schoolscheduleservice.service.SchoolScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedule")
public class SchoolScheduleController {

    @Autowired
    private SchoolScheduleService schoolScheduleService;

    @GetMapping("/{weekDay}")
    public ResponseEntity<?> getScheduleByDate(@PathVariable String weekDay) {
        return ResponseEntity.ok(schoolScheduleService.getSchedule(weekDay));
    }
}
