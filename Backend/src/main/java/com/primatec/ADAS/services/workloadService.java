package com.primatec.ADAS.services;

import com.primatec.ADAS.DAO.projectDAO;
import com.primatec.ADAS.DAO.skillDAO;
import com.primatec.ADAS.DAO.usersDAO;
import com.primatec.ADAS.DAO.workloadDAO;
import com.primatec.ADAS.model.User.User;
import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.skill;
import com.primatec.ADAS.model.workload.Workload;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class workloadService {
    private final workloadDAO workloadDAO;
    private final projectDAO projectDAO;
    private final usersDAO usersDAO;
    private final skillDAO  skillDAO;


    @Autowired
    public workloadService(workloadDAO workloadDAO,projectDAO projectDAO,usersDAO usersDAO,skillDAO skillDAO ) {
        this.workloadDAO = workloadDAO;
        this.projectDAO=projectDAO;
        this.usersDAO=usersDAO;
        this.skillDAO=skillDAO;
    }

    public Workload saveWorkload(Workload workload) {
        workloadDAO.save(workload);
        return workload;
    }

    public List<Workload> getAllWorkloads() {
        return workloadDAO.findAll();
    }

    public Optional<Workload> getWorkloadById(UUID id) {
        return workloadDAO.findById(id);
    }

    public void deleteWorkload(UUID id) {
        workloadDAO.deleteById(id);
    }
    public List<Workload> getWorkloadsByProjectId(UUID projectId) {
        return workloadDAO.findWorkloadsByProjectId(projectId);
    }

    public Workload updateWorkload(Workload updatedWorkload) {
        Optional<Workload> optionalWorkload = workloadDAO.findById(updatedWorkload.getWorkloadId());
        if (optionalWorkload.isPresent()) {
            Workload existingWorkload = optionalWorkload.get();
            // Update properties here
            existingWorkload.setName(updatedWorkload.getName());
            existingWorkload.setDomain(updatedWorkload.getDomain());
            existingWorkload.setWorkloadState(updatedWorkload.getWorkloadState());
            // ... (update other properties)

            return workloadDAO.save(existingWorkload);
        } else {
            throw new EntityNotFoundException("Workload with id " + updatedWorkload.getWorkloadId() + " not found.");
        }
    }

    public Workload updateWorkloadAssignments(UUID workloadId, Set<UUID> userIds, Set<UUID> projectIds) {
        Optional<Workload> optionalWorkload = workloadDAO.findById(workloadId);
        if (optionalWorkload.isPresent()) {
            Workload workload = optionalWorkload.get();
            for (UUID userId : userIds) {
                Optional<User> optionalUser = usersDAO.findById(userId);
                workload.setAssignedUser(optionalUser.get());
            }

            Set<project> projects = new HashSet<>();
            for (UUID projectId : projectIds) {
                Optional<project> optionalProjects = projectDAO.findById(projectId);
                optionalProjects.ifPresent(projects::add);
            }
             workload.setProjects(projects);
            return workloadDAO.save(workload);
        } else {
            // Handle case when workload is not found
            // You can throw an exception or return null/error response
            return null;
        }
    }
    public Workload updateWorkloadskill(UUID workloadId, Set<UUID> skillIds) {
        Optional<Workload> optionalWorkload = workloadDAO.findById(workloadId);
        if (optionalWorkload.isPresent()) {
            Workload workload = optionalWorkload.get();

            Set<skill> skills = new HashSet<>();
            for (UUID skillid : skillIds) {
                Optional<skill> optionalskill = skillDAO.findById(skillid);
                optionalskill.ifPresent(skills::add);
            }
            workload.setSkills(skills);
            return workloadDAO.save(workload);
        } else {
            return null;
        }
    }
    }


