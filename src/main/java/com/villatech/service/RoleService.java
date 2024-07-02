package com.villatech.service;

import com.villatech.dao.RoleDao;
import com.villatech.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Add your annotations here
@Service
public class RoleService {
    @Autowired
    private RoleDao roleDao;

    public Role createRole(Role role) {
        return roleDao.save(role);
    }
}
