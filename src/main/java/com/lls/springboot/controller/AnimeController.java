package com.lls.springboot.controller;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.domain.User;
import com.lls.springboot.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/anime")
public class AnimeController {
    @Autowired
    AnimeService animeService;

    @GetMapping(value = "/rank")
    public PageInfo animeRankList(@RequestParam("pageNum") int pageNum,
                                  @RequestParam("pageSize") int pageSize) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return animeService.getAnimeRankListForGuest(pageNum, pageSize);
        }
        User user = (User) authentication.getDetails();
        return animeService.getAnimeRankList(pageNum, pageSize, user);
    }

    @PostMapping(value = "/{id}")
    public void changeCollection(@PathVariable("id") int id,
                                 @RequestParam("collection") String collection) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getDetails();
        animeService.changeAnimeCollection(id, collection, user);
    }
}