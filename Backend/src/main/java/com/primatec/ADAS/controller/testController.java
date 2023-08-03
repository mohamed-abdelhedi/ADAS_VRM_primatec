package com.primatec.ADAS.controller;
import com.primatec.ADAS.model.project;
import com.primatec.ADAS.model.test.test;
import com.primatec.ADAS.model.user;
import com.primatec.ADAS.services.testService;
import com.primatec.ADAS.services.projectServices;
import com.primatec.ADAS.services.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/projects/{projectId}/tests")
public class testController {
    private final testService testService;
    private final projectServices projectService;
    private final userServices userServices;

    @Autowired
    public testController(testService testService, projectServices projectService,userServices userServices) {
        this.testService = testService;
        this.projectService = projectService;
        this.userServices=userServices;
    }

    @PostMapping
    public void addTestToProject(@PathVariable UUID projectId, @RequestBody test test) {
        Optional<project> project = projectService.getProjectById(projectId);
        project existingProject=project.get();
        testService.addTest(test,existingProject);
    }
    @PutMapping("/{testId}/assign-user")
    public void addUserToTest(@PathVariable UUID testId,  @RequestBody Map<String, UUID> request) {
        UUID userid = request.get("userid");
        Optional<user> user = userServices.getUserById(userid);
        test test =testService.getTestById(testId).get();
        testService.assignUser(test,user.get());
    }

    @GetMapping("/{testId}")
    public test getTestById(@PathVariable UUID projectId, @PathVariable UUID testId) {
        projectService.getProjectById(projectId); // Make sure the project exists
        return testService.getTestById(testId).get();
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
    public List<test> getAllTestsByProject(@PathVariable UUID projectId) {
        Optional<project> project = projectService.getProjectById(projectId);
        List<test> tests = testService.getAllTestsByProject(project.get());
        return tests;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Map<String, Object>>> getNumberOfTestsPerMonthPerUserDomain(@PathVariable UUID userId) {
        List<Map<String, Object>> result = testService.getNumberOfTestsPerMonthPerUserDomain(userId);
        return ResponseEntity.ok(result);
    }

}
