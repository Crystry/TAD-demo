package com.zoo.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    private final StringProperty Password=new SimpleStringProperty(this,"Password");


    private final IntegerProperty Id=new SimpleIntegerProperty(this,"Id");
    private final StringProperty Name=new SimpleStringProperty(this,"Name");
    private final StringProperty Identity=new SimpleStringProperty(this,"Identity");
    private final StringProperty Attribute=new SimpleStringProperty(this,"Attribute");


    public IntegerProperty IdProperty(){
        return Id;
    }
    public Integer getId() {
        //return Id;
        return IdProperty().get();
    }

    public void setId(Integer id) {
        IdProperty().set(id);
    }

    public StringProperty NameProperty(){
        return Name;
    }
    public String getName() {
        return NameProperty().get();
    }

    public void setName(String name) {
        NameProperty().set(name);
    }

    public StringProperty PasswordProperty(){
        return Password;
    }

    public String getPassword() {
        return Password.get();
    }
    public void setPassword(String password){
        PasswordProperty().set(password);
    }

    public StringProperty IdentityProperty(){
        return Identity;
    }
    public String getIdentity() {
        return IdentityProperty().get();
    }

    public void setIdentity(String identity) {
        IdentityProperty().set(identity);
    }

    public StringProperty attributeProperty() {
        return Attribute;
    }

    public String getAttribute() {
        return Attribute.get();
    }
    public void setAttribute(String attribute){
        attributeProperty().set(attribute);
    }

    public User(){

    }
    public User(Integer aId, String aName, String aPassword,String aIdentity) {
        setId(aId);
        setName(aName);
        setPassword(aPassword);
        setIdentity(aIdentity);
    }
}
