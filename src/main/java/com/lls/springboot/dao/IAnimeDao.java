package com.lls.springboot.dao;

import java.util.List;

import com.lls.springboot.model.AnimePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Update;

@Mapper
public interface IAnimeDao {

    @Select("select * from anime ")
    List<AnimePo> getAnimeRankList();

    @Update("update anime set collection=#{1} where id=#{0} ")
    void changeCollection(int id, String collection);


}