package com.thadocizn.shopping_cart.controller;

import com.thadocizn.shopping_cart.model.User;
import com.thadocizn.shopping_cart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {


    @Autowired
    UserRepository userRepo;

    @GetMapping("/admin/users")
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @PutMapping("/admin/user/{userid}")
    public User updateUser(@RequestBody User newUser, @PathVariable long userid) throws URISyntaxException {
        Optional<User> userToUpdate = userRepo.findById(userid);
        if (userToUpdate.isPresent()) {
            newUser.setUserId(userid);
            userRepo.save(newUser);
            return newUser;
        }
        return null;
    }

    @DeleteMapping("/admin/user/{userid}")
    public User deleteUserById(@PathVariable long userid) {
        var foundUser = userRepo.findById(userid);
        if (foundUser.isPresent()) {
            userRepo.deleteById(userid);
            return foundUser.get();
        }
        return null;
    }

}
