package com.lls.springboot.service.impl;

import com.lls.springboot.dao.UserDao;
import com.lls.springboot.model.TokenUserDTO;
import com.lls.springboot.model.UserPo;
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
    public boolean insert(TokenUserDTO tokenUserDTO) {
        String username = tokenUserDTO.getUsername();
        if (exist(username))
            return false;
        encryptPassword(tokenUserDTO);
        tokenUserDTO.setRoles(Collections.singletonList("ROLE_USER"));
        int result = userDao.insert(tokenUserDTO);
        return  result == 1;
    }

    @Override
    public UserPo getByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    /**
     * 判断用户是否存在
     * @param username 账号
     * @return 密码
     */
    private boolean exist(String username){
        UserPo userPo = userDao.selectByUsername(username);
        return (userPo != null);
    }

    /**
     * 加密密码
     * @param userPo
     */
    private void encryptPassword(TokenUserDTO userPo){
        String password = userPo.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        userPo.setPassword(password);
    }
}
