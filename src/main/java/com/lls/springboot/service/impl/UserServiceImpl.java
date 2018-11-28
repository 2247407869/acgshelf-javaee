package com.lls.springboot.service.impl;

import com.lls.springboot.dao.UserDao;
import com.lls.springboot.domain.User;
import com.lls.springboot.service.UserService;
import com.lls.springboot.util.JwtTokenUtil;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
@Primary
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    @Resource
    private JwtTokenUtil jwtTokenUtil;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public Map<String, Object> insert(User user) {
        Map<String, Object> map = new HashMap<>();
        String username = user.getUsername();
        if (exist(username)){
            map.put("status","1");
            map.put("msg", "用户名重复");
            return map;
        }
        encryptPassword(user);
        user.setRoles("ROLE_USER");
        userDao.insert(user);

        map.put("status","0");
        map.put("msg", "Success");
        return map;
    }

    @Override
    public User getByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public Map login(User user) {
        Map<String, Object> map = new HashMap<>();
        User queryedUser = userDao.selectByUsername(user.getUsername());
        if (!new BCryptPasswordEncoder().matches(user.getPassword(),
                queryedUser.getPassword())) {
            map.put("status", 1);
            map.put("msg", "登录失败,用户名密码错误");
            return map;
        }
        map.put("status", 0);
        map.put("msg", "Success");
        map.put("token", jwtTokenUtil.create(queryedUser));
        map.put("username", queryedUser.getUsername());
        return map;
    }

    @Override
    public Map refreshToken(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 0);
        map.put("msg", "Success");
        map.put("token", jwtTokenUtil.create(user));
        map.put("username", user.getUsername());
        return map;
    }

    /**
     * 判断用户是否存在
     * @param username 账号
     * @return 密码
     */
    private boolean exist(String username){
        User user = userDao.selectByUsername(username);
        return (user != null);
    }

    /**
     * 加密密码
     * @param user
     */
    private void encryptPassword(User user){
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
    }
}
