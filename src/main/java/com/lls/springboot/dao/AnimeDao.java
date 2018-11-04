package com.lls.springboot.dao;

import java.util.List;

import com.lls.springboot.model.AnimePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.Update;

@Mapper
public interface AnimeDao {

    @Select("select * from animes ")
    List<AnimePo> getAnimeRankList();

    @Update("update animes set collection=#{collection} where id=#{id} ")
    void changeCollection(@Param("id") int id,
                          @Param("collection") String collection);

}