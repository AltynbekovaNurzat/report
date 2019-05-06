package sprint.spring.report.service;

import org.springframework.http.ResponseEntity;
import sprint.spring.report.entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface UserService {
    User addUser(User user);
    ResponseEntity<List<User>> getAllUsers();
    ResponseEntity<Object> getUserById(Integer userId);
    ResponseEntity<String> updateUser(User user);
    ResponseEntity<String> deleteUser(Integer userId);
    ResponseEntity<List<User>> getUserByFio(String fio);
}
