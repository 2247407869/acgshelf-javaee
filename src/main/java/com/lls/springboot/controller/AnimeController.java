package com.lls.springboot.controller;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/anime")
public class AnimeController {
    @Autowired
    AnimeService animeService;

    @GetMapping(value = "/rank")
    public PageInfo animeRankList(@RequestParam("pageNum") int pageNum,
                                  @RequestParam("pageSize") int pageSize) {
        return animeService.getAnimeRankList(pageNum, pageSize);
    }

    @PostMapping(value = "/{id}")
    public void changeCollection(@PathVariable("id") int id,
                                 @RequestParam("collection") String collection) {
        animeService.changeAnimeCollection(id, collection);
    }
}