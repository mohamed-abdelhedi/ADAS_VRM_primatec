package com.primatec.ADAS.controller;
import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.User.User;
import com.primatec.ADAS.services.projectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static com.primatec.ADAS.model.User.Role.USER;

@RequestMapping("api/projects")
@RestController
@CrossOrigin
public class projectController {
    private projectServices projectService;


    @Autowired
    public projectController(projectServices projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/add")
    public void addProject(@RequestBody project project) {
        projectService.saveProject(project);
    }
    @GetMapping("/all")
    public List<project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable UUID id) {
        projectService.deleteProject(id);
    }

    @PutMapping("/{id}")
    public project updateProject(@PathVariable UUID id, @RequestBody project updatedProject) {
        // Ensure the id in the path variable matches the id in the request body
        if (!id.equals(updatedProject.getProjectId())) {
            throw new IllegalArgumentException("Project id in path variable does not match the id in the request body.");
        }

        return projectService.updateProject(updatedProject);
    }
    @GetMapping("/{id}/users")
    public Set<User> getAllProjectUsers(@PathVariable UUID id) {
        return projectService.getAllProjectUsers(id);
    }


    /*@GetMapping("/projects/{userid}")
    public List<project> getProjectIdsByUserId(@PathVariable UUID userid) {
        return projectService.getProjectIdsByUserId(userid);
    }*/
}
