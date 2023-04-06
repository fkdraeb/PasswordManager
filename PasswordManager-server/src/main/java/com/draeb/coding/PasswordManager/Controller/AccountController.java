package com.draeb.coding.PasswordManager.Controller;

import com.draeb.coding.PasswordManager.Entity.Account;
import com.draeb.coding.PasswordManager.Repository.AccountRepository;
import com.draeb.coding.PasswordManager.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Base64;
import java.util.List;

@RestController
public class AccountController {

    //@Autowired
    private AccountRepository accountRepository;

    //@Autowired
    private AccountService accountService;


    public AccountController(AccountRepository accountRepository, AccountService accountService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    @GetMapping("/")
    public ModelAndView homePage(ModelAndView modelAndView) {
        System.out.println();
        modelAndView.setViewName("homepage.html");
        return modelAndView;
    }

    @GetMapping("/register-account")
    public ModelAndView registerAccount(ModelAndView modelAndView) {
        modelAndView.addObject("account", new Account());
        modelAndView.setViewName("new-account.html");
        return modelAndView;
    }

    @PostMapping("/process_account")
    public ModelAndView processAccount(ModelAndView modelAndView, Account account, Authentication auth) {
        account.setEmail(auth.getName());

        //account.setPassword(Base64.getEncoder().encodeToString(account.getPassword().getBytes()));
        accountRepository.save(account);
        accountRepository.flush();
        modelAndView.setViewName("redirect:/accounts");
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

    @GetMapping("/edit/{id}")
    public ModelAndView editAccount(@PathVariable("id") int id, ModelAndView modelAndView) {
        modelAndView.addObject("account", accountRepository.findById(id));
        modelAndView.setViewName("edit-account.html");
        return modelAndView;
    }

    @PostMapping("/process_edit")
    public ModelAndView realEditAccount(Account account, ModelAndView modelAndView, Authentication auth) {
        account.setEmail(auth.getName());
        accountService.updateAccount(account);
        modelAndView.setViewName("redirect:/accounts");
        return modelAndView;
    }


    @GetMapping("/delete/{id}")
    public ModelAndView deleteAccount(@PathVariable("id") int id, ModelAndView modelAndView) {
        accountRepository.deleteById(id);
        modelAndView.setViewName("redirect:/accounts");
        return modelAndView;
    }

}
