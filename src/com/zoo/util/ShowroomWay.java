package com.zoo.util;

import com.zoo.model.Showroom;
import com.zoo.controller.ZooUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowroomWay {
    //增加展厅
    public void addShowroom(Showroom showroom) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " insert into showroom " +
                " (ShowroomName,ShowroomIntroduction,ShowroomLocation,ShowroomLocationSize,ShowroomKeeper) " +
                " values( " +
                " ?,?,?,?,?) ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, showroom.getShowroomName());
        ptmt.setString(2, showroom.getShowroomIntroduction());
        ptmt.setString(3, showroom.getShowroomLocation());
        ptmt.setString(4, showroom.getShowroomLocationSize());
        ptmt.setString(5, showroom.getShowroomKeeper());
        ptmt.execute();

    }
    //更新展厅
    public void updateShowroom(Showroom showroom) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " update  showroom " +
                " set ShowroomName=?,ShowroomIntroduction=?,ShowroomLocation=?,ShowroomLocationSize=? " +
                " where ShowroomKeeper=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, showroom.getShowroomName());
        ptmt.setString(2, showroom.getShowroomIntroduction());
        ptmt.setString(3, showroom.getShowroomLocation());
        ptmt.setString(4, showroom.getShowroomLocationSize());
        ptmt.setString(5, showroom.getShowroomKeeper());

        ptmt.execute();


    }
    //删除展厅
    public void deleteShowroom(String ShowroomName) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " delete from showroom " +
                " where ShowroomName=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, ShowroomName);
        ptmt.execute();

    }
    //查询全部
    public List<Showroom> query() throws SQLException {
        Connection conn = ZooUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(" select * from showroom ");
        ObservableList<Showroom> showroom = FXCollections.observableArrayList();
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
        return showroom;

    }
    //管理员查询自己族群的信息
    public List<Showroom> query(String aShowroomKeeper) throws SQLException {
        List<Showroom> showroom = new ArrayList<>();
        Connection conn = ZooUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from showroom ");
        sb.append(" where ShowroomKeeper=? ");
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ptmt.setString(1, aShowroomKeeper);
        ResultSet rs = ptmt.executeQuery();

        Showroom showroom1 = null;
        while (rs.next()) {
            showroom1 = new Showroom();
            showroom1.setShowroomName(rs.getString("ShowroomName"));
            showroom1.setShowroomIntroduction(rs.getString("showroomIntroduction"));
            showroom1.setShowroomLocation(rs.getString("showroomLocation"));
            showroom1.setShowroomLocationSize(rs.getString("showroomLocationSize"));
            showroom1.setShowroomKeeper(rs.getString("showroomKeeper"));
            showroom.add(showroom1);
        }
        return showroom;
    }

}
