package com.villatech.service;

import com.villatech.dao.RoleDao;
import com.villatech.dao.UserDao;
import com.villatech.entity.Role;
import com.villatech.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

//Add your annotations here
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {

        Role role = roleDao.findById("User").get();

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRole(roles);

        user.setPassword(getEncodedPassword(user.getPassword()));
        return userDao.save(user);
    }
    public void initRolesAndUser() {
        //set Admin role
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        roleDao.save(adminRole);
        //set User role
        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created records");
        roleDao.save(userRole);

        //automatic create admin
        User adminUser = new User();
        adminUser.setName("Admin");
        adminUser.setUserName("admin@test.com");
        adminUser.setPassword(getEncodedPassword("Admin"));
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        //automatic create user
        User user = new User();
        user.setName("User");
        user.setUserName("user@test.com");
        user.setPassword(getEncodedPassword("User"));
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }

    public String getEncodedPassword(String password) {

        return passwordEncoder.encode(password);
    }

}
