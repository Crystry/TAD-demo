package com.zoo.util;

import com.zoo.model.Animal;
import com.zoo.controller.ZooUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//TODO util层一般放的是工具类，对数据库的操作一般是放在model层，util包中的其他文件也是一样的哦，
// 以及师弟，注意一下你的文件的命名，文件命名一般要求明了，（我最初看到你的这个命名不知道里面写的是什么），
// 建议修改一下你的文件命名
public class AnimalWay {
    //添加新的动物

    //TODO 关于数据库异常的处理，一般的话就是直接在这里try catch处理掉，不建议的话再往外抛，
    // 如果可以的话，对于增加删除等操作的话操作成功之后给外部一些反馈，不然人家不知道到底增加或删除成功没
    public void addAnimal(Animal animal) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " insert into animal " +
                " (AnimalName,AnimalType,AnimalSex,AnimalAge,AnimalIntroduction,AnimalPresentSituation," +
                " AnimalKeeper) " +
                " values( " +
                " ?,?,?,?,?,?,?) ";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, animal.getAnimalName());
        ptmt.setString(2, animal.getAnimalType());
        ptmt.setString(3, animal.getAnimalSex());
        ptmt.setString(4, animal.getAnimalAge());
        ptmt.setString(5, animal.getAnimalIntroduction());
        ptmt.setString(6, animal.getAnimalPresentSituation());
        ptmt.setString(7, animal.getAnimalKeeper());
        // ptmt.setString(8, animal.getAttribute());
        ptmt.execute();

    }
    //更新动物
    public void updateAnimal(Animal animal) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " update  animal " +
                " set  AnimalType=?,AnimalSex=?,AnimalAge=?,AnimalIntroduction=?, " +
                " AnimalPresentSituation=?,AnimalKeeper=? " +
                " where AnimalName=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, animal.getAnimalType());
        ptmt.setString(2, animal.getAnimalSex());
        ptmt.setString(3, animal.getAnimalAge());
        ptmt.setString(4, animal.getAnimalIntroduction());
        ptmt.setString(5, animal.getAnimalPresentSituation());
        ptmt.setString(6, animal.getAnimalKeeper());
        // ptmt.setString(7, animal.getAttribute());
        ptmt.setString(7, animal.getAnimalName());
        ptmt.execute();



    }
    //删除动物
    public void deleteAnimal(String AnimalName) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " delete from animal " +
                " where AnimalName=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setString(1, AnimalName);
        ptmt.execute();

    }

    //查询全部
    public List<Animal> query() throws SQLException {
        Connection conn = ZooUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs;
        rs = stmt.executeQuery(" select * from animal ");

        ObservableList<Animal> animal =FXCollections.observableArrayList();

        while (rs.next()) {
            String animalName=rs.getString("animalName");
            String animalType=rs.getString("animalType");
            String animalSex=rs.getString("animalSex");
            String animalAge=rs.getString("animalAge");
            String animalIntroduction=rs.getString("animalIntroduction");
            String animalPresentSituation=rs.getString("animalPresentSituation");
            String animalKeeper = rs.getString("animalKeeper");
            Animal A=new Animal(animalName,animalType,animalSex,animalAge,
                    animalIntroduction,animalPresentSituation,animalKeeper);
            animal.add(A);
        }
        return animal;

    }

    //游客进行查询
    public List<Animal>query (String AnimalType) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from animal ");
        sb.append(" where AnimalType=? ");
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ptmt.setString(1, AnimalType);
        ResultSet rs = ptmt.executeQuery();
        List<Animal> animal = new ArrayList<>();
        while (rs.next()) {
            String animalName = rs.getString("animalName");
            String animalType = rs.getString("animalType");
            String animalSex = rs.getString("animalSex");
            String animalAge = rs.getString("animalAge");
            String animalIntroduction = rs.getString("animalIntroduction");
            String animalPresentSituation = rs.getString("animalPresentSituation");
            String animalKeeper = rs.getString("animalKeeper");
            Animal A = new Animal(animalName, animalType, animalSex, animalAge,
                    animalIntroduction, animalPresentSituation, animalKeeper);
            animal.add(A);

        }
        return animal;
    }
    //管理员查询自己管理的动物
    public List<Animal>  get (String name) throws SQLException {
        Connection conn = ZooUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from animal ");
        sb.append(" where AnimalKeeper=? ");
        PreparedStatement ptmt = conn.prepareStatement(sb.toString());
        ptmt.setString(1, name);
        ResultSet rs = ptmt.executeQuery();
        List<Animal> animal = new ArrayList<>();
        while (rs.next()) {
            String animalName = rs.getString("animalName");
            String animalType = rs.getString("animalType");
            String animalSex = rs.getString("animalSex");
            String animalAge = rs.getString("animalAge");
            String animalIntroduction = rs.getString("animalIntroduction");
            String animalPresentSituation = rs.getString("animalPresentSituation");
            String animalKeeper = rs.getString("animalKeeper");
            Animal A = new Animal(animalName, animalType, animalSex, animalAge,
                    animalIntroduction, animalPresentSituation, animalKeeper);
            animal.add(A);

        }
        return animal;
    }


}
