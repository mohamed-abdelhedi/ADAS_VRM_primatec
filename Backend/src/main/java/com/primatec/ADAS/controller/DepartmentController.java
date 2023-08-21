package com.primatec.ADAS.controller;

import com.primatec.ADAS.model.Department;
import com.primatec.ADAS.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable UUID id) {
        departmentService.deleteDepartment(id);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable UUID id, @RequestBody Department updatedDepartment) {
        if (!id.equals(updatedDepartment.getDepartmentId())) {
            throw new IllegalArgumentException("Department id in path variable does not match the id in the request body.");
        }

        return departmentService.updateDepartment(updatedDepartment);
    }

    // Add additional mappings as needed

}
