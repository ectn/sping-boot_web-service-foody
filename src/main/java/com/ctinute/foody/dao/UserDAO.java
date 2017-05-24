package com.ctinute.foody.dao;

import com.ctinute.foody.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO {

    private static final String TABLE_NAME = "user";

    public UserDAO(){}

    // danh sach tinh thanh pho tu query
    private List<User> getUsers(String query){
        List<User> users = new ArrayList<>();
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setImage(rs.getString("image"));
                users.add(user);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    // user dau tien
    public User getUser(String email, String password){
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from user WHERE email=? and password=?");
            statement.setString(1,email);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();
            if (rs.first()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setImage(rs.getString("image"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    // dang ki user
    public boolean registerUser(String name, String email, String password){
        try {
            PreparedStatement statement = connection.prepareStatement("insert into user (name, email, password) values (?,?,?)");
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setString(3,password);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // danh sach tat ca tinh thanh pho
    public List<User> getAllUsers(){
        String query = "select * from "+TABLE_NAME;
        return getUsers(query);
    }

    // danh sach tinh thanh pho bang keyword -> chuc nang tim kiem
    public List<User> getCitiesByKeyword(String keyword){
        String query = "select * from "+TABLE_NAME+" where NAME like '%"+keyword+"%'";
        return getUsers(query);
    }

}
