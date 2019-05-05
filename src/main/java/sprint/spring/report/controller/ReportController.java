package sprint.spring.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import sprint.spring.report.entity.Report;
import sprint.spring.report.service.ReportService;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sprint/report")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<String> addReport(@RequestBody Report report){
        return reportService.addReport(report);
    }

    @GetMapping("/getAllReports")
    public ResponseEntity<List<Report>> getAllReportsAmdin() {
        return reportService.getAllReports();
    }

    @PutMapping
    public ResponseEntity<String> updateReport(@RequestBody Report report){
        return reportService.updateReport(report);
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<String> deleteReport(@PathVariable Integer reportId){
        return reportService.deleteReport(reportId);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Report>> getReportsByFioAndDate(@RequestHeader String fio, @RequestHeader LocalDateTime dateCreated){
        return reportService.getReportsByFioAndDate(fio,dateCreated);
    }

    @GetMapping("/searchString")
    public ResponseEntity<List<Report>> getReportsByFioAndDateString(@RequestHeader String fio, @RequestHeader String dateString){
        return reportService.getReportsByFioAndDateString(fio,dateString);
    }

    @GetMapping
    public ResponseEntity<List<Report>> getReportsOfUserByDateString(Principal principal,
                                                                     @RequestHeader(required = false) String dateString){
        if(dateString!=null){
            return reportService.getReportsOfUserByDateString(principal.getName(),dateString);
        }
        return reportService.getReportsOfUser(principal.getName());
    }
}
