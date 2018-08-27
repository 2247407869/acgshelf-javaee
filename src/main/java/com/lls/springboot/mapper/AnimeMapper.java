package com.lls.springboot.mapper;

import java.util.List;

import com.lls.springboot.pojo.Anime;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AnimeMapper {

    @Results({
            @Result(property = "nameCn", column = "name_cn"),
            @Result(property = "imagesMedium", column = "images_medium"),
            @Result(property = "imagesSmall", column = "images_small"),
            @Result(property = "epsCount", column = "eps_count"),
            @Result(property = "airDate", column = "air_date")
    })
    @Select("select * from anime ")
    List<Anime> findAll();

    @Update("update anime set collection=#{1} where id=#{0} ")
    void changeCollection(int id, String collection);

}