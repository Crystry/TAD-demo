package com.zoo.view;
/*
界面的封装
@author 黄浩
 */

import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageInitialization {
    private int DEFAULT_StageHeight=600;
    private int DEFAULT_StageWidth=1300;
    public StageInitialization(Scene scene){

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("管理系统");
        stage.setHeight(DEFAULT_StageHeight);
        stage.setWidth(DEFAULT_StageWidth);
        stage.show();
    }
}
