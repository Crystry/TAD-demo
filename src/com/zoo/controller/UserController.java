package com.zoo.controller;
/*
用户方法的控制器
@author 黄浩
 */
import com.zoo.bean.User;
import com.zoo.model.UserDao;

import java.util.List;

public class UserController {
    public void addUser(User user)  {
        UserDao dao=new UserDao();
        dao.addUser(user);
    }
    public void updateUser(User user)  {
        UserDao dao=new UserDao();
        dao.updateUser(user);
    }
    public void deleteUser(String name)  {
        UserDao dao=new UserDao();
        dao.deleteUser(name);
    }
    public List<User> query()  {
        UserDao dao=new UserDao();
        return dao.query();
    }

    public boolean selectName(String name) {
        UserDao dao=new UserDao();
        return dao.selectName(name);
    }
    public boolean selectPassword(String name, String password) {
        UserDao dao=new UserDao();
        return dao.selectPassword(name,password);
    }
    public boolean selectIdentity(String name, String identity) {
        UserDao dao=new UserDao();
        return dao.selectIdentity(name,identity);
    }
}
