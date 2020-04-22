package com.zoo.view;
/*
@author 黄浩
管理员界面
上半部分显示自己展厅的信息，可以对展厅的信息进行更新
下半部分显示自己管理的动物，可以动物进行增删改查
 */

import com.zoo.bean.Animal;
import com.zoo.bean.Showroom;
import com.zoo.model.AnimalDao;
import com.zoo.model.ShowroomDao;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//TODO 师弟你的View包里的问题和下面的这个文件中出现的问题类似，所以你的问题我就在这个文件中指出了，
// View包里的其他文件的代码也要记得改一下哦

//TODO 考核需求提到的用JavaFx实际上是想让师弟师妹们用xml写布局，所以关于一些对控件的设置
// 如设置控件的宽高啥的建议放在xml文件中，其他view的文件类似
public class AttributePage {
    //TODO 成员变量建议在前面加上字母m,如mStage，并且这里可以不用final修饰
    //TODO 关于这个Stage我看到你下面的几个类中都有用到Stage，思考一下如何封装会使代码更加的简洁呢，
    // 这个问题不只适用于stage，在使用相同代码的时候都考虑一下能不能封装
    //TODO 建议将代码从构造器中分离出来，如可以将初始化root的代码放在一个方法中，将初始化vBox的代码放在一个方法中，
    // 这里只是举个例子，具体的怎样去分离会比较使代码比较整洁还是要自己思考的哦
    //TODO 关于异常抛出的问题，并不是说异常抛出的越多越好，建议师弟思考一下代码中有需要抛出异常的必要吗

    //Todo 整个项目中有很多的常量，考虑一下我们怎么来管理这些常量，
    // 如果有一天我想要去修改这些常量，在这么多文件中去寻找岂不是很难受
    //TODO 关于事件处理这一块，建议考虑一下能不能通过实现一个接口的方式去简化一下你的代码，
    // 以及可以学习一下lambda表达式去简化你的代码
    //TODO 师弟建议思考一下这里有没有必要使用final，final的作用是什么呢
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
