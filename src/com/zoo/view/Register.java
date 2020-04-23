package com.zoo.view;
/*
@author 黄浩
注册界面
 */

import com.zoo.bean.User;
import com.zoo.util.ZooUtil;
import com.zoo.model.UserDao;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.Connection;

public class Register {
    private Integer DEFAULT_HEIGHT=300,DEFAULT_WIDTH=500;
    private Integer DEFAULT_FONT=14;
    private Integer DEFAULT_HGAP=5,DEFAULT_VGAP=17;
    private final Stage stage=new Stage();
    //TODO 构造器中的代码可以思考一下能不能将他分离出来
    public Register(){
        GridPane gr =new GridPane();
        gr.setStyle("-fx-background-color: #FFF5EE");

        Scene scene=new Scene(gr);
        stage.setScene(scene);
        stage.setTitle("Register");
        stage.setHeight(DEFAULT_HEIGHT);
        stage.setWidth(DEFAULT_WIDTH);
        stage.setResizable(false);

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

        gr.add(labelName,0,0);
        gr.add(textFieldName,1,0);
        gr.add(labelPassword,0,1);
        gr.add(passwordFieldName,1,1);
        gr.add(labelPassword1,0,2);
        gr.add(passwordFieldName1,1,2);


        gr.add(register, 2,3);
        gr.setAlignment(Pos.CENTER);

        gr.setHgap(DEFAULT_HGAP);
        gr.setVgap(DEFAULT_VGAP);

        UserDao dao=new UserDao();

        stage.show();
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
                        dao.addUser(user);   //  调用增加游客的方法
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
    }

}
