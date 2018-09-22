package com.lls.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.dao.IAnimeDao;
import com.lls.springboot.model.AnimePo;
import com.lls.springboot.service.IAnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService implements IAnimeService {
    @Autowired
    private IAnimeDao animeDao;
    @Override
    public PageInfo getAnimeRankList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<AnimePo> list = animeDao.getAnimeRankList();
        return new PageInfo<>(list);
    }

    @Override
    public void changeAnimeCollection(int id, String collection) {
        animeDao.changeCollection(id, collection);
    }
}
