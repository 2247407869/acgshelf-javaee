package com.lls.springboot;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.dao.AnimeDao;
import com.lls.springboot.domain.Anime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private AnimeDao animeDao;

    @Test
    public void contextLoads() {
        PageHelper.startPage(1, 10);
//        List<Anime> anime = animeDao.getAnimeRankList((long) 1);
//        System.out.println("查询结果： " + new PageInfo<>(anime));
    }

    @Test
    public void divideTest() {
        int i = 3/2;
        System.out.println("测试结果： " + i);
    }

}
