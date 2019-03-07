package com.thadocizn.shopping_cart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private long supplierId;

    private String name;

    @ManyToMany
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("suppliers")
    private Set<Product> supplier_products;

    public Supplier() {
    }

    public Set<Product> getSupplier_products() {
        return supplier_products;
    }


}
