package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface teamDAO extends JpaRepository<team, UUID> {

   /* @Query("SELECT project FROM team t " +
           "WHERE t.t =:userId")
    List<project> findProjectIdsByUserId(UUID userId);*/
}
