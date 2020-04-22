package com.zoo.util;
/*
@author 黄浩
连接数据库
 */

import java.sql.*;
public class ZooUtil {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/zoo?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "7758258";
    private static Connection conn = null;
    //1、加载驱动程序

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}


