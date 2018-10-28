package com.lls.springboot.dao;

import com.lls.springboot.model.UserPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {

    @Insert("insert into users(username, password, nickname, roles) values(#{username}, #{password}, #{nickname}, #{roles})")
    int insert(UserPo userPo);

    @Select("select * from users where username = #{username}")
    UserPo selectByUsername(@Param("username") String username);

}
