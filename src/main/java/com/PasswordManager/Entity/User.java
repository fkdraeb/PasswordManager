package com.PasswordManager.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="user")
public @Data class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (nullable = false, unique = true)
    private String email;
    @Column (nullable = false)
    private String password;
    @Column (nullable = false)
    private String firstName;
    @Column (nullable = false)
    private String lastName;

    public User(Integer id, String email, String password, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }
}
