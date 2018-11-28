package com.lls.springboot.service;

import com.github.pagehelper.PageInfo;
import com.lls.springboot.domain.User;

public interface AnimeService {
    PageInfo getAnimeRankList(int pageNum, int pageSize, User user);

    void changeAnimeCollection(int id, String collection, User userId);
}
