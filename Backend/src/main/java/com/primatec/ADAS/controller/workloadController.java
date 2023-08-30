package com.primatec.ADAS.controller;

import com.primatec.ADAS.DAO.workloadDAO;
import com.primatec.ADAS.model.User.User;
import com.primatec.ADAS.model.project;
import com.primatec.ADAS.services.workloadService;
import com.primatec.ADAS.model.workload.Workload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.nimbus.NimbusStyle;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/api/workload")
public class workloadController {
    private workloadService workloadService;
    private workloadDAO workloadDAO;

    @Autowired
    public void setWorkloadService(workloadService workloadService, workloadDAO workloadDAO) {
        this.workloadService = workloadService;
        this.workloadDAO=workloadDAO;
    }

    @PostMapping("/add")
    public ResponseEntity<Workload> addWorkload(@RequestBody Workload workload) {
        Workload createdworkload=  workloadService.saveWorkload(workload);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdworkload);
    }

    @GetMapping("/all")
    public List<Workload> getAllWorkloads() {
        return workloadService.getAllWorkloads();
    }

    @DeleteMapping("/{id}")
    public void deleteWorkload(@PathVariable UUID id) {
        workloadService.deleteWorkload(id);
    }

    @PutMapping("/{id}")
    public Workload updateWorkload(@PathVariable UUID id, @RequestBody Workload updatedWorkload) {
        if (!id.equals(updatedWorkload.getWorkloadId())) {
            throw new IllegalArgumentException("Workload id in path variable does not match the id in the request body.");
        }

        return workloadService.updateWorkload(updatedWorkload);
    }
    @CrossOrigin
    @PutMapping("/{workloadId}/assign")
    public ResponseEntity<Workload> updateWorkloadAssignments(
            @PathVariable UUID workloadId,
            @RequestBody Map<String, Set<UUID>> request) {
        Set<UUID> userIds= request.get("userIds");
        Set<UUID> projectIds= request.get("projectIds");
        Workload workload= workloadService.updateWorkloadAssignments(workloadId, userIds, projectIds);
        return ResponseEntity.status(HttpStatus.CREATED).body(workload);
    }
    @PutMapping("/{workloadId}/assignskills")
    public ResponseEntity<Workload> updateWorkloadskills(
            @PathVariable UUID workloadId,
            @RequestBody Map<String, Set<UUID>> request) {
        Set<UUID> skillIds= request.get("skillIds");
        Workload workload= workloadService.updateWorkloadskill(workloadId, skillIds);
        return ResponseEntity.status(HttpStatus.CREATED).body(workload);
    }

    @CrossOrigin
    @GetMapping("/{WorkloadId}")
    public ResponseEntity<Workload> getUserProfile(@PathVariable UUID WorkloadId) {
        Optional<Workload> Workload = workloadService.getWorkloadById(WorkloadId);

        if (Workload.isPresent()) {
            return ResponseEntity.ok(Workload.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/project/{projectId}")
    public List<Workload> getWorkloadsByProjectId(@PathVariable UUID projectId) {
        return workloadService.getWorkloadsByProjectId(projectId);
    }
    @GetMapping("/percentage/{userId}")
    public Number findpercentage(@PathVariable UUID userId) {
        return workloadDAO.findpercentage(userId);
    }
    @GetMapping("/skills/{workloadId}")
    public List<Object> findWorkloadSkills(@PathVariable UUID workloadId) {
        return workloadDAO.findWorkloadSkills(workloadId);
    }

    @GetMapping("/sum")
    public Number getSumWorkload() {
        return workloadDAO.SumWorkload();
    }
}
