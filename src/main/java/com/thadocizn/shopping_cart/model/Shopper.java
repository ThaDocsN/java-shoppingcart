package com.thadocizn.shopping_cart.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer")
public class Shopper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopper_id")
    private long shopperId;

    @Column(name = "bill_address")
    private String billAddress;
    @Column(name = "ship_address")
    private String shipAddress;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "payment_method")
    private String paymentMethod;

    public Shopper() {
    }

}
