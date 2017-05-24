package com.ctinute.foody.dao;

import com.ctinute.foody.models.ItemWhat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemWhatDAO extends DAO {

    private static final String TABLE_NAME = "itemwhat";

    public ItemWhatDAO() {
        super();
    }

    private List<ItemWhat> getItems(String query){
        List<ItemWhat> items = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()){
                ItemWhat item = new ItemWhat();
                item.setId(rs.getInt("ID"));
                item.setFoodName(rs.getString("NAME"));
                item.setLocationName(rs.getString("PLACE"));
                item.setAddress(rs.getString("ADDRESS"));
                item.setImage(rs.getString("IMAGEURL"));
                item.setUserName(rs.getString("USERNAME"));
                item.setUserImg(rs.getString("USERIMG"));
                item.setDate(rs.getString("DATE"));
                items.add(item);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return items;
    }

    // danh sach item, co gioi han
    public List<ItemWhat> findItemsByFields(int cityId, int districtId, int streetId, int categoryId, int firstIndex, int numberOfItems) {
        String query;
        if (categoryId <= 1){
            // no category (all)
            if (streetId > 0) {
                // tim theo duong
                query =  "select * from "+TABLE_NAME+ " where STREETID = "+streetId+" LIMIT "+numberOfItems+" OFFSET "+firstIndex;
            }
            else if (districtId > 0) {
                // tim theo quan/huyen
                query =  "select * from "+TABLE_NAME+ " where DISTRICTID = "+districtId+" LIMIT "+numberOfItems+" OFFSET "+firstIndex;
            }
            else if (cityId > 0) {
                query =  "select * from "+TABLE_NAME+ " where CITYID = "+cityId+" LIMIT "+numberOfItems+" OFFSET "+firstIndex;
            }
            else
                query =  "select * from "+TABLE_NAME+" LIMIT "+numberOfItems+" OFFSET "+firstIndex;
        }
        else {
            // thim theo category
            if (streetId > 0) {
                // tim theo duong
                query =  "select * from "+TABLE_NAME+ " where CATEGORYID="+categoryId+" and STREETID = "+streetId+" LIMIT "+numberOfItems+" OFFSET "+firstIndex;
            }
            else if (districtId > 0) {
                // tim theo quan/huyen
                query =  "select * from "+TABLE_NAME+ " where CATEGORYID="+categoryId+" and DISTRICTID = "+districtId+" LIMIT "+numberOfItems+" OFFSET "+firstIndex;
            }
            else if (cityId > 0) {
                query =  "select * from "+TABLE_NAME+ " where CATEGORYID="+categoryId+" and CITYID = "+cityId+" LIMIT "+numberOfItems+" OFFSET "+firstIndex;
            }
            else
                query =  "select * from "+TABLE_NAME+" where CATEGORYID="+categoryId+" LIMIT "+numberOfItems+" OFFSET "+firstIndex;
        }
        return getItems(query);
    }
}
