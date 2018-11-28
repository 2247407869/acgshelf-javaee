package com.lls.springboot.controller;

import com.lls.springboot.domain.User;
import com.lls.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;
    /**
     * 该链接注册用户
     */
    @PostMapping("/register")
    public Map login(@RequestParam("email") String email,
                     @RequestParam("username") String username,
                     @RequestParam("password") String password) {
        System.out.println(password);
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        return userService.insert(user);
    }
}
