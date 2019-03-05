package com.thadocizn.shopping_cart.controller;

import com.thadocizn.shopping_cart.model.Supplier;
import com.thadocizn.shopping_cart.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "suppliers/", produces = MediaType.APPLICATION_JSON_VALUE)
public class SupplierController {

    @Autowired
    SupplierRepository supplierRepo;

    @GetMapping(value = "")
    public List<Supplier> listAllSuppliers(){
        return supplierRepo.findAll();
    }

    @GetMapping(value = "/suppliers/name/{supplierName}")
    public Supplier getProductsByName(@PathVariable String supplierName){
        return supplierRepo.findByName(supplierName);
    }
}
