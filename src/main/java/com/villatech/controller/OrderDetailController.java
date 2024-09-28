package com.villatech.controller;

import com.villatech.entity.OrderDetail;
import com.villatech.entity.OrderInput;
import com.villatech.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Add your annotations here
@RestController
@RequestMapping(path = "/api/v1")
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @PreAuthorize("hasRole('User')")
    @PostMapping(path = "/placeOrder/{isSingleProductCheckout}")
    public void placeOrder(@PathVariable(name = "isSingleProductCheckout" )  boolean isSingleProductCheckout,
            @RequestBody OrderInput orderInput) {

        orderDetailService.placeOrder(orderInput, isSingleProductCheckout);
    }

    @PreAuthorize("hasRole('User')")
    @GetMapping(path = "/getOrderDetails")
    public List<OrderDetail> getOrderDetails() {
        return orderDetailService.getOrderDetails();
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping(path = "/getAllOrderDetails/{status}")
    public List<OrderDetail> getAllOrderDetails(@PathVariable(name = "status") String status) {
        return orderDetailService.getAllOrderDetails(status);
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping(path = "/markOrderAsDelivered/{orderId}")
    public void markOrderAsDelivered(@PathVariable(name = "orderId") Integer orderId) {
        orderDetailService.markOrderAsDelivered(orderId);
    }
}
