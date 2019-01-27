package com.lls.springboot.dao;

import com.lls.springboot.model.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {

    @Insert("insert into user(email, username, password, roles) values(#{email}, #{username}, #{password}, #{roles})")
    int insert(UserDTO userDTO);

    @Select("select * from user where username = #{username}")
    UserDTO selectByUsername(@Param("username") String username);

}
