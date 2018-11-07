package com.lls.springboot.service.impl;

import com.lls.springboot.dao.UserDao;
import com.lls.springboot.model.UserDTO;
import com.lls.springboot.service.UserService;
import com.lls.springboot.util.JwtTokenUtil;
import org.apache.commons.lang3.StringUtils;
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
    public Map<String, Object> insert(UserDTO userDTO) {
        Map<String, Object> map = new HashMap<>();
        String username = userDTO.getUsername();
        if (exist(username)){
            map.put("status","1");
            map.put("msg", "用户名重复");
            return map;
        }
        encryptPassword(userDTO);
        userDTO.setRoles("ROLE_USER");
        userDao.insert(userDTO);

        map.put("status","0");
        map.put("msg", "Success");
        return map;
    }

    @Override
    public UserDTO getByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public Map login(UserDTO userDTO) {
        Map<String, Object> map = new HashMap<>();
        UserDTO queryedUserDTO = userDao.selectByUsername(userDTO.getUsername());
        if (!new BCryptPasswordEncoder().matches(userDTO.getPassword(),
                queryedUserDTO.getPassword())) {
            map.put("status", 1);
            map.put("msg", "登录失败,用户名密码错误");
            return map;
        }
        map.put("status", 0);
        map.put("msg", "Success");
        map.put("token", jwtTokenUtil.create(queryedUserDTO));
        map.put("username", queryedUserDTO.getUsername());
        return map;
    }

    @Override
    public Map refreshToken(UserDTO userDTO) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 0);
        map.put("msg", "Success");
        map.put("token", jwtTokenUtil.create(userDTO));
        map.put("username", userDTO.getUsername());
        return map;
    }

    /**
     * 判断用户是否存在
     * @param username 账号
     * @return 密码
     */
    private boolean exist(String username){
        UserDTO userDTO = userDao.selectByUsername(username);
        return (userDTO != null);
    }

    /**
     * 加密密码
     * @param userDTO
     */
    private void encryptPassword(UserDTO userDTO){
        String password = userDTO.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        userDTO.setPassword(password);
    }
}
