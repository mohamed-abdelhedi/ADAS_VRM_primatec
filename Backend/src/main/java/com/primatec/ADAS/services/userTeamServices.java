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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

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
    public void assignResourcesUsersAndProjectsToTeam(UUID teamId, Set<UUID> resourceIds, Set<UUID> userIds, Set<UUID> projectIds) {
        Optional<team> optionalTeam = teamDao.findById(teamId);

        if (optionalTeam.isPresent()) {
            team team = optionalTeam.get();
            Set<resource> resources = new HashSet<>();
            Set<user> users = new HashSet<>();
            Set<project> projects = new HashSet<>();

            for (UUID resourceId : resourceIds) {
                Optional<resource> optionalResource = resourceDAO.findById(resourceId);
                optionalResource.ifPresentOrElse(resource -> {
                    resource.setTeam(team);
                    resources.add(resource);
                }, () -> {
                    throw new EntityNotFoundException("Resource not found with the provided ID.");
                });
            }

            for (UUID userId : userIds) {
                Optional<user> optionalUser = userDao.findById(userId);
                optionalUser.ifPresentOrElse(users::add, () -> {
                    throw new EntityNotFoundException("User not found with the provided ID.");
                });
            }

            for (UUID projectId : projectIds) {
                Optional<project> optionalProject = projectDAO.findById(projectId);
                optionalProject.ifPresentOrElse(project -> {
                    project.setTeam(team);
                    projects.add(project);
                }, () -> {
                    throw new EntityNotFoundException("Project not found with the provided ID.");
                });
            }

            team.setResources(resources);
            team.setUsers(users);
            team.setProject(projects);
            teamDao.save(team);
        } else {
            throw new EntityNotFoundException("Team not found with the provided ID.");
        }
    }


}









