package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface projectDAO extends JpaRepository<project, UUID> {
    @Query("SELECT r FROM project r WHERE r.team.team_id = :teamId")
    List<project> findByTeamTeam_id(UUID teamId);
}
