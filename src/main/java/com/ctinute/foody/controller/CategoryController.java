package com.ctinute.foody.controller;

import com.ctinute.foody.dao.CategoryDAO;
import com.ctinute.foody.models.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CategoryController {

    @RequestMapping("/category")
    public List<Category> category() {
        CategoryDAO cdb = new CategoryDAO();
        List<Category> list = cdb.getAllCategory();
        cdb.close();
        return list;
    }
}