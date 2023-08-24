package com.primatec.ADAS.controller;

import com.primatec.ADAS.DTO.UserSkillRequest;
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

    @Autowired
    public UserSkillController(SkillService skillServices) {
        this.skillServices = skillServices;
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
}