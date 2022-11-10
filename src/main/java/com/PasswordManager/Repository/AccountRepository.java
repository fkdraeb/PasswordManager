package com.PasswordManager.Repository;

import com.PasswordManager.Entity.Account;
import com.PasswordManager.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Account a WHERE a.email = ?1")
    public List<Account> findByEmail(String email);

}