package com.primatec.ADAS.DAO;

import com.primatec.ADAS.model.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface UserSkillDAO extends JpaRepository<UserSkill, UUID> {
    @Query("SELECT us.date, us.proficiency FROM UserSkill us " +
            "WHERE us.user.user_id = :userId AND us.skill.skill_id = :skillId " +
            "ORDER BY us.date")
    List<Object[]> getUserSkillGraph(@Param("userId") UUID userId, @Param("skillId") UUID skillId);

    @Query("SELECT MAX(us.proficiency) FROM UserSkill us " +
            "WHERE us.user.user_id = :userId AND us.skill.skill_id = :skillId")
    List<Object[]> getUserSkillproficiency(@Param("userId") UUID userId, @Param("skillId") UUID skillId);



    @Query("SELECT us.user.user_id" +
            " FROM UserSkill us "+
            "where us.skill.skill_id=:skillId")
    List<UUID> getUserskill(@Param("skillId") UUID skillId);

    @Query("SELECT us.skill.skill_id" +
            " FROM UserSkill us "+
            "where us.user.user_id=:userid")
    List<UUID> getallUserSkills(@Param("userid") UUID userid);

    @Query("SELECT us.date, s.name, us.proficiency " +
            "FROM UserSkill us JOIN us.skill s WHERE us.user.user_id = :userid " +
            "ORDER BY us.date")
    List<Object> findUserSkillsWithSkillNameAndProficiency(@Param("userid") UUID userId);
    @Query("SELECT us " +
            "FROM UserSkill us " +
            "WHERE us.user.user_id = :userId AND us.skill.skill_id = :skillId " +
            "AND YEAR(us.date) = YEAR(:date) AND MONTH(us.date) = MONTH(:date) " +
            "ORDER BY us.date")
    UserSkill findId(
            @Param("userId") UUID userId,
            @Param("skillId") UUID skillId,
            @Param("date") LocalDate date
    );
}
