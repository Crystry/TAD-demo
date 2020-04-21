package com.zoo.model;
/*
@author 黄浩
展厅的增删改查，对数据库的操作
 */


import com.zoo.bean.Showroom;
import com.zoo.util.ZooUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowroomDao {
    //增加展厅
    public void addShowroom(Showroom showroom)  {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " insert into showroom " +
                " (ShowroomName,ShowroomIntroduction,ShowroomLocation,ShowroomLocationSize,ShowroomKeeper) " +
                " values( " +
                " ?,?,?,?,?) ";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, showroom.getShowroomName());
            ptmt.setString(2, showroom.getShowroomIntroduction());
            ptmt.setString(3, showroom.getShowroomLocation());
            ptmt.setString(4, showroom.getShowroomLocationSize());
            ptmt.setString(5, showroom.getShowroomKeeper());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //更新展厅
    public void updateShowroom(Showroom showroom)  {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " update  showroom " +
                " set ShowroomName=?,ShowroomIntroduction=?,ShowroomLocation=?,ShowroomLocationSize=? " +
                " where ShowroomKeeper=? ";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);

            ptmt.setString(1, showroom.getShowroomName());
            ptmt.setString(2, showroom.getShowroomIntroduction());
            ptmt.setString(3, showroom.getShowroomLocation());
            ptmt.setString(4, showroom.getShowroomLocationSize());
            ptmt.setString(5, showroom.getShowroomKeeper());

            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //删除展厅
    public void deleteShowroom(String ShowroomName)  {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " delete from showroom " +
                " where ShowroomName=? ";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, ShowroomName);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //查询全部
    public List<Showroom> query() {
        Connection conn = ZooUtil.getConnection();
        Statement stmt = null;
        ResultSet rs=null;
        ObservableList<Showroom> showroom = FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(" select * from showroom ");
            while (rs.next()) {
                String showroomName = rs.getString("ShowroomName");
                String showroomIntroduction = rs.getString("ShowroomIntroduction");
                String showroomLocation = rs.getString("ShowroomLocation");
                String showroomLocationSize = rs.getString("ShowroomLocationSize");
                String showroomKeeper = rs.getString("ShowroomKeeper");
                Showroom showroom1 = new Showroom(showroomName, showroomIntroduction,
                        showroomLocation, showroomLocationSize, showroomKeeper);
                showroom.add(showroom1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return showroom;
    }
    //管理员查询自己族群的信息
    public List<Showroom> query(String aShowroomKeeper)  {
        List<Showroom> showroom = new ArrayList<>();
        Connection conn = ZooUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from showroom ");
        sb.append(" where ShowroomKeeper=? ");
        Showroom showroom1 = null;
        PreparedStatement ptmt = null;
        ResultSet rs = null;
        try {
            ptmt = conn.prepareStatement(sb.toString());
            ptmt.setString(1, aShowroomKeeper);
            rs = ptmt.executeQuery();
            while (rs.next()) {
                showroom1 = new Showroom();
                showroom1.setShowroomName(rs.getString("ShowroomName"));
                showroom1.setShowroomIntroduction(rs.getString("showroomIntroduction"));
                showroom1.setShowroomLocation(rs.getString("showroomLocation"));
                showroom1.setShowroomLocationSize(rs.getString("showroomLocationSize"));
                showroom1.setShowroomKeeper(rs.getString("showroomKeeper"));
                showroom.add(showroom1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return showroom;
    }

}
