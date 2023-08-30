package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface usersDAO extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
    @Query("SELECT count(r) FROM User r ")
    Number SumUsers();

}

