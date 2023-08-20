package com.primatec.ADAS.DAO;


import com.primatec.ADAS.model.skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface skillDAO extends JpaRepository<skill, UUID> {
}
