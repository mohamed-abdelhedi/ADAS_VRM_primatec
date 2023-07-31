package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface usersDAO extends JpaRepository<user, UUID> {
}
