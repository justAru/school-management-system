package iitu.kz.schoolreportservice.service;

import iitu.kz.schoolreportservice.model.Report;

public interface SchoolReportService {

    Report getReport(Long studentId);
}
