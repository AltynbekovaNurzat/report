package sprint.spring.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import sprint.spring.report.entity.Report;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer> {
    @Query("select r from Report r join fetch r.user u " +
            "where lower(u.fio) like coalesce (concat('%',:fio,'%'), u.fio)"
            + "and r.dateCreated like coalesce(concat(:dateCreated,'%'), r.dateCreated)")
    List<Report> getReportsByFioAndDate(@Param("fio")String fio,
                                        @Param("dateCreated") LocalDateTime dateCreated);

    @Query("select r from Report r join fetch r.user u " +
            "where lower(u.fio) like coalesce (cast(concat('%',:fio,'%') as text), lower(u.fio))"
            + "and r.dateString = coalesce(cast(:dateString as text), r.dateString)")
    List<Report> getReportsByFioAndDateString(@Param("fio")String fio,
                                        @Param("dateString") String dateString);

    @Query("select r from Report r join fetch r.user u " +
            "where u.login = :login "
            + "and r.dateString = coalesce(cast(:dateString as text), r.dateString)")
    List<Report> getReportsOfUserByDateString(@Param("login")String login,
                                              @Param("dateString") String dateString);

}
