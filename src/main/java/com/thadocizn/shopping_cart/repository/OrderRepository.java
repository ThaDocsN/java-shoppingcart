package com.thadocizn.shopping_cart.repository;

import com.thadocizn.shopping_cart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
