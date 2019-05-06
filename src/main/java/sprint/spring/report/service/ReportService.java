package sprint.spring.report.service;

import org.springframework.http.ResponseEntity;
import sprint.spring.report.entity.Report;
import sprint.spring.report.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportService {
    Report addReport(Report report);
    ResponseEntity<List<Report>> getAllReports();
    ResponseEntity<String> updateReport(Report report);
    ResponseEntity<String> deleteReport(Integer reportId);
    ResponseEntity<List<Report>> getReportsByFioAndDate(String fio,LocalDateTime dateCreated);
    ResponseEntity<List<Report>> getReportsByFioAndDateString(String fio,String dateString);
    ResponseEntity<List<Report>> getReportsOfUserByDateString(String login, String dateString);
    Report getReportById(Integer reportId);
}
