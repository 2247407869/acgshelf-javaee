package com.lls.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.dao.GameDao;
import com.lls.springboot.domain.Anime;
import com.lls.springboot.domain.User;
import com.lls.springboot.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: Acgshelf-Javaee
 * @description: TODO
 * @author: LLS
 * @create: 2019-06-23 09:54
 **/
@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameDao gameDao;
    @Override
    public PageInfo getGameRankList(int pageNum, int pageSize, User user, String order) {
        PageHelper.startPage(pageNum, pageSize);
        List<Anime> list = gameDao.getAnimeRankList(user.getId(), order);
        return new PageInfo<>(list);
    }

    @Override
    public void changeGameCollection(int id, String collection, User userId) {
        gameDao.changeCollection(id, collection, userId.getId());
    }

    @Override
    public PageInfo getGameRankListForGuest(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Anime> list = gameDao.getAnimeRankListForGuest();
        return new PageInfo<>(list);
    }
}
