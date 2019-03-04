package com.thadocizn.shopping_cart.repository;

import com.thadocizn.shopping_cart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String id);

}
