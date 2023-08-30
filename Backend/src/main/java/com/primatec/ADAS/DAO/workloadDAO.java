package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.workload.Workload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface workloadDAO extends JpaRepository<Workload, UUID> {

    @Query("SELECT w FROM Workload w JOIN w.projects p WHERE p.projectId = :projectId")
    List<Workload> findWorkloadsByProjectId(UUID projectId);
    @Query("SELECT w FROM Workload w JOIN w.assignedUser p WHERE p.user_id = :userid")
    List<Workload> findWorkloadsByuserId(UUID userid);
    @Query("SELECT sum(w.percentage) FROM Workload w WHERE w.assignedUser.user_id = :userid AND w.workloadState=1")
    Number findpercentage( UUID userid);

    @Query("SELECT w.skills FROM Workload w WHERE w.workloadId= :workloadId")
    List<Object> findWorkloadSkills(@Param("workloadId")  UUID workloadId);

    @Query("SELECT count(r) FROM Workload r ")
    Number SumWorkload();
}
