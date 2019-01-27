package com.lls.springboot.dao;

import java.util.List;

import com.lls.springboot.model.AnimePo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AnimeDao {

    @Select("select url,images_small,rank,name_cn,eps_count,air_date,collection " +
            "from anime left join anime_user on (anime.id = anime_user.anime_id) " +
            "and anime_user.user_id = #{id} " +
            "order by rank")
    List<AnimePo> getAnimeRankList(@Param("id") Long id,
                                   @Param("order") String order);

    @Insert("insert into anime_user values (#{id},#{userDTOId},#{collection}) " +
            "on DUPLICATE key update collection = #{collection}")
    void changeCollection(@Param("id") int id,
                          @Param("collection") String collection,
                          @Param("userDTOId") Long userDTOId);
}