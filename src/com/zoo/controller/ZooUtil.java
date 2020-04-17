package com.zoo.controller;

import java.sql.*;

import static java.lang.Class.forName;

//TODO 既然是工具类，建议放在Util包中
public class ZooUtil {

    private static final String URL="jdbc:mysql://127.0.0.1:3306/zoo?serverTimezone=UTC";
    private static final String USER="root";
    private static final String PASSWORD="7758258";

    //TODO 数据库的连接需要进行关闭，如果不关闭数据库的连接，那会出现什么问题。
    // 并且整个应用中只维护了一个数据库连接，如果想要同时对数据库进行操作那该怎么办，思考一下如何处理
    private static Connection conn = null;

    static {
        //TODO 两个try catch可以合并到一起
        //1、加载驱动程序
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2、获得数据库的连接
        try {
            conn=DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){
        return conn;
    }

}
