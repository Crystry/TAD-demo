package com.zoo.controller;
/*
动物方法的控制器
@author 黄浩
 */

import com.zoo.bean.Animal;
import com.zoo.model.AnimalDao;

import java.util.List;

public class AnimalController {

    public  void addAnimal(Animal animal) {
        AnimalDao dao=new AnimalDao();
        dao.addAnimal(animal);
    }
    public  void updateAnimal(Animal animal) {
        AnimalDao dao=new AnimalDao();
        dao.updateAnimal(animal);
    }
    public  void deleteAnimal(String animalName)  {
        AnimalDao dao=new AnimalDao();
        dao.deleteAnimal(animalName);
    }

    public List<Animal>query (String animalType)  {
        AnimalDao dao=new AnimalDao();
        return dao.query(animalType);
    }
    public List<Animal>  get (String name)  {
        AnimalDao dao=new AnimalDao();
        return dao.get(name);
    }

}
