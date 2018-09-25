package com.lls.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.mapper.IAnimeMapper;
import com.lls.springboot.pojo.AnimeEntity;
import com.lls.springboot.service.IAnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService implements IAnimeService {

    @Autowired
    private IAnimeMapper animeMapper;

    @Override
    public void changeCollection(int id, String collection) {
        animeMapper.changeCollection(id, collection);
    }

    @Override
    public PageInfo findAll(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<AnimeEntity> list = animeMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

}
