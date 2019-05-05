package sprint.spring.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sprint.spring.report.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where lower(u.fio) like coalesce(concat('%', :fio, '%'),u.fio) ")
    List<User> getUserByFio(@Param("fio") String fio);
}
