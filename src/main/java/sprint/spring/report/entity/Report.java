package sprint.spring.report.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "x_report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String ex1;
    private String ex2;
    private String ex3;
    private LocalDateTime dateCreated;
    private String dateString;

    public Report() {
    }

    public Report(User user, String ex1, String ex2, String ex3, String dateString) {
        this.user = user;
        this.ex1 = ex1;
        this.ex2 = ex2;
        this.ex3 = ex3;
        this.dateCreated = LocalDateTime.now();
        this.dateString = dateString;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEx1() {
        return ex1;
    }

    public void setEx1(String ex1) {
        this.ex1 = ex1;
    }

    public String getEx2() {
        return ex2;
    }

    public void setEx2(String ex2) {
        this.ex2 = ex2;
    }

    public String getEx3() {
        return ex3;
    }

    public void setEx3(String ex3) {
        this.ex3 = ex3;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    private Report(ReportBuilder reportBuilder){
        this.user = reportBuilder.user;
        this.ex1 = reportBuilder.ex1;
        this.ex2 = reportBuilder.ex2;
        this.ex3 = reportBuilder.ex3;
        this.dateCreated = LocalDateTime.now();
        this.dateString = reportBuilder.dateString;
    }

    public static class ReportBuilder{
        private User user;
        private String ex1;
        private String ex2;
        private String ex3;
        private String dateString;

        public ReportBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public ReportBuilder setEx1(String ex1) {
            this.ex1 = ex1;
            return this;
        }

        public ReportBuilder setEx2(String ex2) {
            this.ex2 = ex2;
            return this;
        }

        public ReportBuilder setEx3(String ex3) {
            this.ex3 = ex3;
            return this;
        }

        public ReportBuilder setDateString(String dateString) {
            this.dateString = dateString;
            return this;
        }

        public Report build(){
            return new Report(this);
        }
    }
}
