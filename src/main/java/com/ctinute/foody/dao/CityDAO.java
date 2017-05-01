package com.ctinute.foody.dao;

import com.ctinute.foody.models.Category;
import com.ctinute.foody.models.City;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO extends DAO {
    public CityDAO(){}

    // danh sach tinh thanh pho tu query
    private List<City> getCities(String query){
        List<City> cities = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()){
                City city = new City();
                city.setId(rs.getInt("ID"));
                city.setName(rs.getString("NAME"));
                cities.add(city);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return cities;
    }

    // danh sach tat ca tinh thanh pho
    public List<City> getAllCities(){
        String query = "select * from foody.city";
        return getCities(query);
    }

    // danh sach tinh thanh pho bang keyword -> chuc nang tim kiem
    public List<City> getCitiesByKeyword(String keyword){
        String query = "select * from foody.city where NAME like '%"+keyword+"%'";
        return getCities(query);
    }

}
