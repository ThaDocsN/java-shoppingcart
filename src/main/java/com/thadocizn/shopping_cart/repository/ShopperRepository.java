package com.thadocizn.shopping_cart.repository;

import com.thadocizn.shopping_cart.model.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopperRepository extends JpaRepository<Shopper, Long> {
    Shopper findByName(String name);

}
