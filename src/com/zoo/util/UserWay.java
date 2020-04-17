package com.zoo.util;

import com.zoo.model.Showroom;
import com.zoo.model.User;
import com.zoo.controller.ZooUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.*;
import java.util.*;


public class UserWay {
    //增加用户
    public void addUser(User user) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " insert into user " +
                " (Name,Password,Attribute,Identity) " +
                " values( " +
                " ?,?,?,?) ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, user.getName());
        ptmt.setString(2, user.getPassword());
        ptmt.setString(3,user.getAttribute());
        ptmt.setString(4, user.getIdentity());
        ptmt.execute();

    }
    //更新用户
    public void updateUser(User user) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " update  user " +
                " set Password=?,Identity=?,Attribute=? " +
                " where Name=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, user.getPassword());
        ptmt.setString(2, user.getIdentity());
        ptmt.setString(3, user.getAttribute());
        ptmt.setString(4, user.getName());
        ptmt.execute();


    }
    //删除用户
    public void deleteUser(String aName) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " delete from user " +
                " where Name =? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, aName);
        ptmt.execute();

    }

    //查询全部
    public List<User> query() throws SQLException {
        Connection conn = ZooUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(" select * from user where Attribute='Administrator' ");

        ObservableList<User> user = FXCollections.observableArrayList();
        while (rs.next()) {
            Integer id=rs.getInt("Id");
            String name=rs.getString("Name");
            String password=rs.getString("Password");
            String identity=rs.getString("Identity");
            User u=new User(id,name,password,identity);
            user.add(u);
        }
        return user;

    }

    public List<User> query(String Name) throws SQLException {

        Connection conn = ZooUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from user ");
        sb.append(" where Name=? ");
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ptmt.setString(1, Name);
        ResultSet rs = ptmt.executeQuery();
        List<User> user = new ArrayList<>();
        User u = null;
        while (rs.next()) {
            u = new User();
            u.setId(rs.getInt("Id"));
            u.setName(rs.getString("Name"));
            u.setIdentity(rs.getString("Identity"));
            user.add(u);
        }
        return user;

    }



    //查询Name
    public boolean selectName(String aName) {
        String Name = null;
        Connection conn = ZooUtil.getConnection();
        String sql = " select * from user ";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Name = rs.getString("Name");
                if (Name.equals(aName)) {

                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean selectPassword(String aName, String aPassword) {
        String Password = null;
        Connection conn = ZooUtil.getConnection();
        String sql = " select Password from user where Name='" + aName + "' ";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Password = rs.getString("Password");
                if (Password.equals(aPassword)) {
                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean selectIdentity(String aName, String aIdentity) {
        String Identity = null;
        Connection conn = ZooUtil.getConnection();
        String sql = " select * from user where Name='" + aName + "' ";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Identity = rs.getString("Identity");

                if (Identity.equals(aIdentity)) {
                    return true;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    //TODO 这些代码不属于对于数据库的操作，建议放在controller中
    //TODO 对于常量的话建议写在常量类中，命名一定要有意义，要清晰明了
    //TODO 有没有发现你下面的两段代码实质是相同的，思考一下如何简化下面的代码，时间充足的话可以去了解一下责任链，
    // 现在这里只是说是有三种角色，如果我后面有很多很多的角色，那前面岂不是要有很多的if
    public boolean judgeAttribute1(String aIdentity) {
        String Boss="Chief";
        //TODO 师弟飘黄了哦，思考一下为神马要飘黄呢，改正一下
        if (aIdentity == Boss) {
            return true;

        }
        return false;
    }
    public boolean judgeAttribute2(String aIdentity) {
        if (aIdentity == "Tourist") {
            return true;

        }
        return false;
    }
}

