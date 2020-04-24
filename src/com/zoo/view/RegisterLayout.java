package com.zoo.view;

import com.zoo.bean.User;
import com.zoo.controller.UserController;
import com.zoo.util.ZooUtil;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.Connection;

public class RegisterLayout {
    private int DEFAULT_FONT=14;
    private int DEFAULT_HGAP=5;
    private int DEFAULT_VGAP=17;
    public Node Layout(Stage stage)
    { 
        GridPane gridPane =new GridPane();
        gridPane.setStyle("-fx-background-color: #FFF5EE");


        Label labelName=new Label("请设置用户名：");
        labelName.setFont(Font.font(DEFAULT_FONT));

        Label labelPassword=new Label("请设置密码：");
        labelPassword.setFont(Font.font(DEFAULT_FONT));

        Label labelPassword1=new Label("请重新输入密码：");
        labelPassword.setFont(Font.font(DEFAULT_FONT));

        Button register =new Button("注册");

        TextField textFieldName =new TextField();
        textFieldName.setTooltip(new Tooltip("请输入用户名："));
        PasswordField passwordFieldName =new PasswordField();
        passwordFieldName.setTooltip(new Tooltip("请输入密码："));
        PasswordField passwordFieldName1 =new PasswordField();
        passwordFieldName1.setTooltip(new Tooltip("请重新输入密码："));

        gridPane.add(labelName,0,0);
        gridPane.add(textFieldName,1,0);
        gridPane.add(labelPassword,0,1);
        gridPane.add(passwordFieldName,1,1);
        gridPane.add(labelPassword1,0,2);
        gridPane.add(passwordFieldName1,1,2);


        gridPane.add(register, 2,3);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.setHgap(DEFAULT_HGAP);
        gridPane.setVgap(DEFAULT_VGAP);
        UserController userController=new UserController();
        //注册按钮
        register.setOnAction(actionEvent->{
            Connection conn= ZooUtil.getConnection();
            String name=textFieldName.getText();          //获取文本上的字符
            String password=passwordFieldName.getText();
            String password1=passwordFieldName1.getText();
            if(name!=null &&password!=null) {
                if (password.equals(password1)) {
                    User user = new User();
                    user.setName(name);
                    user.setPassword(password);
                    user.setIdentity("Tourist");
                    user.setAttribute("Tourist");
                    userController.addUser(user);   //  调用增加游客的方法
                    stage.close();
                } else {
                    stage.setTitle("密码输入不相同，请重新输入");
                    passwordFieldName.setText("");
                    passwordFieldName1.setText("");
                }
            }else {
                stage.setTitle("用户名或者密码为空！");
            }
        });
             return gridPane;
    }
    
}
