package com.lls.springboot.service;


import com.lls.springboot.domain.User;

import java.util.Map;

public interface UserService {

    /**
     * 添加新用户
     *
     * username 唯一， 默认 USER 权限
     * @param userPo
     */
    Map<String, Object> insert(User userPo);

    /**
     * 查询用户信息
     * @param username 账号
     * @return UserEntity
     */
    User getByUsername(String username);

    Map login(User user);

    Map refreshToken(User user);
}
