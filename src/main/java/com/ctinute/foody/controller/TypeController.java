package com.ctinute.foody.controller;

import com.ctinute.foody.dao.CategoryDAO;
import com.ctinute.foody.dao.TypeDAO;
import com.ctinute.foody.models.Category;
import com.ctinute.foody.models.Type;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TypeController {

    @RequestMapping("/type")
    public List<Type> getTypes() {
        TypeDAO tdb = new TypeDAO();
        List<Type> list = tdb.getAllType();
        tdb.close();
        return list;
    }
}