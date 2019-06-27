package com.lls.springboot.service;

import com.github.pagehelper.PageInfo;
import com.lls.springboot.domain.User;

/**
 * @program: Acgshelf-Javaee
 * @description: TODO
 * @author: LLS
 * @create: 2019-06-23 09:52
 **/
public interface GameService {
    PageInfo getGameRankListForGuest(int pageNum, int pageSize);

    PageInfo getGameRankList(int pageNum, int pageSize, User user, String order);

    void changeGameCollection(int id, String collection, User user);
}
