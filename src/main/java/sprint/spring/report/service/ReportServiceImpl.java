package sprint.spring.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sprint.spring.report.entity.Report;
import sprint.spring.report.entity.User;
import sprint.spring.report.repository.ReportRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report addReport(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public ResponseEntity<List<Report>> getAllReports() {
        List<Report> reportList = reportRepository.findAll();
        return new ResponseEntity<>(reportList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> updateReport(Report report) {
        for(Report r: reportRepository.findAll()){
            if(r.getId().equals(report.getId())){
                r.setEx1(report.getEx1());
                r.setEx2(report.getEx2());
                r.setEx3(report.getEx3());
                r.setDateCreated(report.getDateCreated());
                reportRepository.save(r);
                return new ResponseEntity<>("Report is updated",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Report with id " + report.getId() + " does not exist", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> deleteReport(Integer reportId) {
        for(Report r: reportRepository.findAll()){
            if(r.getId().equals(reportId)){
                reportRepository.delete(r);
                return new ResponseEntity<>("Report is removed",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Report with id " + reportId + " does not exist",HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Report>> getReportsByFioAndDate(String fio, LocalDateTime dateCreated) {
        List<Report> reportList = reportRepository.getReportsByFioAndDate(fio.toLowerCase(), dateCreated);
        return new ResponseEntity<>(reportList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Report>> getReportsByFioAndDateString(String fio, String dateString) {
        List<Report> reportList = reportRepository.getReportsByFioAndDateString(fio,dateString);
        return new ResponseEntity<>(reportList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Report>> getReportsOfUserByDateString(String login, String dateString) {
        List<Report> reportList = reportRepository.getReportsOfUserByDateString(login,dateString);
        return new ResponseEntity<>(reportList,HttpStatus.OK);
    }

    @Override
    public Report getReportById(Integer reportId) {
        for(Report r: reportRepository.findAll()){
            if(r.getId().equals(reportId)){
                return reportRepository.getOne(reportId);
            }
        }
        return null;
    }

}
