package com.villatech.service;

import com.villatech.configuration.JwtRequestFilter;
import com.villatech.dao.CartDao;
import com.villatech.dao.ProductDao;
import com.villatech.dao.UserDao;
import com.villatech.entity.Cart;
import com.villatech.entity.Product;
import com.villatech.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Add your annotations here
@Service
public class ProductService {

    //Inject other classes here
    @Autowired
    private ProductDao productDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CartDao cartDao;

    public Product addProduct(Product product) {

        return productDao.save(product);
    }

   public List<Product> getAllProducts(int pageNumber, String searchKey) {
       Pageable pageable = PageRequest.of(pageNumber, 4);
       //return (List<Product>) productDao.findAll(pageable);
       Page<Product> productPage = productDao.findAll(pageable); // Get the paginated result
       if (searchKey.equals("")) {
           return productPage.getContent();
       } else {
           return productDao.findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(
                   searchKey, searchKey, pageable
           );
       }

   }

   public Product getProductDetailsById(Integer productId) {

        return productDao.findById(productId).get();
   }

   public void deleteProductDetails(Integer productId) {

        productDao.deleteById(productId);
   }
   public List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId) {
        if (isSingleProductCheckout && productId != 0) {
            //we are going to buy a single product
            List<Product> list = new ArrayList<>();
            Product product = productDao.findById(productId).get();
            list.add(product);
            return list;
        }else {
            //We are going to checkout the entire cart
            String username = JwtRequestFilter.CURRENT_USER;
            User user = userDao.findById(username).get();
            List<Cart> carts = cartDao.findByUser(user);

            return carts.stream().map(x -> x.getProduct()).collect(Collectors.toList());
        }

   }
}
