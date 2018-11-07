package com.lls.springboot.dao;

import java.util.List;

import com.lls.springboot.model.AnimePo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AnimeDao {

    @Select("select * from animes order by rank")
    List<AnimePo> getAnimeRankList();

    @Insert("insert into anime_user values (#{id},#{userDTOId},#{collection}) " +
            "on DUPLICATE key update collection = #{collection}")
    void changeCollection(@Param("id") int id,
                          @Param("collection") String collection,
                          @Param("userDTOId") Long userDTOId);

}