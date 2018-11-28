package com.lls.springboot.dao;

import com.lls.springboot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {

    @Insert("insert into user(email, username, password, roles) values(#{email}, #{username}, #{password}, #{roles})")
    int insert(User user);

    @Select("select * from user where username = #{username}")
    User selectByUsername(@Param("username") String username);

}
