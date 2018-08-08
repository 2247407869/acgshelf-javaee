package com.lls.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lls.springboot.pojo.Category;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CategoryMapper {

    @Select("select id,name_cn from anime ")
    List<Category> findAll();

    @Update("update anime set collection=#{1} where id=#{0} ")
    void changeCollection(int id, int collection);

}