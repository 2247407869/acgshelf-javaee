package com.lls.springboot.controller;

import com.lls.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

}
