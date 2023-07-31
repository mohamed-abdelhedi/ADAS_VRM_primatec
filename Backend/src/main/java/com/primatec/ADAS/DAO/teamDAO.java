package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface teamDAO extends JpaRepository<team, UUID> {
}
