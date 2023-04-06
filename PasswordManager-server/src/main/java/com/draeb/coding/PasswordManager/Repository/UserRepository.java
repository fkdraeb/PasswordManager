package com.draeb.coding.PasswordManager.Repository;

import com.draeb.coding.PasswordManager.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);

}
