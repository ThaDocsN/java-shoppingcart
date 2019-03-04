package com.thadocizn.shopping_cart.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Order {

    private String productName;
    private String shippingAddress;
    private String paymentDetails;
    private boolean hasShipped;
    private int productQuantity;

    public Order() {
    }
}
