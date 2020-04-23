package com.zoo.view;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageInitialization {
    private Integer DEFAULT_StageHeight=600;
    private Integer DEFAULT_StageWidth=1500;
    public StageInitialization(Scene scene){
        //TODO 师弟可以再去了解一下局部变量和成员变量已经他们的命名方式
        Stage mStage = new Stage();
        mStage.setScene(scene);
        mStage.setTitle("管理系统");
        mStage.setHeight(DEFAULT_StageHeight);
        mStage.setWidth(DEFAULT_StageWidth);
        mStage.show();
    }
}
