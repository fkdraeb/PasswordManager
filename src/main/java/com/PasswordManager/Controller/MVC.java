package com.PasswordManager.Controller;

import com.PasswordManager.Entity.User;
import com.PasswordManager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MVC {


    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public ModelAndView homePage(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("homepage.html");
        return modelAndView;
    }


}
