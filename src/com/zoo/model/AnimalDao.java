package com.zoo.model;
/*
动物的增删改查，对数据库的操作
@author 黄浩
 */

import com.zoo.bean.Animal;
import com.zoo.util.ZooUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao {

    //添加新的动物
    public  void addAnimal(Animal animal) {
        Connection connection = ZooUtil.getConnection();
        PreparedStatement preparedStatement=null;
            try {
                String sql = "" +
                        " insert into animal " +
                        " (AnimalName,AnimalType,AnimalSex,AnimalAge,AnimalIntroduction,AnimalPresentSituation, " +
                        " AnimalKeeper) " +
                        " values( " +
                        " ?,?,?,?,?,?,?) ";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, animal.getAnimalName());
                preparedStatement.setString(2, animal.getAnimalType());
                preparedStatement.setString(3, animal.getAnimalSex());
                preparedStatement.setString(4, animal.getAnimalAge());
                preparedStatement.setString(5, animal.getAnimalIntroduction());
                preparedStatement.setString(6, animal.getAnimalPresentSituation());
                preparedStatement.setString(7, animal.getAnimalKeeper());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ZooUtil.close(connection,preparedStatement,null,null);
            }

        }
    //更新动物
    public  void updateAnimal(Animal animal) {
        Connection connection = ZooUtil.getConnection();
            String sql = "" +
                    " update  animal " +
                    " set  AnimalType=?,AnimalSex=?,AnimalAge=?,AnimalIntroduction=?, " +
                    " AnimalPresentSituation=?,AnimalKeeper=? " +
                    " where AnimalName=? ";
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, animal.getAnimalType());
                preparedStatement.setString(2, animal.getAnimalSex());
                preparedStatement.setString(3, animal.getAnimalAge());
                preparedStatement.setString(4, animal.getAnimalIntroduction());
                preparedStatement.setString(5, animal.getAnimalPresentSituation());
                preparedStatement.setString(6, animal.getAnimalKeeper());
                preparedStatement.setString(7, animal.getAnimalName());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ZooUtil.close(connection,preparedStatement,null,null);
            }
    }
    //删除动物
    public  void deleteAnimal(String animalName)  {
        Connection connection = ZooUtil.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "" +
                " delete from animal " +
                " where AnimalName=? ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, animalName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection, preparedStatement, null, null);
        }
    }

    //游客进行查询
    public List<Animal>query (String AnimalType)  {
        Connection connection = ZooUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" select * from animal ");
        stringBuilder.append(" where AnimalType=? ");
        List<Animal> animal = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(stringBuilder.toString());
            preparedStatement.setString(1, AnimalType);
            resultSet =preparedStatement.executeQuery();
            while ( resultSet.next()) {
                String animalName=  resultSet.getString("animalName");
                String animalType =  resultSet.getString("animalType");
                String animalSex =  resultSet.getString("animalSex");
                String animalAge =  resultSet.getString("animalAge");
                String animalIntroduction =  resultSet.getString("animalIntroduction");
                String animalPresentSituation =  resultSet.getString("animalPresentSituation");
                String animalKeeper =  resultSet.getString("animalKeeper");
                Animal A = new Animal(animalName, animalType, animalSex, animalAge,
                        animalIntroduction, animalPresentSituation, animalKeeper);
                animal.add(A);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,preparedStatement,resultSet,null);
        }
        return animal;
    }
    //管理员查询自己管理的动物
    public List<Animal>  get (String name)  {
        Connection connection = ZooUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        StringBuilder sb = new StringBuilder();
        sb.append(" select * from animal ");
        sb.append(" where AnimalKeeper=? ");
        List<Animal> animal = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sb.toString());
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String animalName = resultSet.getString("animalName");
                String animalType =  resultSet.getString("animalType");
                String animalSex =  resultSet.getString("animalSex");
                String animalAge =  resultSet.getString("animalAge");
                String animalIntroduction =  resultSet.getString("animalIntroduction");
                String animalPresentSituation =  resultSet.getString("animalPresentSituation");
                String animalKeeper =  resultSet.getString("animalKeeper");
                Animal _animal = new Animal(animalName, animalType, animalSex, animalAge,
                        animalIntroduction, animalPresentSituation, animalKeeper);
                animal.add(_animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ZooUtil.close(connection,preparedStatement,resultSet,null);
        }
        return animal;
    }
}
