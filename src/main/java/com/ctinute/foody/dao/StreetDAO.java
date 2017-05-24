package com.ctinute.foody.dao;

import com.ctinute.foody.models.Street;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StreetDAO extends DAO {

    private static final String TABLE_NAME = "street";

    public StreetDAO(){
        super();
    }

    // danh sach duong tu query
    private List<Street> getStreets(String query){
        List<Street> streets = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()){
                Street s = new Street();
                s.setId(rs.getInt("ID"));
                s.setName(rs.getString("NAME"));
                streets.add(s);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return streets;
    }

    // danh sach tat ca duong tu quan/huyen
    public List<Street> getStreetsByDistrictId(int districtId){
        String query = "select * from "+TABLE_NAME+" where DISTRICTID = "+districtId;
        return getStreets(query);
    }

}
