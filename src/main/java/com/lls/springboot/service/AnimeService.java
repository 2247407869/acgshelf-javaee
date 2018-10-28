package com.lls.springboot.service;

import com.github.pagehelper.PageInfo;

public interface AnimeService {
    PageInfo getAnimeRankList(int pageNum, int pageSize);

    void changeAnimeCollection(int id, String collection);
}
