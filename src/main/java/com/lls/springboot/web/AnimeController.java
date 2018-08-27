package com.lls.springboot.web;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.mapper.AnimeMapper;
import com.lls.springboot.pojo.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class AnimeController {
    @Autowired
    AnimeMapper animeMapper;

    @GetMapping(value = "/listCategory")
    public PageInfo listCategory(@RequestParam("pageNum") int pageNum,
                                 @RequestParam("pageSize") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Anime> list = animeMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @PostMapping(value = "/listCategory/{id}")
    public void changeCollection(@PathVariable("id") int id,
                                 @RequestParam("collection") String collection) {
        animeMapper.changeCollection(id, collection);
    }
     
}