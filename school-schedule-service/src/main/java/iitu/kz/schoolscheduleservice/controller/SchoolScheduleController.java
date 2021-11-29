package iitu.kz.schoolscheduleservice.controller;

import iitu.kz.schoolscheduleservice.service.SchoolScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/schedule")
@Api(value = "School schedule controller class.")
public class SchoolScheduleController {

    @Autowired
    private SchoolScheduleService schoolScheduleService;

    @GetMapping("/{weekDay}")
    @ApiOperation(value = "Method to get list of subject", response = List.class)
    public ResponseEntity<?> getScheduleByDate(@PathVariable String weekDay) {
        return ResponseEntity.ok(schoolScheduleService.getSchedule(weekDay));
    }
}
