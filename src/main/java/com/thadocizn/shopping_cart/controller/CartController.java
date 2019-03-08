package com.thadocizn.shopping_cart.controller;

import com.thadocizn.shopping_cart.model.Cart;
import com.thadocizn.shopping_cart.model.Product;
import com.thadocizn.shopping_cart.repository.CartRepository;
import com.thadocizn.shopping_cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CartController {

    @Autowired
    CartRepository cartRepo;

    @Autowired
    ProductRepository productRepo;

    @GetMapping(value = "")
    public List<Cart> listAllCarts(){
        return cartRepo.findAll();
    }

    @GetMapping(value = "/carts/name/{cartName}")
    public Cart getCartByName(@PathVariable String cartName){
        return cartRepo.findByName(cartName);
    }

    @PostMapping("/cart/add/{productid}")
    public Product addProduct(@RequestHeader int quantity, @PathVariable long productid){
        cartRepo.addProduct(productid, quantity);
        return productRepo.findById(productid).orElseThrow();
    }

    @DeleteMapping("/cart/remove/{productid}")
    public Product deleteProductById(@PathVariable long productid) {
        var foundProduct = productRepo.findById(productid);
        if (foundProduct.isPresent()) {
            cartRepo.removeProduct(productid);
            return foundProduct.get();
        }
        return null;
    }


}
