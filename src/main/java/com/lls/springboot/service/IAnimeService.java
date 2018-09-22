package com.lls.springboot.service;

import com.github.pagehelper.PageInfo;

public interface IAnimeService {
    PageInfo getAnimeRankList(int pageNum, int pageSize);

    void changeAnimeCollection(int id, String collection);
}
