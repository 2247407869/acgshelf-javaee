package com.lls.springboot.service.impl;

import com.lls.springboot.dao.UserDao;
import com.lls.springboot.model.UserDTO;
import com.lls.springboot.service.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Primary
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public boolean insert(UserDTO userDTO) {
        String username = userDTO.getUsername();
        if (exist(username))
            return false;
        encryptPassword(userDTO);
        userDTO.setRoles("ROLE_USER");
        int result = userDao.insert(userDTO);
        return  result == 1;
    }

    @Override
    public UserDTO getByUsername(String username) {
        return userDao.selectByUsername(username);
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
