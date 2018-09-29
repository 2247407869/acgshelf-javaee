package com.lls.springboot.service.impl;

import com.lls.springboot.dao.IUserDao;
import com.lls.springboot.model.UserPo;
import com.lls.springboot.service.IUserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserService implements IUserService {

    private final IUserDao userDao;

    public UserService(IUserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public boolean insert(UserPo userPo) {
        String username = userPo.getUsername();
        if (exist(username))
            return false;
        userPo.setRoles("ROLE_USER");
        int result = userDao.insert(userPo);
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

}
