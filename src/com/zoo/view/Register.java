package com.zoo.view;
/**
注册界面
@author 黄浩
 */

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
