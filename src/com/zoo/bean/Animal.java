package com.zoo.bean;
/*
@author 黄浩
动物的实体类
 */

import javafx.beans.property.SimpleStringProperty;

public class Animal {

    private final SimpleStringProperty animalName=new SimpleStringProperty(this,"AnimalName");
    private  final SimpleStringProperty animalType=new SimpleStringProperty(this,"AnimalType");
    private final SimpleStringProperty animalSex=new SimpleStringProperty(this,"AnimalSex");
    private final SimpleStringProperty animalAge=new SimpleStringProperty(this,"AnimalAge");
    private final SimpleStringProperty animalIntroduction=new SimpleStringProperty(this,"AnimalIntroduction");
    private final SimpleStringProperty animalPresentSituation=new SimpleStringProperty(this,"AnimalPresentSituation");
    private final SimpleStringProperty animalKeeper=new SimpleStringProperty(this,"AnimalKeeper");

    public SimpleStringProperty animalNameProperty() {
        return animalName;
    }

    public final String getAnimalName() {
        return animalNameProperty().get();
    }

    public final void setAnimalName(String animalName) {
        animalNameProperty().set(animalName);
    }

    public SimpleStringProperty animalTypeProperty() {
        return animalType;
    }

    public final String getAnimalType() {
        return animalTypeProperty().get();
    }

    public final void setAnimalType(String animalType) {
        animalTypeProperty().set(animalType);
    }

    public SimpleStringProperty animalSexProperty() {
        return animalSex;
    }

    public final String getAnimalSex() {
        return animalSexProperty().get();
    }

    public final void setAnimalSex(String animalSex) {
        animalSexProperty().set(animalSex);
    }

    public SimpleStringProperty animalAgeProperty() {
        return animalAge;
    }

    public final String getAnimalAge() {
        return animalAgeProperty().get();
    }

    public final void setAnimalAge(String animalAge) {
        animalAgeProperty().set(animalAge);
    }

    public SimpleStringProperty animalIntroductionProperty() {
        return animalIntroduction;
    }

    public final String getAnimalIntroduction() {
        return animalIntroductionProperty().get();
    }

    public final void setAnimalIntroduction(String animalIntroduction) {
        animalIntroductionProperty().set(animalIntroduction);
    }

    public SimpleStringProperty animalPresentSituationProperty() {
        return animalPresentSituation;
    }

    public final String getAnimalPresentSituation() {
        return animalPresentSituationProperty().get();
    }

    public final void setAnimalPresentSituation(String animalPresentSituation) {
        animalPresentSituationProperty().set(animalPresentSituation);
    }

    public SimpleStringProperty animalKeeperProperty() {
        return animalKeeper;
    }

    public final String getAnimalKeeper() {
        return animalKeeperProperty().get();
    }

    public final void setAnimalKeeper(String animalKeeper) {
        animalKeeperProperty().set(animalKeeper);
    }

    public Animal(){

    }
    public Animal(String AnimalName,String AnimalType ,String AnimalSex,String AnimalAge,
                  String AnimalIntroduction, String PresentSituation,String AnimalKeeper){
        setAnimalName(AnimalName);
        setAnimalType(AnimalType);
        setAnimalSex(AnimalSex);
        setAnimalAge(AnimalAge);
        setAnimalIntroduction(AnimalIntroduction);
        setAnimalPresentSituation(PresentSituation);
        setAnimalKeeper(AnimalKeeper);
    }


}
