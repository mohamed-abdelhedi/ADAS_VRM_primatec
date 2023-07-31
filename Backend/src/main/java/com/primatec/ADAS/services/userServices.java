package com.primatec.ADAS.services;

import com.primatec.ADAS.DAO.usersDAO;
import com.primatec.ADAS.model.user;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class userServices {
    private final usersDAO userDao;

    @Autowired
    public userServices(usersDAO userDao) {
        this.userDao = userDao;
    }
    public void saveUser(user user) {
        userDao.save(user);
    }

    public List<user> getAllUsers() {
        return userDao.findAll();
    }

    public Optional<user> getUserById(UUID id) {
        return userDao.findById(id);
    }
    public void deleteUser(UUID id) {
        userDao.deleteById(id);
    }
    public user updateUser(user updatedUser) {
        // Check if the user exists in the database
        Optional<user> optionalUser = userDao.findById(updatedUser.getUser_id());
        if (optionalUser.isPresent()) {
            // Update the existing user with the new data
            user existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setBirthdate(updatedUser.getBirthdate());
            existingUser.setExperience(updatedUser.getExperience());
            existingUser.setDomain(updatedUser.getDomain());
            existingUser.setDepartment(updatedUser.getDepartment());
            existingUser.setJoinDate(updatedUser.getJoinDate());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setDescription(updatedUser.getDescription());
            existingUser.setTools(updatedUser.getTools());
            existingUser.setTechnologies(updatedUser.getTechnologies());
            existingUser.setImgLink(updatedUser.getImgLink());
            existingUser.setPhone_number(updatedUser.getPhone_number());

            // Save the updated user to the database
            return userDao.save(existingUser);
        } else {
            // User not found, throw an exception or handle the error accordingly
            throw new EntityNotFoundException("User with id " + updatedUser.getUser_id() + " not found.");
        }
    }
}
