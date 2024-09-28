package com.villatech.dao;

import com.villatech.entity.OrderDetail;
import com.villatech.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Add your annotations here
public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer> {
    public List<OrderDetail> findByUser(User user);

    public List<OrderDetail> findByOrderStatus(String status);
}
