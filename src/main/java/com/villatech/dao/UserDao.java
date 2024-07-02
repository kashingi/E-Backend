package com.villatech.dao;

import com.villatech.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//add your annotations here
@Repository
public interface UserDao extends JpaRepository<User, String> {
}
