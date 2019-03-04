package com.thadocizn.shopping_cart.repository;

import com.thadocizn.shopping_cart.model.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductList, Long> {
}
