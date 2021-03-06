package com.ctinute.foody.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    // properties
    //private static final String conURL = "jdbc:sqlserver://foody14110203.database.windows.net:1433;database=foodydb;user=ctinute@foody14110203;password=Chanhtin26;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static final String conURL = "jdbc:mysql://localhost:3306/foody2?autoReconnect=true&useSSL=false";
    private static final String conUsername = "root";
    private static final String conPassword = "chanhtin";
    protected Connection connection;

    // constructor
    DAO(){
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(conURL,conUsername,conPassword);
        } catch (Exception e) {
            // driver false
            e.printStackTrace();
        }
    }

    // methods
    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            // connection not init
        }
    }

    protected boolean set(String query) {
        try {
            connection.createStatement().executeUpdate(query);
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    protected ResultSet get(String query) {
        try {
            ResultSet rs = connection.createStatement().executeQuery(query);
            if(rs.next()){
                return rs;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
