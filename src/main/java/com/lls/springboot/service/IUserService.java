package com.lls.springboot.service;


import com.lls.springboot.model.UserPo;

public interface IUserService {

    /**
     * 添加新用户
     *
     * username 唯一， 默认 USER 权限
     */
    boolean insert(UserPo userPo);

    /**
     * 查询用户信息
     * @param username 账号
     * @return UserEntity
     */
    UserPo getByUsername(String username);

}
