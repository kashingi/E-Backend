package com.villatech.controller;

import com.villatech.entity.Role;
import com.villatech.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Add your annotations here
@RestController
@RequestMapping(path = "/api/v1")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(path = "/createRole")
    public Role createRole(@RequestBody Role role) {
      return roleService.createRole(role);
    }
}
