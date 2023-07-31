package com.primatec.ADAS.services;

import com.primatec.ADAS.DAO.teamDAO;
import com.primatec.ADAS.DAO.usersDAO;
import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.resource;
import com.primatec.ADAS.model.team;
import com.primatec.ADAS.model.user;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class teamServices {
    private final teamDAO teamDAO;
    private resourceServices resourceServices;
    private projectServices projectServices;
    @Autowired

    public teamServices(teamDAO teamDAO ,resourceServices resourceServices, projectServices projectServices) {
        this.teamDAO = teamDAO;
        this.resourceServices=resourceServices;
        this.projectServices=projectServices;
    }

    public void saveTeam(team team) {
        teamDAO.save(team);
    }
    public List<team> getAllTeams() {
        return teamDAO.findAll();
    }
    public Optional<team> getTeamById(UUID id) {
        return teamDAO.findById(id);
    }
    public void deleteTeam(UUID id) {
        List<resource> resourcesToDelete = resourceServices.getResourcesByTeamId(id);
        List<project> projectToDelete = projectServices.getProjectByTeamId(id);

        for (resource resource : resourcesToDelete) {
            resource.setTeam(null); // Set to NULL or a default value
            resourceServices.saveResource(resource); // Save the updated resource
        }
        for (project project : projectToDelete) {
            project.setTeam(null); // Set to NULL or a default value
            projectServices.saveProject(project); // Save the updated resource
        }

        teamDAO.deleteById(id);
    }
    public team updateTeam(team updatedTeam) {
        Optional<team> optionalTeam = teamDAO.findById(updatedTeam.getTeam_id());
        if (optionalTeam.isPresent()) {
            team existingTeam = optionalTeam.get();
            existingTeam.setName(updatedTeam.getName());
            existingTeam.setDescription(updatedTeam.getDescription());
            return teamDAO.save(existingTeam);
        } else {
            // User not found, throw an exception or handle the error accordingly
            throw new EntityNotFoundException("Team with id " + updatedTeam.getTeam_id() + " not found.");
        }
    }

}
