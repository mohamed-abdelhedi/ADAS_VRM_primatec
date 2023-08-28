package com.primatec.ADAS.controller;

import com.primatec.ADAS.DAO.UserSkillDAO;
import com.primatec.ADAS.DTO.UserSkillRequest;
import com.primatec.ADAS.model.User.User;
import com.primatec.ADAS.model.UserSkill;
import com.primatec.ADAS.services.SkillService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/user-skills")
public class UserSkillController {
    private final SkillService skillServices;
    private final UserSkillDAO UserSkillDAO;

    @Autowired
    public UserSkillController(SkillService skillServices,UserSkillDAO UserSkillDAO) {
        this.skillServices = skillServices;
        this.UserSkillDAO=UserSkillDAO;
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<String> addUserSkill(@PathVariable UUID userId, @RequestBody List<UserSkillRequest> userSkillRequests) {
        try {
            skillServices.addUserSkills(userId,userSkillRequests);
            return ResponseEntity.ok("User skill added successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body("Invalid user or skill ID.");
        }
    }

    @GetMapping("/graph")
    public List<Object[]> getUserSkillGraph(@RequestParam UUID userId, @RequestParam UUID skillId) {
        return skillServices.getUserSkillGraph(userId, skillId);
    }
    @GetMapping("/proficiency")
    public List<Object[]> getUserSkillproficiency(@RequestParam UUID userId, @RequestParam UUID skillId) {
        return skillServices.getUserSkillproficiency(userId, skillId);
    }
    @CrossOrigin
    @GetMapping("/{skillId}")
    public List<UUID> getUserskill(@PathVariable UUID skillId) {
        return UserSkillDAO.getUserskill( skillId);
    }

    @CrossOrigin
    @GetMapping("user/{userid}")
    public List<UUID> getallusersSKills(@PathVariable UUID userid) {
        return UserSkillDAO.getallUserSkills( userid);
    }

    @GetMapping("/user/{userId}/skills")
    public List<Object> getUserSkillsWithSkillNameAndProficiency(@PathVariable UUID userId) {
        return skillServices.getUserSkillsWithSkillNameAndProficiency(userId);
    }
    @PutMapping("/{id}")
    public UserSkill updateUserSkill(@PathVariable UUID id, @RequestBody UserSkill updatedUserSkill) {
        // Ensure the id in the request body matches the path variable id
        if (!id.equals(updatedUserSkill.getUser_skill_id())) {
            throw new IllegalArgumentException("updateUserSkill id in path variable does not match the id in the request body.");
        }

        return skillServices.updateUserSkill(updatedUserSkill);
    }

    @GetMapping("/getUserSkillIds")
    public ResponseEntity<UserSkill> getUserSkillIds(
            @RequestParam UUID userId,
            @RequestParam UUID skillId
    ) {
        LocalDate currentDate = LocalDate.now();
        UserSkill userSkillIds = UserSkillDAO.findId(userId, skillId, currentDate);

        return ResponseEntity.ok(userSkillIds);
    }

    @GetMapping("/getUserSkillForPreviousMonth")
    public ResponseEntity<UserSkill> getUserSkillForPreviousMonth(
            @RequestParam UUID userId,
            @RequestParam UUID skillId
    ) {
        LocalDate currentDate = LocalDate.now().minusMonths(1);
        UserSkill userSkillForPreviousMonth = UserSkillDAO.findId(userId, skillId, currentDate);

        if (userSkillForPreviousMonth != null) {
            return ResponseEntity.ok(userSkillForPreviousMonth);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}