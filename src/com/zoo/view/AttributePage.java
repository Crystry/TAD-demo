package com.zoo.view;
/*
管理员界面
上半部分显示自己展厅的信息，可以对展厅的信息进行更新
下半部分显示自己管理的动物，可以动物进行增删改查
@author 黄浩
 */

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class AttributePage {
    public AttributePage(String showroomKeeper) {
        BorderPane root = new BorderPane();
        //顶部 展现管理员自己展厅的信息，
        AttributePageLayout attributePageLayout = new AttributePageLayout();
        root.setTop(attributePageLayout.setPageTop(showroomKeeper));
        //中部，展现管理员管理动物的信息
        root.setCenter(attributePageLayout.setPageCenter(showroomKeeper));
        Scene scene = new Scene(root);
        StageInitialization stageInitialization = new StageInitialization(scene);

    }
}
