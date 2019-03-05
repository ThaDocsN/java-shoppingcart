package com.thadocizn.shopping_cart.repository;

import com.thadocizn.shopping_cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String name);

}
