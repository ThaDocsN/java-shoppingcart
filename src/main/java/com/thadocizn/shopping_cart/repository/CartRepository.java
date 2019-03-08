package com.thadocizn.shopping_cart.repository;

import com.thadocizn.shopping_cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByName(String name);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO shoppingcart.cart (product_id, quantity) VALUES (:product_id, :quantity)", nativeQuery = true)
    void addProduct(long product_id, int quantity);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM shoppingcart.cart WHERE product_id = :product_id", nativeQuery = true)
    void removeProduct(long product_id);
}
