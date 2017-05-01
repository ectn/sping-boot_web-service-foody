package com.ctinute.foody.dao;

import com.ctinute.foody.models.District;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DistrictDAO extends DAO {
    public DistrictDAO(){}

    // danh sach quan/huyen tu query
    private List<District> getDistricts(String query){
        List<District> districts = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()){
                District d = new District();
                d.setId(rs.getInt("ID"));
                d.setName(rs.getString("NAME"));
                districts.add(d);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return districts;
    }

    // danh sach quan/huyen (kem danh sach duong) tu query
    private List<District> getDistrictsWithStreet(String query){
        List<District> districts = new ArrayList<>();
        StreetDAO sdb = new StreetDAO();
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()){
                District d = new District();
                d.setId(rs.getInt("ID"));
                d.setName(rs.getString("NAME"));
                d.setStreetList(sdb.getStreetsByDistrictId(d.getId()));
                districts.add(d);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        sdb.close();
        return districts;
    }

    // danh sach quan/huyen (kem duong) tu tinh/thanh pho
    public List<District> getDistrictsByCityId(int cityId){
        String query = "select * from foody.district where CITYID = "+cityId;
        return getDistrictsWithStreet(query);
    }

}
