package com.zoo.view;
/*
注册界面
@author 黄浩
 */

import com.zoo.bean.User;
import com.zoo.controller.UserController;
import com.zoo.util.ZooUtil;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.Connection;

public class Register {
    private int DEFAULT_HEIGHT=300;
    private int DEFAULT_WIDTH=500;

    private final Stage stage=new Stage();
    public Register(){

        RegisterLayout registerLayout=new RegisterLayout();
        Scene scene=new Scene((Parent) registerLayout.Layout(stage));
        stage.setScene(scene);
        stage.setTitle("Register");
        stage.setHeight(DEFAULT_HEIGHT);
        stage.setWidth(DEFAULT_WIDTH);
        stage.setResizable(false);
        stage.show();

    }

}
