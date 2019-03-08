package com.thadocizn.shopping_cart.controller;

import com.thadocizn.shopping_cart.model.Product;
import com.thadocizn.shopping_cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    @GetMapping(value = "")
    public List<Product> listAllProducts(){
        return productRepo.findAll();
    }

    @GetMapping(value = "/products/name/{productName}")
    public Product getProductsByName(@PathVariable String productName){
        return productRepo.findByProductName(productName);
    }
}
