package com.air.javaee.jqaj.dao;

import com.air.javaee.jqaj.entity.City;
import com.air.javaee.jqaj.entity.Province;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:RenJIE(Air)
 * @Date:2021/1/11 - 7:32 下午
 * @Description:com.air.javaee.jqaj.dao
 * @version: 1.0
 */
public class QueryDao {
    //查询所有的省份信息
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    private String sql;
    private String url = "jdbc:mysql://127.0.0.1:3306/javastudy?serverTimezone=GMT%2B8";
    private String user = "root";
    private String password = "rj231147";
    private String Driver = "com.mysql.cj.jdbc.Driver";
    public List<Province> queryProvinceList(){
        List<Province> list = new ArrayList<>();
        try {
            Province province = null;
            Class.forName(Driver);
            connection = DriverManager.getConnection(url,user,password);
            sql = "select * from province order by id";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                province = new Province();
                province.setId(resultSet.getInt("id"));
                province.setName(resultSet.getString("name"));
                province.setJiancheng(resultSet.getString("jiancheng"));
                province.setShenghui(resultSet.getString("shenghui"));
                list.add(province);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }


    public List<City> queryCityList(Integer provinceid){
        List<City> list = new ArrayList<>();
        try {
            City city = null;
            Class.forName(Driver);
            connection = DriverManager.getConnection(url,user,password);
            sql = "select * from city order by provinceid = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,provinceid);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                city = new City();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                list.add(city);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }
}
