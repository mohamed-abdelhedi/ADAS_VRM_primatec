package com.primatec.ADAS.controller;

import com.primatec.ADAS.model.team;
import com.primatec.ADAS.model.user;
import com.primatec.ADAS.services.teamServices;
import com.primatec.ADAS.services.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    private teamServices teamServices;
    @Autowired
    public void TeamController(teamServices teamServices) {
        this.teamServices = teamServices;
    }
    @PostMapping("/add")
    public void addTeam(@RequestBody team team) {
        teamServices.saveTeam(team);
    }
    @GetMapping("/all")
    public List<team> getAllTeams() {
        return teamServices.getAllTeams();
    }
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable UUID id) {
        teamServices.deleteTeam(id);
    }
    @PutMapping("/{id}")
    public team updateTeam(@PathVariable UUID id, @RequestBody team updatedTeam) {
        // Ensure the id in the request body matches the path variable id
        if (!id.equals(updatedTeam.getTeam_id())) {
            throw new IllegalArgumentException("User id in path variable does not match the id in the request body.");
        }

        return teamServices.updateTeam(updatedTeam);
    }
}
