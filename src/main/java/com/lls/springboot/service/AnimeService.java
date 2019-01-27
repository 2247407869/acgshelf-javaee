package com.lls.springboot.service;

import com.github.pagehelper.PageInfo;
import com.lls.springboot.model.UserDTO;

public interface AnimeService {
    PageInfo getAnimeRankList(int pageNum, int pageSize, UserDTO userDTO, String order);

    void changeAnimeCollection(int id, String collection, UserDTO userDTOId);
}
