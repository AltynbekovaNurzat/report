package sprint.spring.report.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import sprint.spring.report.entity.Report;
import sprint.spring.report.entity.User;
import sprint.spring.report.service.ReportService;
import sprint.spring.report.service.UserService;

@Service
public class Factory {
    @Autowired
    private ReportService reportService;
    @Autowired
    private UserService userService;

/*    public ResponseEntity<String> setLocation(Object object, UriComponentsBuilder builder){
        if(object instanceof Report){
            Report rep = (Report) object;
            Report r = reportService.addReport(rep);
            System.out.println(r.getId());
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/sprint/report/{id}").buildAndExpand(r.getId()).toUri());
            return new ResponseEntity<>("new Entity is saved", headers, HttpStatus.OK);
        }
        User u = userService.addUser((User) object);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/sprint/user/{id}").buildAndExpand(u.getId()).toUri());
        return new ResponseEntity<>("new Entity is saved",headers, HttpStatus.OK);
    }*/

    public String getMessage(Object object){
        if(object instanceof Report){
            String message = "New Report is saved";
            return message;
        }
        String message = "New User is saved";
        return message;
    }

}
