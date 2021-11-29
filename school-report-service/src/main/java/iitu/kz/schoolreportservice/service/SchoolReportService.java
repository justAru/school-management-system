package iitu.kz.schoolreportservice.service;

import iitu.kz.schoolreportservice.model.ReportDTO;

public interface SchoolReportService {

    ReportDTO getReport(Long studentId);
}
