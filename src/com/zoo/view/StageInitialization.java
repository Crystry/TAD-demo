package com.zoo.view;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageInitialization {
    private Integer DEFAULT_StageHeight=600;
    private Integer DEFAULT_StageWidth=1500;
    public StageInitialization(Scene scene){
        Stage mStage = new Stage();
        mStage.setScene(scene);
        mStage.setTitle("管理系统");
        mStage.setHeight(DEFAULT_StageHeight);
        mStage.setWidth(DEFAULT_StageWidth);
        mStage.show();
    }
}
