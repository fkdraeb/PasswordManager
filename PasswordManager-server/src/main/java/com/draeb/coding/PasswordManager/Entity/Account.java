package com.draeb.coding.PasswordManager.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "account")
public @Data class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String website;
    @Column(nullable = false)
    private String password;

    public Account() {
    }

}
