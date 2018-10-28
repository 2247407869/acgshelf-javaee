package com.lls.springboot.controller;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

//@CrossOrigin
@RestController
@RequestMapping(value = "/anime")
public class AnimeController {
    @Autowired
    AnimeService animeService;

    @GetMapping(value = "/rank")//todo 跨域
    public PageInfo animeRankList(HttpServletResponse response,
                                 @RequestParam("pageNum") int pageNum,
                                 @RequestParam("pageSize") int pageSize) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return animeService.getAnimeRankList(pageNum, pageSize);
    }

    @PostMapping(value = "/{id}")
    public void changeCollection(HttpServletResponse response,
                                 @PathVariable("id") int id,
                                 @RequestParam("collection") String collection) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        animeService.changeAnimeCollection(id, collection);
    }

    @GetMapping(value = "/hello")
    public String helloworld (){
        return "helloworld";
    }
}