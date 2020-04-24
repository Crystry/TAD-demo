package com.zoo.model;
/*
用户的增删改查，对数据库的操作
@author 黄浩
 */


import com.zoo.bean.User;
import com.zoo.util.ZooUtil;
import java.sql.*;
import java.util.*;


public class UserDao {
    //增加用户
    public void addUser(User user)  {
        Connection connection= ZooUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql = "" +
                " insert into user " +
                " (Name,Password,Attribute,Identity) " +
                " values( " +
                " ?,?,?,?) ";
        try {
            preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3,user.getAttribute());
            preparedStatement.setString(4, user.getIdentity());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,preparedStatement,null,null);
        }
    }
    //更新用户
    public void updateUser(User user)  {
        Connection connection= ZooUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql = "" +
                " update  user " +
                " set Password=?,Identity=?,Attribute=? " +
                " where Name=? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getIdentity());
            preparedStatement.setString(3, user.getAttribute());
            preparedStatement.setString(4, user.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,preparedStatement,null,null);
        }
    }
    //删除用户
    public void deleteUser(String name)  {
        Connection connection= ZooUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql = "" +
                " delete from user " +
                " where Name =? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,preparedStatement,null,null);
        }
    }

    //查询全部
    public List<User> query()  {
        Connection connection= ZooUtil.getConnection();
        Statement statement=null;
        List<User> user = new ArrayList<>();
        ResultSet resultSet =null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(" select * from user where Attribute='Administrator' ");
            while (resultSet.next()) {
                Integer id=resultSet.getInt("Id");
                String name=resultSet.getString("Name");
                String password=resultSet.getString("Password");
                String identity=resultSet.getString("Identity");
                User u=new User(id,name,password,identity);
                user.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,null,resultSet,statement);
        }
        return user;
    }

    //查询Name
    public boolean selectName(String name) {
        String Name = null;
        Connection connection= ZooUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql = " select * from user ";
        ResultSet resultSet =null;
        try {
            preparedStatement = connection.prepareStatement(sql);
             resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Name = resultSet.getString("Name");
                if (Name.equals(name)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,preparedStatement,null,null);
        }
        return false;
    }

    public boolean selectPassword(String name, String password) {
        String Password = null;
        Connection connection= ZooUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        String sql = " select Password from user where Name='" + name + "' ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Password = resultSet.getString("Password");
                if (Password.equals(password)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,preparedStatement,null,null);
        }
        return false;
    }

    public boolean selectIdentity(String name, String identity) {
        String Identity = null;
        Connection connection= ZooUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet =null;
        String sql = " select * from user where Name='" + name + "' ";
        try {
            preparedStatement = connection.prepareStatement(sql);
             resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Identity = resultSet.getString("Identity");
                if (Identity.equals(identity)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,preparedStatement,null,null);
        }
        return false;
    }
}

