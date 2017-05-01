package com.ctinute.foody.controller;

import com.ctinute.foody.dao.CityDAO;
import com.ctinute.foody.models.City;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @RequestMapping("/city")
    public List<City> getCities(
            @RequestParam(value="keyword", defaultValue="") String keyword
    ) {
        CityDAO cdb = new CityDAO();
        List<City> list;
        if (keyword.isEmpty() || keyword.equals(""))
             list = cdb.getAllCities();
        else
            list = cdb.getCitiesByKeyword(keyword);
        cdb.close();
        return list;
    }
}
