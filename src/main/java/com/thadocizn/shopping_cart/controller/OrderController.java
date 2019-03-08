package com.thadocizn.shopping_cart.controller;

import com.thadocizn.shopping_cart.model.Order;
import com.thadocizn.shopping_cart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    @Autowired
    OrderRepository orderRepo;

    @GetMapping(value = "")
    public List<Order> listAllOrders(){
        return orderRepo.findAll();
    }

    // todo come back and update
    @GetMapping(value = "/orders/id/{orderId}")
    public Optional<Order> getProductsByName(@PathVariable long orderId){
        return orderRepo.findById(orderId);
    }
}
