package com.primatec.ADAS.services;

import com.primatec.ADAS.DAO.projectDAO;
import com.primatec.ADAS.DAO.teamDAO;
import com.primatec.ADAS.DAO.usersDAO;
import com.primatec.ADAS.DAO.resourceDAO;
import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.resource;
import com.primatec.ADAS.model.team;
import com.primatec.ADAS.model.user;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class userTeamServices {
    private final usersDAO userDao;
    private final teamDAO teamDao;
    private final resourceDAO resourceDAO;
    private final projectDAO projectDAO;

    @Autowired
    public userTeamServices(usersDAO userDao, teamDAO teamDao,resourceDAO resourceDAO,projectDAO projectDAO) {
        this.userDao = userDao;
        this.teamDao = teamDao;
        this.resourceDAO=resourceDAO;
        this.projectDAO=projectDAO;

    }
    public void assignUsersToTeam(UUID teamId, Set<UUID> userIds) {
        Optional<team> optionalTeam = teamDao.findById(teamId);

        if (optionalTeam.isPresent()) {
            team team = optionalTeam.get();

            Set<user> users = new HashSet<>();
            for (UUID userId : userIds) {
                Optional<user> optionalUser = userDao.findById(userId);
                optionalUser.ifPresent(users::add);
            }

            team.setUsers(users);
            teamDao.save(team);
        } else {
            throw new EntityNotFoundException("Team not found with the provided ID.");
        }
    }

    public void assignResourcesToTeam(UUID teamId, Set<UUID> resourceIds) {
        Optional<team> optionalTeam = teamDao.findById(teamId);

        if (optionalTeam.isPresent()) {
            team team = optionalTeam.get();
            List<resource> resources = resourceDAO.findAllById(resourceIds);

            // Check if all resourceIds were found
            if (resources.size() != resourceIds.size()) {
                throw new EntityNotFoundException("Resource not found with the provided ID(s).");
            }

            // Update the relationships
            for (resource resource : resources) {
                resource.setTeam(team);
            }

            // Save the team with the updated relationships
            team.setResources(new HashSet<>(resources));
            teamDao.save(team);
        } else {
            throw new EntityNotFoundException("Team not found with the provided ID.");
        }
    }

    public void assignProjectsToTeam(UUID teamId, Set<UUID> projectIds) {
        Optional<team> optionalTeam = teamDao.findById(teamId);

        if (optionalTeam.isPresent()) {
            team team = optionalTeam.get();
            List<project> projects = projectDAO.findAllById(projectIds);

            // Check if all projectIds were found
            if (projects.size() != projectIds.size()) {
                throw new EntityNotFoundException("Project not found with the provided ID(s).");
            }

            // Update the relationships
            for (project project : projects) {
                project.setTeam(team);
            }

            // Save the team with the updated relationships
            team.setProject(new HashSet<>(projects));
            teamDao.save(team);
        } else {
            throw new EntityNotFoundException("Team not found with the provided ID.");
        }
    }



}









