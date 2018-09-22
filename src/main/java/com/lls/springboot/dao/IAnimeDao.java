package com.lls.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lls.springboot.model.AnimePo;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IAnimeDao {

    @Update("update anime set collection=#{1} where id=#{0} ")
    void changeCollection(int id, String collection);

    @Select("select id,name_cn,collection,rank from anime ")
    List<AnimePo> getAnimeRankList();
}