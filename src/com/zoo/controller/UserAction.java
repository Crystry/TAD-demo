package com.zoo.controller;

import com.zoo.model.User;
import com.zoo.util.UserWay;

import java.sql.SQLException;
import java.util.*;

public class UserAction {

    public void add(User user) throws SQLException {
        UserWay way=new UserWay();
        way.addUser(user);
    }


    public void update(User user) throws SQLException {
        UserWay way=new UserWay();
        way.updateUser(user);
    }

    public void delete(String Name) throws SQLException {
        UserWay way=new UserWay();
        way.deleteUser(Name);
    }
    public List<User> query(String Name) throws SQLException {
        UserWay way=new UserWay();
        return way.query(Name);
    }
    public List<User> query() throws Exception {
        UserWay way=new UserWay();
        return way.query();
    }


}





