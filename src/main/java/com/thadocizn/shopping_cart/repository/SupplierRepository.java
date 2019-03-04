package com.thadocizn.shopping_cart.repository;

import com.thadocizn.shopping_cart.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
