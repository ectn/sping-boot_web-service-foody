package com.ctinute.foody.controller;

import com.ctinute.foody.dao.ItemWhatDAO;
import com.ctinute.foody.models.ItemWhat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemWhatController {

    @RequestMapping("/itemwhat")
    public List<ItemWhat> getItemw(
            @RequestParam(value="cityid", defaultValue="1") int cityId,
            @RequestParam(value="districtid", defaultValue="0") int districtId,
            @RequestParam(value="streetid", defaultValue="0") int streetId,
            @RequestParam(value="categoryid", defaultValue="0") int categoryId,
            @RequestParam(value="offset", defaultValue="0") int offset
    ) {
        ItemWhatDAO idb = new ItemWhatDAO();
        List<ItemWhat> list = idb.findItemsByFields(cityId,districtId,streetId,categoryId, offset, 20);
        idb.close();
        return list;
    }
}
