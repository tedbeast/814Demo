package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaintingDAO {
    Connection conn;
    public PaintingDAO(){
        try{
            String url = "jdbc:h2:./h2/db";
            String username = "sa";
            String password = "sa";
            conn = DriverManager.getConnection(url, username, password);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void setUpPaintingTable(){
        try{
            // set up a new table
            PreparedStatement ps2 = conn.prepareStatement("create table painting(title varchar(255))");
            ps2.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void dropPaintingTable(){
        try{
            // drop any existing tables that exist
            PreparedStatement ps1 = conn.prepareStatement("drop table painting if exists");
            ps1.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void insertPainting(String title){
        try{
            // insert something into the table
            PreparedStatement ps3 = conn.prepareStatement("insert into painting (title) values (?)");
            ps3.setString(1, title);
            ps3.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public List<String> getAllPaintingNames(){
        List<String> paintings = new ArrayList<>();
        try{
            // query everything from the table and display the result
            PreparedStatement ps4 = conn.prepareStatement("select * from painting");
            ResultSet rs = ps4.executeQuery();
            while(rs.next()){
                // loop through every row in my result set, until it has no more items
                paintings.add(rs.getString("title"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return paintings;
    }
}
