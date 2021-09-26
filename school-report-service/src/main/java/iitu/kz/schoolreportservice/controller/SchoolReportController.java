package iitu.kz.schoolreportservice.controller;

import iitu.kz.schoolreportservice.service.SchoolReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class SchoolReportController {

    @Autowired
    private SchoolReportService schoolReportService;

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getScheduleByDate(@PathVariable Long studentId) {
        return ResponseEntity.ok(schoolReportService.getReport(studentId));
    }
}
