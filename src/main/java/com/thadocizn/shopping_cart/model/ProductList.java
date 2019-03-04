package com.thadocizn.shopping_cart.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table
public class ProductList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;
    private double price;
    private int quantity;

    public ProductList() {
    }
}
