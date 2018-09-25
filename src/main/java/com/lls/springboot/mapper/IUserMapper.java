package com.lls.springboot.mapper;

import com.lls.springboot.pojo.UserEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IUserMapper {
    @Insert("insert into user(username, password, email, role) values(#{username}, #{password}, #{email}, #{role})")
    int insert(UserEntity userEntity);

    @Select("select * from user where username = #{username}")
    UserEntity selectByUsername(@Param("username") String username);
}
