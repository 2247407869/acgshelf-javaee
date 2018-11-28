//package com.lls.springboot.repository;
//
//import com.lls.springboot.domain.Anime;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.Repository;
//
//import java.util.List;
//
//public interface AnimeRepository extends Repository<Anime, Long> {
//
//    Anime getById(long id);
//
//    @Query(nativeQuery = true,
//            value = "select * from anime a " +
//            "left join anime_user au on (a.id = au.anime_id) and au.user_id = ?1 " +
//            "order by ?#{#pageable}",
//            countQuery = "select count(*) from anime")
//    Page<Anime> getAnimeRankList(long id, Pageable pageable);   //todo 待解决问题
//}
