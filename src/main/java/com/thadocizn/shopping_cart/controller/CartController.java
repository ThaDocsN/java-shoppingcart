package com.thadocizn.shopping_cart.controller;

import com.thadocizn.shopping_cart.model.Cart;
import com.thadocizn.shopping_cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/carts", produces = MediaType.APPLICATION_JSON_VALUE)
public class CartController {

    @Autowired
    CartRepository cartRepo;

    @GetMapping(value = "")
    public List<Cart> listAllCarts(){
        return cartRepo.findAll();
    }

    @GetMapping(value = "/carts/name/{cartName}")
    public Cart getCartByName(@PathVariable String cartName){
        return cartRepo.findByName(cartName);
    }
}
