package iitu.kz.schoolreportservice.controller;

import iitu.kz.schoolreportservice.service.SchoolReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
@Api(value = "School report controller class.")
public class SchoolReportController {

    @Autowired
    private SchoolReportService schoolReportService;

    @GetMapping("/{studentId}")
    @ApiOperation(value = "Method to get list of students by id", response = List.class)
    public ResponseEntity<?> getScheduleByDate(@PathVariable Long studentId) {
        return ResponseEntity.ok(schoolReportService.getReport(studentId));
    }
}
