package sprint.spring.report.entity;

import javax.persistence.*;

@Entity
@Table(name="x_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fio;
    @Column(unique = true)
    private String login;
    private String password;
    @Column(unique = true)
    private String email;

    public User() {
    }

    public User(String fio, String login, String password, String email) {
        this.fio = fio;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
