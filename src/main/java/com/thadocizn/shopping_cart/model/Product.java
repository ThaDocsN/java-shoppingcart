package com.thadocizn.shopping_cart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;

    @ManyToOne
    @JoinColumn(name ="order_id")
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name ="cart_id")
    @JsonIgnore
    private Cart cart;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    @JsonIgnoreProperties("products")
    private Set<Supplier> suppliers = new HashSet<>();

    private String name;
    private String description;
    private double price;
    private int quantity;

    public Product() {
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

}
