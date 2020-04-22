package com.zoo.view;
/*
@author 黄浩
管理员界面
上半部分显示自己展厅的信息，可以对展厅的信息进行更新
下半部分显示自己管理的动物，可以动物进行增删改查
 */

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class AttributePage {
    public AttributePage(String ShowroomKeeper) {
        BorderPane root = new BorderPane();
        //顶部 展现管理员自己展厅的信息，
        AttributePageLayout attributePageLayout = new AttributePageLayout();
        root.setTop(attributePageLayout.setPageTop(ShowroomKeeper));
        //中部，展现管理员管理动物的信息
        root.setCenter(attributePageLayout.setPageCenter(ShowroomKeeper));
        Scene scene = new Scene(root);
        StageInitialization stageInitialization = new StageInitialization(scene);

    }
}
