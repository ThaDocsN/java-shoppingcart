package com.thadocizn.shopping_cart.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "shipping_address")
    private String shippingAddress;
    @Column(name = "payment_details")
    private String paymentDetails;
    @Column(name = "has_shipped")
    private boolean hasShipped;
    @Column(name = "product_quantity")
    private int productQuantity;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "order")
    private Set<Product> products = new HashSet<>();

    public Order() {
    }

    public Set<Product> getProducts() {
        return products;
    }
}
