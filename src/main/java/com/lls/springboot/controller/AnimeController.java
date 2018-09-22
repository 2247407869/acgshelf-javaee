package com.lls.springboot.controller;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.service.IAnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController(value = "/anime")
public class AnimeController {
    @Autowired
    IAnimeService animeService;

    @GetMapping(value = "/rank")//todo 跨域
    public PageInfo animeRankList(HttpServletResponse response,
                                 @RequestParam("pageNum") int pageNum,
                                 @RequestParam("pageSize") int pageSize) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return animeService.getAnimeRankList(pageNum, pageSize);
    }

    @PostMapping(value = "/listCategory/{id}")
    public void changeCollection(HttpServletResponse response,
                                 @PathVariable("id") int id,
                                 @RequestParam("collection") String collection) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        animeService.changeAnimeCollection(id, collection);
    }
}