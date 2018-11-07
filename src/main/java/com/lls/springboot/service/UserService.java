package com.lls.springboot.service;


import com.lls.springboot.model.UserDTO;

import java.util.Map;

public interface UserService {

    /**
     * 添加新用户
     *
     * username 唯一， 默认 USER 权限
     * @param userPo
     */
    Map<String, Object> insert(UserDTO userPo);

    /**
     * 查询用户信息
     * @param username 账号
     * @return UserEntity
     */
    UserDTO getByUsername(String username);

    Map login(UserDTO userDTO);

    Map refreshToken(UserDTO userDTO);
}
