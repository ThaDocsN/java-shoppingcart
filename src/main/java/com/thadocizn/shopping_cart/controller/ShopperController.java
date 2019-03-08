package com.thadocizn.shopping_cart.controller;

import com.thadocizn.shopping_cart.model.Shopper;
import com.thadocizn.shopping_cart.repository.ShopperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shoppers", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShopperController {

    @Autowired
    ShopperRepository shopperRepo;

    @GetMapping(value = "")
    public List<Shopper> listAllShoppers(){
        return shopperRepo.findAll();
    }

    @GetMapping(value = "/shoppers/name/{shopperName}")
    public Shopper getProductsByName(@PathVariable String shopperName){
        return shopperRepo.findByName(shopperName);
    }
}