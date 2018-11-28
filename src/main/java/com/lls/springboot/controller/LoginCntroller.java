package com.lls.springboot.controller;

import com.lls.springboot.domain.User;
import com.lls.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

/**
 * @author Niu Li
 * @since 2017/6/19
 */
@RestController
public class LoginCntroller {


    @Autowired
    private UserService userService;

    /**
     * 该链接获取token
     */
    @PostMapping("/login")
    public Map login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userService.login(user);
    }

    /**
     * 该链接尝试获取登录用户,返回该认证用户的信息,请求该链接需要在header中放入x-authorization: token
     */
    @GetMapping("/refreshToken")
    public Map userDetail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication)) {
            return null;
        }
        User user = (User) authentication.getDetails();
        return userService.refreshToken(user);
    }

}
