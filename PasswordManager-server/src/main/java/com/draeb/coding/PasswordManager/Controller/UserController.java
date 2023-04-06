package com.draeb.coding.PasswordManager.Controller;


import com.draeb.coding.PasswordManager.Entity.User;
import com.draeb.coding.PasswordManager.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {

    //@Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public ModelAndView registerPage(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("sign-up.html");
        return modelAndView;
    }

    @PostMapping("/process_register")
    public ModelAndView processRegister(ModelAndView modelAndView, User user) {

        //Verifica se já existe algum user na BD, caso exista emite um alerta que vai ser "buscado" pelo Thymeleaf
        String verifyUser = user.getEmail();
        if (userRepository.findByEmail(verifyUser) != null) {
            modelAndView.addObject("verifyUser", verifyUser);
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            userRepository.save(user);
            this.userRepository.flush();
        }
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
