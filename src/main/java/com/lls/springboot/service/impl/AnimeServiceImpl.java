package com.lls.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.dao.AnimeDao;
import com.lls.springboot.domain.Anime;
import com.lls.springboot.domain.User;
import com.lls.springboot.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService {
    @Autowired
    private AnimeDao animeDao;
    @Override
    public PageInfo getAnimeRankList(int pageNum, int pageSize, User user, String order, int type) {
        PageHelper.startPage(pageNum, pageSize);
        List<Anime> list = animeDao.getAnimeRankList(user.getId(), order);
        return new PageInfo<>(list);
    }

    @Override
    public void changeAnimeCollection(int id, String collection, User userId) {
        animeDao.changeCollection(id, collection, userId.getId());
    }

    @Override
    public PageInfo getAnimeRankListForGuest(int pageNum, int pageSize, int type) {
        PageHelper.startPage(pageNum, pageSize);
        List<Anime> list = animeDao.getAnimeRankListForGuest();
        return new PageInfo<>(list);
    }
}
