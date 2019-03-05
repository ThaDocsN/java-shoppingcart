package com.thadocizn.shopping_cart.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    private String productName;
    private String shippingAddress;
    private String paymentDetails;
    private boolean hasShipped;
    private int productQuantity;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "order")
    private Set<Product> products = new HashSet<>();

    public Order() {
    }

    public Set<Product> getProducts() {
        return products;
    }
}
