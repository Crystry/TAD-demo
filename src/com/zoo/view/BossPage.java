package com.zoo.view;
/*
@author 黄浩
Boss界面
上半部分显示展厅的信息，可对展厅进行增删改查
下半部分显示管理员的信息，可对管理员进行增删改查
 */

import com.zoo.bean.Showroom;
import com.zoo.bean.User;
import com.zoo.model.ShowroomDao;
import com.zoo.model.UserDao;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//TODO 这里需要注意的问题和AttributeManagement类似
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
