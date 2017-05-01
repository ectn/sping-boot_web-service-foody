package com.ctinute.foody.dao;

import com.ctinute.foody.models.ItemWhere;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemWheretDAO extends DAO {
    private final String TABLE_NAME = "foody.itemwhere";
    public ItemWheretDAO() {
        super();
    }

    private List<ItemWhere> getItems(String query){
        List<ItemWhere> items = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()){
                ItemWhere item = new ItemWhere();
                item.setId(rs.getInt("ID"));
                item.setName(rs.getString("NAME"));
                item.setImageUrl(rs.getString("IMAGEURL"));
                item.setAddress(rs.getString("ADDRESS"));
                item.setAvgRating(rs.getDouble("AVGRATING"));
                item.setNoReview(rs.getString("REVIEWS"));
                item.setNoPhoto(rs.getString("PHOTOS"));
                item.setNoBookmark(rs.getString("BOOKMARKS"));
                item.setCityID(rs.getInt("CITYID"));
                item.setDistrictId(rs.getInt("DISTRICTID"));
                item.setStreetId(rs.getInt("STREETID"));
                item.setCategoryId(rs.getInt("CATEGORYID"));
                item.setTypeId(rs.getInt("TYPEID"));
                items.add(item);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return items;
    }

    public List<ItemWhere> getAllItems(){
        String query = "select * from "+TABLE_NAME+";";
        return getItems(query);
    }

    public List<ItemWhere> getItemsByCity(int cityId){
        String query = "select * from "+TABLE_NAME+" where CITYID="+cityId+";";
        return getItems(query);
    }

    public List<ItemWhere> getItemsByDistrict(int districtId){
        String query = "select * from "+TABLE_NAME+" where DISTRICTID="+districtId+";";
        return getItems(query);
    }

    public List<ItemWhere> getItemsByStreet(int streetId){
        String query = "select * from "+TABLE_NAME+" where STREETID="+streetId+";";
        return getItems(query);
    }

    public List<ItemWhere> findItemsByFields(int cityId, int districtId, int streetId, int categoryId) {
        String query;
        if (categoryId <= 1){
            // no category (all)
            if (streetId > 0) {
                // tim theo duong
                query =  "select * from "+TABLE_NAME+ " where STREETID = "+streetId;
            }
            else if (districtId > 0) {
                // tim theo quan/huyen
                query =  "select * from "+TABLE_NAME+ " where DISTRICTID = "+districtId;
            }
            else if (cityId > 0) {
                query =  "select * from "+TABLE_NAME+ " where CITYID = "+cityId;
            }
            else
                query =  "select * from "+TABLE_NAME;    // lay het
        }
        else {
            // thim theo category
            if (streetId > 0) {
                // tim theo duong
                query =  "select * from "+TABLE_NAME+ " where CATEGORYID="+categoryId+" and STREETID = "+streetId;
            }
            else if (districtId > 0) {
                // tim theo quan/huyen
                query =  "select * from "+TABLE_NAME+ " where CATEGORYID="+categoryId+" and DISTRICTID = "+districtId;
            }
            else if (cityId > 0) {
                query =  "select * from "+TABLE_NAME+ " where CATEGORYID="+categoryId+" and CITYID = "+cityId;
            }
            else
                query =  "select * from "+TABLE_NAME+" where CATEGORYID="+categoryId;    // lay het
        }
        return getItems(query);
    }


    // danh sach item, co gioi han
    public List<ItemWhere> findItemsByFields(int cityId, int districtId, int streetId, int categoryId, int firstIndex, int numberOfItems) {
        String query;
        if (categoryId <= 1){
            // no category (all)
            if (streetId > 0) {
                // tim theo duong
                query =  "select * from "+TABLE_NAME+ " where STREETID = "+streetId+" ORDER BY ID OFFSET "+firstIndex+" ROWS FETCH NEXT "+numberOfItems+" ROWS ONLY";
            }
            else if (districtId > 0) {
                // tim theo quan/huyen
                query =  "select * from "+TABLE_NAME+ " where DISTRICTID = "+districtId+" ORDER BY ID OFFSET "+firstIndex+" ROWS FETCH NEXT "+numberOfItems+" ROWS ONLY";
            }
            else if (cityId > 0) {
                query =  "select * from "+TABLE_NAME+ " where CITYID = "+cityId+" ORDER BY ID OFFSET "+firstIndex+" ROWS FETCH NEXT "+numberOfItems+" ROWS ONLY";
            }
            else
                query =  "select * from "+TABLE_NAME+" ORDER BY ID OFFSET "+firstIndex+" ROWS FETCH NEXT "+numberOfItems+" ROWS ONLY";    // lay het
        }
        else {
            // thim theo category
            if (streetId > 0) {
                // tim theo duong
                query =  "select * from "+TABLE_NAME+ " where CATEGORYID="+categoryId+" and STREETID = "+streetId+" ORDER BY ID OFFSET "+firstIndex+" ROWS FETCH NEXT "+numberOfItems+" ROWS ONLY";
            }
            else if (districtId > 0) {
                // tim theo quan/huyen
                query =  "select * from "+TABLE_NAME+ " where CATEGORYID="+categoryId+" and DISTRICTID = "+districtId+" ORDER BY ID OFFSET "+firstIndex+" ROWS FETCH NEXT "+numberOfItems+" ROWS ONLY";
            }
            else if (cityId > 0) {
                query =  "select * from "+TABLE_NAME+ " where CATEGORYID="+categoryId+" and CITYID = "+cityId+" ORDER BY ID OFFSET "+firstIndex+" ROWS FETCH NEXT "+numberOfItems+" ROWS ONLY";
            }
            else
                query =  "select * from "+TABLE_NAME+" where CATEGORYID="+categoryId+" ORDER BY ID OFFSET "+firstIndex+" ROWS FETCH NEXT "+numberOfItems+" ROWS ONLY";    // lay het
        }
        return getItems(query);
    }
}
