package com.zoo.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Showroom {
    private final StringProperty ShowroomName=new SimpleStringProperty(this,"ShowroomName");
    private final StringProperty ShowroomIntroduction=new SimpleStringProperty(this,"ShowroomIntroduction");
    private final StringProperty ShowroomLocation=new SimpleStringProperty(this,"ShowroomLocation");
    private final StringProperty ShowroomLocationSize=new SimpleStringProperty(this,"ShowroomLocationSize");
    private final StringProperty ShowroomKeeper=new SimpleStringProperty(this,"ShowroomKeeper");

    public StringProperty showroomNameProperty() {
        return ShowroomName;
    }

    public final String getShowroomName() {
        return showroomNameProperty().get();
    }

    public void setShowroomName(String showroomName) {
        showroomNameProperty().set(showroomName);
    }

    public StringProperty showroomIntroductionProperty() {
        return ShowroomIntroduction;
    }

    public String getShowroomIntroduction() {
        return showroomIntroductionProperty().get();
    }

    public void setShowroomIntroduction(String showroomIntroduction) {
        showroomIntroductionProperty().set(showroomIntroduction);
    }

    public StringProperty showroomLocationProperty() {
        return ShowroomLocation;
    }

    public String getShowroomLocation() {
        return showroomLocationProperty().get();
    }

    public void setShowroomLocation(String showroomLocation) {
        showroomLocationProperty().set(showroomLocation);
    }

    public StringProperty showroomLocationSizeProperty() {
        return ShowroomLocationSize;
    }

    public String getShowroomLocationSize() {
        return ShowroomLocationSize.get();
    }

    public void setShowroomLocationSize(String showroomLocationSize) {
        showroomLocationSizeProperty().set(showroomLocationSize);
    }

    public StringProperty showroomKeeperProperty() {
        return ShowroomKeeper;
    }

    public String getShowroomKeeper() {
        return showroomKeeperProperty().get();
    }

    public void setShowroomKeeper(String showroomKeeper) {
        showroomKeeperProperty().set(showroomKeeper);
    }

    public Showroom(){

    }
    public Showroom(String aShowroomName,String aShowroomIntroduction,
                    String aShowroomLocation,String aShowroomLocationSize,
                    String aShowroomKeeper){
        setShowroomName(aShowroomName);
        setShowroomIntroduction(aShowroomIntroduction);
        setShowroomLocation(aShowroomLocation);
        setShowroomLocationSize(aShowroomLocationSize);
        setShowroomKeeper(aShowroomKeeper);

    }

}
