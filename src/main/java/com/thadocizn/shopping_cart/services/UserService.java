package com.thadocizn.shopping_cart.services;

import com.thadocizn.shopping_cart.model.User;

import java.util.List;
public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}