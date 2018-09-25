package com.lls.springboot.service;

import com.github.pagehelper.PageInfo;

public interface IAnimeService {

    void changeCollection(int id, String collection);

    PageInfo findAll(int pageNum, int pageSize);
}
