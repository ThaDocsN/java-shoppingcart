package com.thadocizn.shopping_cart.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer")
public class Shopper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shopperId;

    private String billAddress;
    private String shipAddress;
    private String phoneNumber;
    private String paymentMethod;

    public Shopper() {
    }

}
