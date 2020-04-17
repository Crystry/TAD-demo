package com.zoo.controller;

import com.zoo.model.Animal;
import com.zoo.util.AnimalWay;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AnimalAction {
    public void addAnimal(Animal animal) throws SQLException {
        AnimalWay way=new AnimalWay();
        way.addAnimal(animal);
    }
    public void update(Animal animal) throws SQLException {
        AnimalWay way=new AnimalWay();
        way.updateAnimal(animal);
    }
    public void delete(String AnimalName) throws SQLException {
        AnimalWay way=new AnimalWay();
        way.deleteAnimal(AnimalName);
    }
    public static List<Animal> query() throws Exception {

        AnimalWay way=new AnimalWay();
        return way.query();
    }

    public List<Animal> query(String aAnimalType) throws Exception {

        AnimalWay way=new AnimalWay();
        return way.query(aAnimalType);
    }
    public List<Animal> get(String aName) throws SQLException {
        AnimalWay way=new AnimalWay();
        return way.get(aName);
    }







}