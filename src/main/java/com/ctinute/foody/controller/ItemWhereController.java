package com.ctinute.foody.controller;

import com.ctinute.foody.dao.ItemWheretDAO;
import com.ctinute.foody.models.ItemWhere;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemWhereController {

    @RequestMapping("/itemw")
    public List<ItemWhere> getItemw(
            @RequestParam(value="cityid", defaultValue="1") int cityId,
            @RequestParam(value="districtid", defaultValue="0") int districtId,
            @RequestParam(value="streetid", defaultValue="0") int streetId,
            @RequestParam(value="categoryid", defaultValue="0") int categoryId,
            @RequestParam(value="beginindex", defaultValue="0") int beginIndex
    ) {
        ItemWheretDAO idb = new ItemWheretDAO();
        List<ItemWhere> list = idb.findItemsByFields(cityId,districtId,streetId,categoryId, beginIndex, 10);
        idb.close();
        return list;
    }
}
