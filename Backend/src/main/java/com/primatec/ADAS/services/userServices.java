package com.primatec.ADAS.services;

import com.primatec.ADAS.DAO.usersDAO;
import com.primatec.ADAS.model.User.User;
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
    public void saveUser(User user) {
        userDao.save(user);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return userDao.findById(id);
    }
    public void deleteUser(UUID id) {
        userDao.deleteById(id);
    }
    public User updateUser(User updatedUser) {
        // Check if the user exists in the database
        Optional<User> optionalUser = userDao.findById(updatedUser.getUser_id());
        if (optionalUser.isPresent()) {
            // Update the existing user with the new data
            User existingUser = optionalUser.get();
            existingUser.setFirstname(updatedUser.getFirstname());
            existingUser.setLastname(updatedUser.getLastname());
            existingUser.setBirthdate(updatedUser.getBirthdate());
            existingUser.setExperience(updatedUser.getExperience());
            existingUser.setJoinDate(updatedUser.getJoinDate());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setDescription(updatedUser.getDescription());
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
