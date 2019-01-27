package com.lls.springboot.controller;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.model.UserDTO;
import com.lls.springboot.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
@RequestMapping(value = "/anime")
public class AnimeController {
    @Autowired
    AnimeService animeService;

    @GetMapping(value = "/rank")
    public PageInfo animeRankList(@RequestParam("pageNum") int pageNum,
                                  @RequestParam("pageSize") int pageSize,
                                  @RequestParam("order") String order) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDTO userDTO = (UserDTO) authentication.getDetails();
        return animeService.getAnimeRankList(pageNum, pageSize, userDTO, order);
    }

    @PostMapping(value = "/{id}")
    public void changeCollection(@PathVariable("id") int id,
                                 @RequestParam("collection") String collection) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDTO userDTO = (UserDTO) authentication.getDetails();
        animeService.changeAnimeCollection(id, collection, userDTO);
    }
}