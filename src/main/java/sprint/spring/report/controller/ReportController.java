package sprint.spring.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import sprint.spring.report.entity.Report;
import sprint.spring.report.entity.User;
import sprint.spring.report.service.ReportService;
import sprint.spring.report.service.UserService;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sprint/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> addReport(@RequestBody Report report, UriComponentsBuilder builder){
        Report r = reportService.addReport(report);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/sprint/report/{id}").buildAndExpand(r.getId()).toUri());
        return new ResponseEntity<>("Report is saved",headers,HttpStatus.CREATED);
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
    public ResponseEntity<List<Report>> getReportsByFioAndDateString(@RequestHeader(required = false) String fio,
                                                                     @RequestHeader(required = false) String dateString){
        return reportService.getReportsByFioAndDateString(fio,dateString);
    }

    @GetMapping
    public ResponseEntity<List<Report>> getReportsOfUserByDateString(Principal principal,
                                                                     @RequestHeader(required = false) String dateString){
        return reportService.getReportsOfUserByDateString(principal.getName(),dateString);
    }

    @GetMapping("/{reportId}")
    public ResponseEntity<Report> getReportById(@PathVariable Integer reportId){
        Report r = reportService.getReportById(reportId);
        if(r!=null){
            return new ResponseEntity<>(r,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

}
