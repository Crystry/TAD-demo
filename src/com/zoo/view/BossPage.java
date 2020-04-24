package com.zoo.view;
/*
Boss界面
上半部分显示展厅的信息，可对展厅进行增删改查
下半部分显示管理员的信息，可对管理员进行增删改查
@author 黄浩
 */

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class BossPage {

    public BossPage()  {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);

        BossPageLayout bossPageLayout=new BossPageLayout();

        //界面的顶部，展示展厅的信息，实现增删改查
        root.setTop(bossPageLayout.setPageTop());
        //中部显示管理员的信息
        root.setCenter(bossPageLayout.setPageCenter());
        StageInitialization stageInitialization=new StageInitialization(scene);
    }
}
