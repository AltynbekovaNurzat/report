package sprint.spring.report.service;

import org.springframework.http.ResponseEntity;
import sprint.spring.report.entity.Report;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportService {
    ResponseEntity<String> addReport(Report report);
    ResponseEntity<List<Report>> getAllReports();
    ResponseEntity<String> updateReport(Report report);
    ResponseEntity<String> deleteReport(Integer reportId);
    ResponseEntity<List<Report>> getReportsByFioAndDate(String fio,LocalDateTime dateCreated);
    ResponseEntity<List<Report>> getReportsByFioAndDateString(String fio,String dateString);
    ResponseEntity<List<Report>> getReportsOfUserByDateString(String login, String dateString);
    ResponseEntity<List<Report>> getReportsOfUser(String login);
}
