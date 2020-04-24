package com.zoo.bean;
/*
用户的实体类
@author 黄浩
 */

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final StringProperty password=new SimpleStringProperty(this,"Password");
    private final IntegerProperty id= new SimpleIntegerProperty(this,"Id") ;
    private final StringProperty name=new SimpleStringProperty(this,"Name");
    private final StringProperty identity=new SimpleStringProperty(this,"Identity");
    private final StringProperty attribute=new SimpleStringProperty(this,"Attribute");


    public IntegerProperty IdProperty(){
        return id;
    }
    public Integer getId() {
        return IdProperty().get();
    }

    public void setId(Integer id) {
        IdProperty().set(id);
    }

    public StringProperty NameProperty(){
        return name;
    }
    public String getName() {
        return NameProperty().get();
    }

    public void setName(String name) {
        NameProperty().set(name);
    }

    public StringProperty PasswordProperty(){
        return password;
    }

    public String getPassword() {
        return password.get();
    }
    public void setPassword(String password){
        PasswordProperty().set(password);
    }

    public StringProperty IdentityProperty(){
        return identity;
    }
    public String getIdentity() {
        return IdentityProperty().get();
    }

    public void setIdentity(String identity) {
        IdentityProperty().set(identity);
    }

    public StringProperty attributeProperty() {
        return attribute;
    }

    public String getAttribute() {
        return attribute.get();
    }
    public void setAttribute(String attribute){
        attributeProperty().set(attribute);
    }

    public User(){

    }

    public User(Integer Id, String Name, String Password,String Identity) {
        setId(Id);
        setName(Name);
        setPassword(Password);
        setIdentity(Identity);
    }
}
