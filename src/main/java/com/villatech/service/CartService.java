package com.villatech.service;

import com.villatech.configuration.JwtRequestFilter;
import com.villatech.dao.CartDao;
import com.villatech.dao.ProductDao;
import com.villatech.dao.UserDao;
import com.villatech.entity.Cart;
import com.villatech.entity.Product;
import com.villatech.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//Add your annotations here
@Service
public class CartService {
    //Inject other classes here
    @Autowired
    private CartDao cartDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;

    public Cart addToCart(Integer productId) {
        Product product = productDao.findById(productId).get();
        String username = JwtRequestFilter.CURRENT_USER;

        User user = null;
        if (username != null) {
            user = userDao.findById(username).get();
        }

        List<Cart> cartList = cartDao.findByUser(user);
        List<Cart> filteredList = cartList.stream().filter(x -> x.getProduct().getProductId() == productId).collect(Collectors.toList());

        if (!filteredList.isEmpty()) {
            return null;
        }
        if (product != null && user != null) {
            Cart cart = new Cart(product, user);
            return cartDao.save(cart);
        }
        return null;
    }

    public List<Cart> getCartDetails() {
        String username = JwtRequestFilter.CURRENT_USER;
        User user = userDao.findById(username).get();
        return cartDao.findByUser(user);
    }

    public void deleteCartItem(Integer cartId){
        cartDao.deleteById(cartId);
    }
}
