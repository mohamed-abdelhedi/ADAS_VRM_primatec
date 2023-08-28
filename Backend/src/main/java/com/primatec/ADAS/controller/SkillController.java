package com.primatec.ADAS.controller;

import com.primatec.ADAS.model.User.User;
import com.primatec.ADAS.services.SkillService;
import com.primatec.ADAS.model.skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/skills")
public class SkillController {
    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/add")
    public void addSkill(@RequestBody skill skill) {
        skillService.saveSkill(skill);
    }

    @GetMapping("/all")
    public List<skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/{id}")
    public skill getSkillById(@PathVariable UUID id) {
        return skillService.getSkillById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable UUID id) {
        skillService.deleteSkill(id);
    }


}
