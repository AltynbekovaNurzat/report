package sprint.spring.report.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sprint.spring.report.entity.Report;
import sprint.spring.report.entity.User;
import sprint.spring.report.repository.ReportRepository;
import sprint.spring.report.repository.UserRepository;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("Alina","alina","123","mail1");
        User u2 = new User("alin","alin","xyz","mail2");
        User u3 = new User("Bermet","admin","1234","mail3");
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);

        Report r1 = new Report(u1,"tablicy Shulte 5x5 10shtuk","S2 30min","50 zadachek","20/04/2019");
        Report r2 = new Report(u1,"tablicy Shulte 6x6 10shtuk","S2 30min","50 zadachek","18/04/2019");
        Report r3 = new Report(u2,"tablicy Shulte 7x7 8shtuk","S1 30min","50 zadachek","03/03/2019");
        Report r4 = new Report(u3,"tablicy Shulte 8x8 5shtuk","S1 30min","50 zadachek","10/07/2018");
        reportRepository.save(r1);
        reportRepository.save(r2);
        reportRepository.save(r3);
        reportRepository.save(r4);

        Report report = new Report.ReportBuilder().setUser(u1).setDateString("12/12/2012").setEx1("Tablicy Builder").build();
        reportRepository.save(report);
    }
}
