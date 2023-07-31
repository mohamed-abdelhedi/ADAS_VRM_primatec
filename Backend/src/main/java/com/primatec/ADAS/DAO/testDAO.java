package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.test.test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface testDAO extends JpaRepository<test, UUID> {
    @Query("SELECT r FROM test r WHERE r.project.projectId = :projectId")
    List<test> findByProject(Optional<Optional<project>> project);
}
