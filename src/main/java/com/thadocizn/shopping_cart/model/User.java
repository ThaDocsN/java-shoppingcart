package com.thadocizn.shopping_cart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue
    private long userId;

    private String username;

    @JsonIgnore
    private String password;

    private String roles;

    public User() {
    }

    public List<SimpleGrantedAuthority> getAuthority(){
        String role = "ROLE_" + this.roles.toUpperCase();
        return Arrays.asList(new SimpleGrantedAuthority(role));
    }

}
