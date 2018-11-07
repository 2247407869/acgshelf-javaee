package com.lls.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.dao.AnimeDao;
import com.lls.springboot.model.AnimePo;
import com.lls.springboot.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService {
    @Autowired
    private AnimeDao animeDao;
    @Override
    public PageInfo getAnimeRankList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AnimePo> list = animeDao.getAnimeRankList();
        return new PageInfo<>(list);
    }

    @Override
    public void changeAnimeCollection(int id, String collection, Long userDTOId) {
        animeDao.changeCollection(id, collection, userDTOId);
    }
}
