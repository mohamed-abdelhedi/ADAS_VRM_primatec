package com.primatec.ADAS.controller;
import com.primatec.ADAS.services.userServices;
import com.primatec.ADAS.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class userController {
    private userServices userServices;

    @Autowired
    public void UserController(userServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody user user) {
        userServices.saveUser(user);
    }
    @GetMapping("/all")
    public List<user> getAllUsers() {
        return userServices.getAllUsers();
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userServices.deleteUser(id);
    }
    @PutMapping("/{id}")
    public user updateUser(@PathVariable UUID id, @RequestBody user updatedUser) {

   //    if (!id.equals(updatedUser.getUser_id())) {
     //      throw new IllegalArgumentException("User id in path variable does not match the id in the request body.");
    //    }

        return userServices.updateUser(updatedUser);
    }



}
