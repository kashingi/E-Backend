package com.villatech.dao;

import com.villatech.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Add your annotations here
@Repository
public interface RoleDao extends JpaRepository<Role, String> {
}
