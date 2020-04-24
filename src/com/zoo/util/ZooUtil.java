package com.zoo.util;
/*
连接数据库
@author 黄浩
 */

import java.sql.*;
public class ZooUtil {

    private static MyDataSource myDataSource=new MyDataSource();
    //1、加载驱动程序
    public static Connection getConnection() {
        try {
            return myDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //关闭连接
    public static void close(Connection conn,PreparedStatement ptmt,ResultSet rs,Statement stmt){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                conn=null;
            }
        }
        if (ptmt!=null){
            try {
                ptmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                ptmt=null;
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                rs=null;
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                stmt=null;
            }
        }
    }

}




