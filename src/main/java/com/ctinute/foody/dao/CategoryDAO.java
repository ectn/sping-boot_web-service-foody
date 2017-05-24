package com.ctinute.foody.dao;

import com.ctinute.foody.models.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DAO {

    private static final String TABLE_NAME = "category";

    public CategoryDAO() {
        super();
    }

    private List<Category> getCategories(String query){
        List<Category> categories = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("ID"));
                category.setName(rs.getString("NAME"));
                category.setImage(rs.getString("IMAGE"));
                categories.add(category);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return categories;
    }

    public List<Category> getAllCategory(){
        String query = "select * from "+TABLE_NAME;
        return getCategories(query);
    }
}
