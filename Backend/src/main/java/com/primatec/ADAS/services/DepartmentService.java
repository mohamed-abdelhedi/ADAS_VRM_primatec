package com.primatec.ADAS.services;

import com.primatec.ADAS.DAO.departmentDAO;
import com.primatec.ADAS.model.Department;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DepartmentService {

    private final departmentDAO departmentDAO;

    @Autowired
    public DepartmentService(departmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public Department saveDepartment(Department department) {
        return departmentDAO.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.findAll();
    }

    public Optional<Department> getDepartmentById(UUID id) {
        return departmentDAO.findById(id);
    }

    public void deleteDepartment(UUID id) {
        departmentDAO.deleteById(id);
    }

    public Department updateDepartment(Department updatedDepartment) {
        Optional<Department> optionalDepartment = departmentDAO.findById(updatedDepartment.getDepartmentId());
        if (optionalDepartment.isPresent()) {
            Department existingDepartment = optionalDepartment.get();
            existingDepartment.setName(updatedDepartment.getName());
            existingDepartment.setLocation(updatedDepartment.getLocation());
            // Update other fields as needed

            return departmentDAO.save(existingDepartment);
        } else {
            throw new EntityNotFoundException("Department with id " + updatedDepartment.getDepartmentId() + " not found.");
        }
    }



}
