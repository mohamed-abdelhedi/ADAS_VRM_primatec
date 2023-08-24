package com.primatec.ADAS.services;
import com.primatec.ADAS.DAO.teamDAO;
import com.primatec.ADAS.DAO.usersDAO;
import com.primatec.ADAS.DAO.projectDAO;
import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.team;
import com.primatec.ADAS.model.User.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class projectServices {
    private final projectDAO projectDao;
    private final usersDAO userDAO;
    private final teamDAO teamDAO;

    @Autowired
    public projectServices(projectDAO projectDao, usersDAO userDAO,teamDAO teamDAO) {
        this.projectDao = projectDao;
        this.userDAO=userDAO;
        this.teamDAO=teamDAO;
    }

    public void saveProject(project project) {
        projectDao.save(project);
    }

    public List<project> getAllProjects() {
        return projectDao.findAll();
    }

    public Optional<project> getProjectById(UUID id) {
        return projectDao.findById(id);
    }

    public void deleteProject(UUID id) {
        projectDao.deleteById(id);
    }

    public project updateProject(project updatedProject) {
        // Check if the project exists in the database
        Optional<project> optionalProject = projectDao.findById(updatedProject.getProjectId());
        if (optionalProject.isPresent()) {
            project existingProject = optionalProject.get();

            existingProject.setProjectDescription(updatedProject.getProjectDescription());
            existingProject.setProjectName(updatedProject.getProjectName());
            existingProject.setStartDate(updatedProject.getStartDate());
            existingProject.setDeadline(updatedProject.getDeadline());

            // Save the updated project to the database
            return projectDao.save(existingProject);
        } else {
            // Project not found, throw an exception or handle the error accordingly
            throw new EntityNotFoundException("Project with id " + updatedProject.getProjectId() + " not found.");
        }
    }
    public List<project> getProjectByTeamId(UUID teamId) {
        return projectDao.findByTeamTeam_id(teamId);
    }

    public Set<User> getAllProjectUsers(UUID id) {
        //Set<user> users = new HashSet<>();
        Optional<project> existingProject = projectDao.findById(id);
        UUID team_id = existingProject.get().getTeam().getTeam_id();
        Optional<team> existingteam = teamDAO.findById(team_id);
        return existingteam.get().getUsers();
    }

    //public List<project> getProjectIdsByUserId(UUID userId) {
        //return teamDAO.findProjectIdsByUserId(userId);
   // }
}
