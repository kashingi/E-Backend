package com.villatech.dao;

import com.villatech.entity.Cart;
import com.villatech.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Add your annotations here
@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
    public List<Cart> findByUser(User user);
}
