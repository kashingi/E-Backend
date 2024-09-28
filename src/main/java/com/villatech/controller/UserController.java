package com.villatech.controller;

import com.villatech.entity.User;
import com.villatech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

//Add your annotations here
@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRolesAndUsers() {

        userService.initRolesAndUser();
    }

    @PostMapping(path = "/registerUser")
    public User registerUser(@RequestBody User user) {

        return userService.registerUser(user);
    }

    @GetMapping(path = "/forAdmin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin() {

        return "This URL is only accessible by the admin";
    }
    @GetMapping(path = "/forUser")
    @PreAuthorize("hasRole('User')")
    public String forUser() {

        return "This URL is only accessible to the user";
    }
}
