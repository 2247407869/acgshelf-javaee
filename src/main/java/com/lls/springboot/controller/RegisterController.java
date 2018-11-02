package com.lls.springboot.controller;

import com.lls.springboot.model.UserDTO;
import com.lls.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;
    /**
     * 该链接注册用户
     */
    @PostMapping("/register")
    public Map login(String email, String username, String password) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(email);
        userDTO.setUsername(username);
        userDTO.setPassword(password);
        return userService.insert(userDTO);
    }
}
