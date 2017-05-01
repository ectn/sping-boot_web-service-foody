package com.ctinute.foody.controller;

import com.ctinute.foody.dao.DistrictDAO;
import com.ctinute.foody.models.District;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictController {

    @RequestMapping("/district")
    public List<District> getDistricts(
            @RequestParam(value="cityid", defaultValue="1") int cityId
    ) {
        DistrictDAO ddb = new DistrictDAO();
        List<District> list = ddb.getDistrictsByCityId(cityId);
        ddb.close();
        return list;
    }
}
