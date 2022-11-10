package com.PasswordManager.Controller;

import com.PasswordManager.Entity.Account;
import com.PasswordManager.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("")
    public ModelAndView homePage(ModelAndView modelAndView) {
        modelAndView.setViewName("homepage.html");
        return modelAndView;
    }

    @PostMapping("/process_account")
    public ModelAndView processAccount(ModelAndView modelAndView, Account account) {
        accountRepository.save(account);
        modelAndView.setViewName("new-account.html");
        return modelAndView;
    }

    @GetMapping("/register-account")
    public ModelAndView registerAccount(ModelAndView modelAndView) {
        modelAndView.addObject("account", new Account());
        modelAndView.setViewName("new-account.html");
        return modelAndView;
    }

    @GetMapping("/accounts")
    public ModelAndView listAccounts(ModelAndView modelAndView) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        List<Account> listAccounts = accountRepository.findByEmail(name);
        modelAndView.addObject("listAccounts", listAccounts);
        modelAndView.setViewName("accounts.html");
        return modelAndView;
    }

}
