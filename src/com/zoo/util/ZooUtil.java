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

    //TODO 频繁的建立、关闭连接，会极大的减低系统的性能，师弟可以想一下有没有什么方式可以不那么频繁的创建连接
    // 两个try catch可以合并
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


