package com.zoo.util;
/**
创建连接池
@author 黄浩
 */

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/zoo?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static LinkedList<Connection> pool=new LinkedList<Connection>();

    static {
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //创建连接
            for (int i=0;i<10;i++){
                Connection connection=DriverManager.getConnection(URL, USER, PASSWORD);
                //加入链表
                pool.add(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //获取连接
    @Override
    public Connection getConnection() throws SQLException {
        //判断连接池中是否还有连接，若没有则添加连接到连接池中
        if (pool.size() == 0) {
            for (int i = 0; i < 10; i++) {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                pool.add(connection);
            }
        }
        return pool.remove(0);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }


}
