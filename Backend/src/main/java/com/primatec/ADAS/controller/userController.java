package com.primatec.ADAS.controller;
import com.primatec.ADAS.DAO.usersDAO;
import com.primatec.ADAS.model.User.User;
import com.primatec.ADAS.services.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/users")

public class userController {
    private userServices userServices;
    private usersDAO  usersDAO;

    @Autowired
    public void UserController(userServices userServices,usersDAO usersDAO) {
        this.userServices = userServices;
        this.usersDAO=usersDAO;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
        userServices.saveUser(user);
    }
    @CrossOrigin
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userServices.getAllUsers();
    }
    @CrossOrigin
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserProfile(@PathVariable UUID userId) {
        Optional<User> user = userServices.getUserById(userId);

        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userServices.deleteUser(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User updatedUser) {

       //if (!id.equals(updatedUser.getUser_id())) {
     //      throw new IllegalArgumentException("User id in path variable does not match the id in the request body.");
    //    }

        return userServices.updateUser(updatedUser);
    }

    @GetMapping("/sum")
    public Number getSum() {
        return usersDAO.SumUsers();
    }


}
