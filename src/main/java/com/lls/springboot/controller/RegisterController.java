package com.lls.springboot.controller;

import com.google.common.collect.Lists;
import com.lls.springboot.model.TokenUserDTO;
import com.lls.springboot.model.UserPo;
import com.lls.springboot.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private UserService userService;
    /**
     * 该链接获取token
     */
    @GetMapping("/register")
    public Map login(String email, String username, String password) {
        Map<String, Object> map = new HashMap<>();
        TokenUserDTO tokenUserDTO = new TokenUserDTO();
        tokenUserDTO.setEmail(email);
        tokenUserDTO.setUsername(username);
        tokenUserDTO.setPassword(password);
        userService.insert(tokenUserDTO);
        return map;
    }
}
