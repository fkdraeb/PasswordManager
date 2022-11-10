package com.PasswordManager.Controller;

import com.PasswordManager.Entity.User;
import com.PasswordManager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public ModelAndView registerPage(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("sign-up.html");
        return modelAndView;
    }

    @PostMapping("/process_register")
    public ModelAndView processRegister(ModelAndView modelAndView, User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        modelAndView.setViewName("sign-up.html");
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView listUsers(ModelAndView modelAndView) {
        List<User> listUsers = userRepository.findAll();
        modelAndView.addObject("listUsers", listUsers);
        modelAndView.setViewName("users.html");
        return modelAndView;
    }
}
