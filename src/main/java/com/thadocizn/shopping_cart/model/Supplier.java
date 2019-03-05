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
    private long id;

    private String name;

    @ManyToMany
    @JoinColumn(name = "id")
    @JsonIgnoreProperties("suppliers")
    private Set<ProductList> supplier_products;

    public Supplier() {
    }

    public Set<ProductList> getSupplier_products() {
        return supplier_products;
    }


}
