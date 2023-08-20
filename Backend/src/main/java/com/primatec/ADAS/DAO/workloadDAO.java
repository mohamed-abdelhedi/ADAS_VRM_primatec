package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.workload.Workload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface workloadDAO extends JpaRepository<Workload, UUID> {
}
