package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface usersDAO extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}

