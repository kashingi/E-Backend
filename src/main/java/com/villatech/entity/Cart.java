package com.villatech.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Add your annotations here
@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;
    @OneToOne
    private Product product;
    @OneToOne
    private User user;


    public Cart(Product product, User user) {
        this.product = product;
        this.user = user;
    }
}
