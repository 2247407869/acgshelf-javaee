package com.lls.springboot.dao;

import com.lls.springboot.domain.Anime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: Acgshelf-Javaee
 * @description: TODO
 * @author: LLS
 * @create: 2019-06-23 09:55
 **/
@Mapper
public interface GameDao {

    @Select("select id,url,name_cn,rank,eps_count,air_date,images_small,collection " +
            "from anime left join anime_user on (anime.id = anime_user.anime_id) " +
            "and anime_user.user_id = #{id} " +
            "order by rank")
    List<Anime> getGameRankList(@Param("id") Long id,
                                 @Param("order") String order);

    @Insert("insert into game_user values (#{id},#{userDTOId},#{collection}) " +
            "on DUPLICATE key update collection = #{collection}")
    void changeCollection(@Param("id") int id,
                          @Param("collection") String collection,
                          @Param("userDTOId") Long userDTOId);

    @Select("select id,url,name_cn,rank,eps_count,air_date,images_small " +
            "from game order by rank")
    List<Anime> getGameRankListForGuest();
}
