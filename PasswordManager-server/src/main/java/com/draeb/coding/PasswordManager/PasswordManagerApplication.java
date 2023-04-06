package com.draeb.coding.PasswordManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Entity;

@SpringBootApplication
@ComponentScan
public class PasswordManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasswordManagerApplication.class, args);
    }

}
