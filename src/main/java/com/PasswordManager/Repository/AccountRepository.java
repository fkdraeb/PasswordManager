package com.PasswordManager.Repository;

import com.PasswordManager.Entity.Account;
import com.PasswordManager.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT a FROM Account a WHERE a.email = ?1")
    public List<Account> findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE account a SET a.website = :website, a.password = :password where a.id = :id", nativeQuery = true)
    void editAccount(@Param("id") int id, @Param("website") String website, @Param("password") String password);

}