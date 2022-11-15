package com.PasswordManager.Service;

import com.PasswordManager.Entity.Account;
import com.PasswordManager.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;


    public Account updateAccount(Account account) {
        Optional<Account> result = accountRepository.findById(account.getId());
        Account existing = result.get();
        existing.setPassword(account.getPassword());
        existing.setWebsite(account.getWebsite());
        return accountRepository.save(existing);
    }
}
