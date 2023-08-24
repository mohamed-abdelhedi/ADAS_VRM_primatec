package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserSkillDAO extends JpaRepository<UserSkill, UUID> {
    @Query("SELECT us.date, us.proficiency FROM UserSkill us " +
            "WHERE us.user.id = :userId AND us.skill.id = :skillId " +
            "ORDER BY us.date")
    List<Object[]> getUserSkillGraph(@Param("userId") UUID userId, @Param("skillId") UUID skillId);
}
