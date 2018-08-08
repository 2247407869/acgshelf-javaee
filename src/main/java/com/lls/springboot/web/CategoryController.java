package com.lls.springboot.web;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lls.springboot.mapper.CategoryMapper;
import com.lls.springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class CategoryController {
    @Autowired
    CategoryMapper categoryMapper;

    @GetMapping(value = "/listCategory")
    public PageInfo listCategory(HttpServletResponse response,
                                 @RequestParam("pageNum") int pageNum,
                                 @RequestParam("pageSize") int pageSize) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        PageHelper.startPage(pageNum, pageSize);
        List<Category> list = categoryMapper.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @PostMapping(value = "/listCategory/{id}")
    public void changeCollection(HttpServletResponse response,
                                 @PathVariable("id") int id,
                                 @RequestParam("collection") String collection) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        categoryMapper.changeCollection(id, collection);
    }
     
}