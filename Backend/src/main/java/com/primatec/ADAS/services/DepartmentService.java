package com.primatec.ADAS.services;

import com.primatec.ADAS.DAO.departmentDAO;
import com.primatec.ADAS.model.Department;
import com.primatec.ADAS.DAO.usersDAO;
import com.primatec.ADAS.model.User.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentService {

    private final departmentDAO departmentDAO;
    private final usersDAO usersDAO;

    @Autowired
    public DepartmentService(departmentDAO departmentDAO,usersDAO usersDAO) {

        this.departmentDAO = departmentDAO;
        this.usersDAO = usersDAO;
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
        Optional<Department> optionalDepartment = departmentDAO.findById(updatedDepartment.getDepartment_id());
        if (optionalDepartment.isPresent()) {
            Department existingDepartment = optionalDepartment.get();
            existingDepartment.setName(updatedDepartment.getName());
            existingDepartment.setLocation(updatedDepartment.getLocation());
            // Update other fields as needed

            return departmentDAO.save(existingDepartment);
        } else {
            throw new EntityNotFoundException("Department with id " + updatedDepartment.getDepartment_id() + " not found.");
        }
    }



}
