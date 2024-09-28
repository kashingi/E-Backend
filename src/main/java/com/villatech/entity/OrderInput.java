package com.villatech.entity;

import lombok.Data;

import java.util.List;

//Add your annotations here
@Data
public class OrderInput {

    private String fullName;
    private String fullAddress;
    private String contactNumber;
    private String alternateContactNumber;
    private List<OrderProductQuantity> orderProductQuantityList;
}
