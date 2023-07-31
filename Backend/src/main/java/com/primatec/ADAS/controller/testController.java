package com.primatec.ADAS.controller;
import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.test.test;
import com.primatec.ADAS.services.testService;
import com.primatec.ADAS.services.projectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects/{projectId}/tests")
public class testController {
    private final testService testService;
    private final projectServices projectService;

    @Autowired
    public testController(testService testService, projectServices projectService) {
        this.testService = testService;
        this.projectService = projectService;
    }

    @PostMapping
    public void addTestToProject(@PathVariable UUID projectId, @RequestBody test test) {
        Optional<project> project = projectService.getProjectById(projectId);
        project existingProject=project.get();
        testService.addTest(test,existingProject);
    }

    @GetMapping("/{testId}")
    public void getTestById(@PathVariable UUID projectId, @PathVariable UUID testId) {
        projectService.getProjectById(projectId); // Make sure the project exists
         testService.getTestById(testId);
    }

    @PutMapping("/{testId}")
    public void updateTest(@PathVariable UUID projectId, @PathVariable UUID testId, @RequestBody test updatedTest) {
        projectService.getProjectById(projectId); // Make sure the project exists
        updatedTest.setTestId(testId); // Set the test ID from the path variable
        testService.updateTest(updatedTest);

    }

    @DeleteMapping("/{testId}")
    public void deleteTest(@PathVariable UUID projectId, @PathVariable UUID testId) {
        projectService.getProjectById(projectId); // Make sure the project exists
        testService.deleteTest(testId);
    }

    @GetMapping
    public void getAllTestsByProject(@PathVariable UUID projectId) {
        Optional<project> project = projectService.getProjectById(projectId);
        List<test> tests = testService.getAllTestsByProject(Optional.ofNullable(project));

    }

}
