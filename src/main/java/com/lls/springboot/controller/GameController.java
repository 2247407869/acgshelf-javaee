package com.lls.springboot.controller;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.domain.User;
import com.lls.springboot.service.AnimeService;
import com.lls.springboot.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@RequestMapping(value = "/game")
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping(value = "/rank")
    public PageInfo gameRankList(@RequestParam("pageNum") int pageNum,
                                  @RequestParam("pageSize") int pageSize,
                                  @RequestParam("order") String order) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return gameService.getGameRankListForGuest(pageNum, pageSize);
        }
        User user = (User) authentication.getDetails();
        return gameService.getGameRankList(pageNum, pageSize, user, order);
    }

    @PostMapping(value = "/{id}")
    public void changeCollection(@PathVariable("id") int id,
                                 @RequestParam("collection") String collection) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getDetails();
        gameService.changeGameCollection(id, collection, user);
    }
}