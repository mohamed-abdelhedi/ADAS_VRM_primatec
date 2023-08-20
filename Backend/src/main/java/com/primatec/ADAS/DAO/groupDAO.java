package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.Department;
import com.primatec.ADAS.model.group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface groupDAO extends JpaRepository<group, UUID> {
}
