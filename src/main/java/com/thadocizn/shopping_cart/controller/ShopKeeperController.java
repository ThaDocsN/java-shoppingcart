package com.thadocizn.shopping_cart.controller;

import com.thadocizn.shopping_cart.model.Order;
import com.thadocizn.shopping_cart.model.Product;
import com.thadocizn.shopping_cart.model.Supplier;
import com.thadocizn.shopping_cart.repository.OrderRepository;
import com.thadocizn.shopping_cart.repository.ProductRepository;
import com.thadocizn.shopping_cart.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ShopKeeperController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    SupplierRepository supplierRepo;

    @GetMapping("/shopkeeper/orders")
    public List<Order> getAllOrders(){
        List<Order> tempList = orderRepo.findAll();
        if(tempList != null){
            return tempList;
        }
        return null;
    }

    @PostMapping("/shopkeeper/product")
    public Product addProduct(@RequestBody Product product){
        return productRepo.save(product);
    }

    @PutMapping("/shopkeeper/product/{productid}")
    public Product updateProductById(@RequestBody Product newProduct, @PathVariable long productid) throws URISyntaxException {
        Optional<Product> productToUpdate = productRepo.findById(productid);
        if (productToUpdate.isPresent()) {
            newProduct.setProductId(productid);
            productRepo.save(newProduct);
            return newProduct;
        }
        return null;
    }

    @DeleteMapping("/shopkeeper/product/{productid}")
    public Product deleteProductById(@PathVariable long productid) {
        var foundProduct = productRepo.findById(productid);
        if (foundProduct.isPresent()) {
            productRepo.deleteById(productid);
            return foundProduct.get();
        }
        return null;
    }

    @PutMapping("/shopkeeper/supplier/{supplierid}")
    public Supplier updateSupplierById(@RequestBody Supplier newSupplier, @PathVariable long supplierid) throws URISyntaxException {
        Optional<Supplier> updateSupplier = supplierRepo.findById(supplierid);
        if (updateSupplier.isPresent()) {
            newSupplier.setSupplierId(supplierid);
            supplierRepo.save(newSupplier);
            return newSupplier;
        }
        return null;
    }

}
