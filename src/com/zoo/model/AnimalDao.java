package com.zoo.model;
/*
@author 黄浩
动物的增删改查，对数据库的操作
 */

import com.zoo.bean.Animal;
import com.zoo.util.ZooUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao {
    //添加新的动物
    public  void addAnimal(Animal animal) {
            Connection conn = ZooUtil.getConnection();
            PreparedStatement ptmt = null;
            try {
                String sql = "" +
                        " insert into animal " +
                        " (AnimalName,AnimalType,AnimalSex,AnimalAge,AnimalIntroduction,AnimalPresentSituation, " +
                        " AnimalKeeper) " +
                        " values( " +
                        " ?,?,?,?,?,?,?) ";
                ptmt = conn.prepareStatement(sql);
                ptmt.setString(1, animal.getAnimalName());
                ptmt.setString(2, animal.getAnimalType());
                ptmt.setString(3, animal.getAnimalSex());
                ptmt.setString(4, animal.getAnimalAge());
                ptmt.setString(5, animal.getAnimalIntroduction());
                ptmt.setString(6, animal.getAnimalPresentSituation());
                ptmt.setString(7, animal.getAnimalKeeper());
                ptmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    //更新动物
    public  void updateAnimal(Animal animal) {
            Connection conn = ZooUtil.getConnection();
            String sql = "" +
                    " update  animal " +
                    " set  AnimalType=?,AnimalSex=?,AnimalAge=?,AnimalIntroduction=?, " +
                    " AnimalPresentSituation=?,AnimalKeeper=? " +
                    " where AnimalName=? ";
            PreparedStatement ptmt = null;
            try {
                ptmt = conn.prepareStatement(sql);
                ptmt.setString(1, animal.getAnimalType());
                ptmt.setString(2, animal.getAnimalSex());
                ptmt.setString(3, animal.getAnimalAge());
                ptmt.setString(4, animal.getAnimalIntroduction());
                ptmt.setString(5, animal.getAnimalPresentSituation());
                ptmt.setString(6, animal.getAnimalKeeper());
                ptmt.setString(7, animal.getAnimalName());
                ptmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
    //删除动物
    public  void deleteAnimal(String AnimalName)  {
        Connection conn = ZooUtil.getConnection();
        String sql = "" +
                " delete from animal " +
                " where AnimalName=? ";
        PreparedStatement ptmt = null;
        try {
            ptmt = conn.prepareStatement(sql);
            ptmt.setString(1, AnimalName);
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
    public List<Animal> query()  {
        Connection conn = ZooUtil.getConnection();
        Statement stmt = null;
        ResultSet rs=null;
        ObservableList<Animal> animal =FXCollections.observableArrayList();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(" select * from animal ");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            }
        return animal;

    }

    //游客进行查询
    public List<Animal>query (String AnimalType)  {
        Connection conn = ZooUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from animal ");
        sb.append(" where AnimalType=? ");
        PreparedStatement ptmt = null;
        ResultSet rs=null;
        List<Animal> animal = new ArrayList<>();
        try {
            ptmt = conn.prepareStatement(sb.toString());
            ptmt.setString(1, AnimalType);
             rs = ptmt.executeQuery();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return animal;
    }
    //管理员查询自己管理的动物
    public List<Animal>  get (String name)  {
        Connection conn = ZooUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from animal ");
        sb.append(" where AnimalKeeper=? ");
        PreparedStatement ptmt = null;
        ResultSet rs=null;
        List<Animal> animal = new ArrayList<>();
        try {
            ptmt = conn.prepareStatement(sb.toString());
            ptmt.setString(1, name);
            rs = ptmt.executeQuery();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return animal;
    }


}
