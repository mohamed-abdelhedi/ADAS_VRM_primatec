package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface departmentDAO extends JpaRepository<Department, UUID> {
}
