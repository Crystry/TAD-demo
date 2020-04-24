package com.zoo.model;
/*
展厅的增删改查，对数据库的操作
@author 黄浩
 */


import com.zoo.bean.Showroom;
import com.zoo.util.ZooUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowroomDao {
    //增加展厅
    public void addShowroom(Showroom showroom)  {
        Connection  connection = ZooUtil.getConnection();
        PreparedStatement preparedStatement =null;
        String sql = "" +
                " insert into showroom " +
                " (ShowroomName,ShowroomIntroduction,ShowroomLocation,ShowroomLocationSize,ShowroomKeeper) " +
                " values( " +
                " ?,?,?,?,?) ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, showroom.getShowroomName());
            preparedStatement.setString(2, showroom.getShowroomIntroduction());
            preparedStatement.setString(3, showroom.getShowroomLocation());
            preparedStatement.setString(4, showroom.getShowroomLocationSize());
            preparedStatement.setString(5, showroom.getShowroomKeeper());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           ZooUtil.close(connection,preparedStatement,null,null);
        }
    }
    //更新展厅
    public void updateShowroom(Showroom showroom)  {
        Connection  connection = ZooUtil.getConnection();
        PreparedStatement preparedStatement =null;
        String sql = "" +
                " update  showroom " +
                " set ShowroomName=?,ShowroomIntroduction=?,ShowroomLocation=?,ShowroomLocationSize=? " +
                " where ShowroomKeeper=? ";
        try {
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, showroom.getShowroomName());
            preparedStatement.setString(2, showroom.getShowroomIntroduction());
            preparedStatement.setString(3, showroom.getShowroomLocation());
            preparedStatement.setString(4, showroom.getShowroomLocationSize());
            preparedStatement.setString(5, showroom.getShowroomKeeper());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,preparedStatement,null,null);
        }
    }
    //删除展厅
    public void deleteShowroom(String showroomName)  {
        Connection  connection = ZooUtil.getConnection();
        PreparedStatement preparedStatement =null;
        String sql = "" +
                " delete from showroom " +
                " where ShowroomName=? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, showroomName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,preparedStatement,null,null);
        }
    }
    //查询全部
    public List<Showroom> query() {
        Connection  connection = ZooUtil.getConnection();
        List<Showroom> showroom = new ArrayList<>();
        Statement  statement=null;
        ResultSet resultSet=null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(" select * from showroom ");
            while (resultSet.next()) {
                String showroomName = resultSet.getString("ShowroomName");
                String showroomIntroduction = resultSet.getString("ShowroomIntroduction");
                String showroomLocation = resultSet.getString("ShowroomLocation");
                String showroomLocationSize = resultSet.getString("ShowroomLocationSize");
                String showroomKeeper = resultSet.getString("ShowroomKeeper");
                Showroom showroom1 = new Showroom(showroomName, showroomIntroduction,
                        showroomLocation, showroomLocationSize, showroomKeeper);
                showroom.add(showroom1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,null,resultSet,statement);
        }
        return showroom;
    }
    //管理员查询自己族群的信息
    public List<Showroom> query(String showroomKeeper)  {
        List<Showroom> showroom = new ArrayList<>();
        Connection  connection = ZooUtil.getConnection();
        PreparedStatement preparedStatement =null;
        ResultSet resultSet=null;
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from showroom ");
        sb.append(" where ShowroomKeeper=? ");
        Showroom showroom1 = null;
        try {
            preparedStatement = connection.prepareStatement(sb.toString());
            preparedStatement.setString(1, showroomKeeper);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                showroom1 = new Showroom();
                showroom1.setShowroomName(resultSet.getString("ShowroomName"));
                showroom1.setShowroomIntroduction(resultSet.getString("showroomIntroduction"));
                showroom1.setShowroomLocation(resultSet.getString("showroomLocation"));
                showroom1.setShowroomLocationSize(resultSet.getString("showroomLocationSize"));
                showroom1.setShowroomKeeper(resultSet.getString("showroomKeeper"));
                showroom.add(showroom1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,preparedStatement,resultSet,null);
        }
        return showroom;
    }

}
