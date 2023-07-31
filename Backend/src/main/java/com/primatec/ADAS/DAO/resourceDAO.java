package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface resourceDAO extends JpaRepository<resource, UUID> {
    @Query("SELECT r FROM resource r WHERE r.team.team_id = :teamId")
    List<resource> findByTeamTeam_id(UUID teamId);
}
