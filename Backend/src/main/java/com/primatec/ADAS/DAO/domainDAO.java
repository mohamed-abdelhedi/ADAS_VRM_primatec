package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface domainDAO extends JpaRepository<domain, UUID> {
}
