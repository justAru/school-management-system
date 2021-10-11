package iitu.kz.schooltestservice.controller;

import iitu.kz.schooldbstruct.model.Test;
import iitu.kz.schooltestservice.service.impl.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createTest(@RequestBody Test test) {
        return ResponseEntity.ok(testService.createTest(test));
    }

    @RequestMapping(value = "/add-student/{testId}/{studentId}", method = RequestMethod.POST)
    public ResponseEntity<?> addStudentTest(@PathVariable Long testId, @PathVariable Long studentId) {
        return ResponseEntity.ok(testService.addStudentTest(testId, studentId));
    }

    @RequestMapping(value = "/delete/{testId}/{studentId}", method = RequestMethod.POST)
    public ResponseEntity<?> deleteStudentTest(@PathVariable Long testId, @PathVariable Long studentId) {
        return ResponseEntity.ok(testService.deleteStudentTest(testId, studentId));
    }

    @RequestMapping(value = "/grade/{testId}", method = RequestMethod.PUT)
    public ResponseEntity<?> gradeStudentTest(@PathVariable Long testId, @RequestParam Long studentId, @RequestParam Double score) {
        return ResponseEntity.ok(testService.gradeStudent(testId, studentId, score));
    }

    @RequestMapping(value = "/grades/{testId}", method = RequestMethod.GET)
    public ResponseEntity<?> getResults(@PathVariable Long testId) {
        return ResponseEntity.ok(testService.getResultsOrderByScore(testId));
    }
}
