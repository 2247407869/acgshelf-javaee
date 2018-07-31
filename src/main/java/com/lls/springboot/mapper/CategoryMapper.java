package com.lls.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lls.springboot.pojo.Category;

@Mapper
public interface CategoryMapper {

    @Select("select id,name_cn from anime ")
    List<Category> findAll();

}