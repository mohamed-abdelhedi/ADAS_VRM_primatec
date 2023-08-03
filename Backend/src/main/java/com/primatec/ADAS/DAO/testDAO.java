package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.test.test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface testDAO extends JpaRepository<test, UUID> {
    @Query("SELECT r FROM test r WHERE r.project.projectId = :project_id")
    List<test> findByProject(UUID project_id);

    @Query("SELECT MONTH(r.testDate) AS month, YEAR(r.testDate) AS year, r.tester.user_id AS userId, r.domain AS domain, COUNT(r) AS numberOfTests " +
            "FROM test r " +
            "WHERE  r.tester.user_id = :userId " +
            "GROUP BY MONTH(r.testDate),YEAR(r.testDate),  r.tester.user_id, r.domain")
    List<Map<String, Object>> findNumberOfTestsPerMonthPerUserDomain(@Param("userId") UUID userId);

}
