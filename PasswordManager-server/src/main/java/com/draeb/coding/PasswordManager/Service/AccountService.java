package com.draeb.coding.PasswordManager.Service;

import com.draeb.coding.PasswordManager.Entity.Account;
import com.draeb.coding.PasswordManager.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account updateAccount(Account account) {
        Optional<Account> result = accountRepository.findById(account.getId());
        Account existing = result.get();
        existing.setPassword(encodePassword(account.getPassword()));
        existing.setWebsite(account.getWebsite());
        return accountRepository.save(existing);
    }

    public String encodePassword (String rawPassword) {
        return Base64.getEncoder().encodeToString(rawPassword.getBytes());
    }

    public String decodePassword (String encodedPassword) {
        return new String(Base64.getDecoder().decode(encodedPassword));
    }

    public List<Account> accountsList (String authenticatedUser) {
        List<Account> listAccounts = accountRepository.findByEmail(authenticatedUser);

        for (Account listAccount : listAccounts) {
            String decodedPassword = new String(Base64.getDecoder().decode(listAccount.getPassword()));
            listAccount.setPassword(decodedPassword);
        }
        return listAccounts;
    }
}
