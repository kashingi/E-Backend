package com.villatech.controller;

import com.villatech.entity.Cart;
import com.villatech.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Add your annotations here
@RestController
@RequestMapping(path = "/api/v1")
public class CartController {

    //Add your Auto wires here
    @Autowired
    private CartService cartService;

    @PreAuthorize("hasRole('User')")
    @GetMapping(path = "/addToCart/{productId}")
    public Cart addToCart(@PathVariable(name = "productId") Integer productId) {
        return cartService.addToCart(productId);
    }

    @PreAuthorize("hasRole('User')")
    @GetMapping(path = "/getCartDetails")
    public List<Cart> getCartDetails() {
        return cartService.getCartDetails();
    }

    @PreAuthorize("hasRole('User')")
    @DeleteMapping(path = "/deleteCartItem/{cartId}")
    public void deleteCartItem(@PathVariable(name = "cartId") Integer cartId) {
        cartService.deleteCartItem(cartId);
    }
}
