package com.zoo.bean;
/*
展厅的实体类
@author 黄浩
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Showroom {
    private final StringProperty showroomName=new SimpleStringProperty(this,"ShowroomName");
    private final StringProperty showroomIntroduction=new SimpleStringProperty(this,"ShowroomIntroduction");
    private final StringProperty showroomLocation=new SimpleStringProperty(this,"ShowroomLocation");
    private final StringProperty showroomLocationSize=new SimpleStringProperty(this,"ShowroomLocationSize");
    private final StringProperty showroomKeeper=new SimpleStringProperty(this,"ShowroomKeeper");

    public StringProperty showroomNameProperty() {
        return showroomName;
    }

    public final String getShowroomName() {
        return showroomNameProperty().get();
    }

    public void setShowroomName(String showroomName) {
        showroomNameProperty().set(showroomName);
    }

    public StringProperty showroomIntroductionProperty() {
        return showroomIntroduction;
    }

    public String getShowroomIntroduction() {
        return showroomIntroductionProperty().get();
    }

    public void setShowroomIntroduction(String showroomIntroduction) {
        showroomIntroductionProperty().set(showroomIntroduction);
    }

    public StringProperty showroomLocationProperty() {
        return showroomLocation;
    }

    public String getShowroomLocation() {
        return showroomLocationProperty().get();
    }

    public void setShowroomLocation(String showroomLocation) {
        showroomLocationProperty().set(showroomLocation);
    }

    public StringProperty showroomLocationSizeProperty() {
        return showroomLocationSize;
    }

    public String getShowroomLocationSize() {
        return showroomLocationSize.get();
    }

    public void setShowroomLocationSize(String showroomLocationSize) {
        showroomLocationSizeProperty().set(showroomLocationSize);
    }

    public StringProperty showroomKeeperProperty() {
        return showroomKeeper;
    }

    public String getShowroomKeeper() {
        return showroomKeeperProperty().get();
    }

    public void setShowroomKeeper(String showroomKeeper) {
        showroomKeeperProperty().set(showroomKeeper);
    }

    public Showroom(){

    }
    public Showroom(String ShowroomName,String ShowroomIntroduction,
                    String ShowroomLocation,String ShowroomLocationSize,
                    String ShowroomKeeper){
        setShowroomName(ShowroomName);
        setShowroomIntroduction(ShowroomIntroduction);
        setShowroomLocation(ShowroomLocation);
        setShowroomLocationSize(ShowroomLocationSize);
        setShowroomKeeper(ShowroomKeeper);

    }

}
