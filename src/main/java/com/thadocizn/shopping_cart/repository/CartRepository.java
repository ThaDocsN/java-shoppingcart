package com.thadocizn.shopping_cart.repository;

import com.thadocizn.shopping_cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
