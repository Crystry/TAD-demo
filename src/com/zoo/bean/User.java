package com.zoo.bean;
/*
@author 黄浩
用户的实体类
 */

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

//TODO 关于实体类，一般是放在bean包里的，model包一般放的是一些关于数据库的操作,
// 下面提及的问题的话记得在其他的实体类中也记得改呀
public class User {

    //TODO 这里的final修饰符的作用是什么呢？建议的话这里可以省去final
    //TODO 成员变量的命名的话采用驼峰命名法，首字母小写
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

    //TODO 这里的方法中的变量命名建议去掉a
    public User(Integer Id, String Name, String Password,String Identity) {
        setId(Id);
        setName(Name);
        setPassword(Password);
        setIdentity(Identity);
    }
}
