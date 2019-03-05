package com.thadocizn.shopping_cart.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;

    private String name;
    private int quantity;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "cart")
    private Set<ProductList> products = new HashSet<>();
    public Cart() {
    }
    public Set<ProductList> getProducts() {
        return products;
    }
}
