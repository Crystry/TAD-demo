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
    private Integer DEFAULT_WIDTH=150;
    private Integer DEFAULT_HEIGHT=50;
    private Integer DEFAULT_StageHeight=600;
    private Integer DEFAULT_StageWidth=1500;
    public AttributePage(String ShowroomKeeper) {
        BorderPane root = new BorderPane();
        //顶部 展现管理员自己展厅的信息，
        ShowroomDao dao=new ShowroomDao();
        TableView<Showroom> table1 = new TableView<>();

        //Todo 整个项目中有很多的常量，考虑一下我们怎么来管理这些常量，
        // 如果有一天我想要去修改这些常量，在这么多文件中去寻找岂不是很难受
        table1.setMaxHeight(DEFAULT_HEIGHT);
        TableColumn<Showroom, String> first1 = new TableColumn<>("ShowroomName");
        first1.setCellValueFactory(param->param.getValue().showroomNameProperty());

        TableColumn<Showroom, String> second1 = new TableColumn<>("ShowroomIntroduction");
        second1.setCellValueFactory(new PropertyValueFactory<>("ShowroomIntroduction"));

        TableColumn<Showroom, String> third1 = new TableColumn<>("ShowroomLocation");
        third1.setCellValueFactory(new PropertyValueFactory<>("ShowroomLocation"));

        TableColumn<Showroom, String> forth1 = new TableColumn<>("ShowroomLocationSize");
        forth1.setCellValueFactory(new PropertyValueFactory<>("ShowroomLocationSize"));

        TableColumn<Showroom, String> fifth1 = new TableColumn<>("ShowroomKeeper");
        fifth1.setCellValueFactory(new PropertyValueFactory<>("ShowroomKeeper"));

        table1.getColumns().addAll(first1, second1, third1,forth1,fifth1);
        table1.getItems().addAll(dao.query(ShowroomKeeper));

        TextField showroomName=new TextField();
        showroomName.setPromptText("请输入名称");
        TextField showroomIntroduction=new TextField();
        showroomIntroduction.setPromptText("请输入展厅介绍");
        TextField showroomLocation=new TextField();
        showroomLocation.setPromptText("请输入展厅位置");
        TextField showroomLocationSize=new TextField();
        showroomLocationSize.setPromptText("请输入展厅的面积大小");
        TextField showroomKeeper=new TextField();
        showroomKeeper.setPromptText("请输入展厅管理员");

        Button update=new Button("更新");
        //更新按钮的实现
        //TODO 关于事件处理这一块，建议考虑一下能不能通过实现一个接口的方式去简化一下你的代码，
        // 以及可以学习一下lambda表达式去简化你的代码
        update.setOnAction(actionEvent->{
                Showroom showroom=new Showroom();
                showroom.setShowroomIntroduction(showroomIntroduction.getText());
                showroom.setShowroomLocation(showroomLocation.getText());
                showroom.setShowroomLocationSize(showroomLocationSize.getText());
                showroom.setShowroomKeeper(showroomKeeper.getText());
                showroom.setShowroomName(showroomName.getText());
            dao.updateShowroom(showroom);
            table1.getItems().clear();
            table1.getItems().addAll(dao.query(ShowroomKeeper));
            showroomName.clear();
                showroomIntroduction.clear();
                showroomLocation.clear();
                showroomLocationSize.clear();
                showroomKeeper.clear();
        });
        HBox hBox=new HBox(showroomName,showroomIntroduction,showroomLocation,
                showroomLocationSize,showroomKeeper,update);
        VBox vBox=new VBox(hBox,table1);
        root.setTop(vBox);
        //中部，展现管理员管理动物的信息
        TableView<Animal> table = new TableView<>();

        TableColumn<Animal, String> first = new TableColumn<>("AnimalName");
        first.setMinWidth(DEFAULT_WIDTH);
        first.setCellValueFactory(new PropertyValueFactory<>("AnimalName"));

        TableColumn<Animal, String> second = new TableColumn<>("AnimalType");
        second.setMinWidth(DEFAULT_WIDTH);
        second.setCellValueFactory(new PropertyValueFactory<>("AnimalType"));

        TableColumn<Animal, String> third = new TableColumn<>("AnimalSex");
        third.setMinWidth(DEFAULT_WIDTH);
        third.setCellValueFactory(new PropertyValueFactory<>("AnimalSex"));


        TableColumn<Animal, String> forth = new TableColumn<>("AnimalAge");
        forth.setMinWidth(DEFAULT_WIDTH);
        forth.setCellValueFactory(new PropertyValueFactory<>("AnimalAge"));


        TableColumn<Animal, String> fifth = new TableColumn<>("AnimalIntroduction");
        fifth.setMinWidth(DEFAULT_WIDTH);
        fifth.setCellValueFactory(new PropertyValueFactory<>("AnimalIntroduction"));


        TableColumn<Animal, String> sixth = new TableColumn<>("AnimalPresentSituation");
        sixth.setMinWidth(DEFAULT_WIDTH);
        sixth.setCellValueFactory(new PropertyValueFactory<>("AnimalPresentSituation"));


        TableColumn<Animal, String> seventh = new TableColumn<>("AnimalKeeper");
        seventh.setMinWidth(DEFAULT_WIDTH);
        seventh.setCellValueFactory(new PropertyValueFactory<>("AnimalKeeper"));
        table.getColumns().addAll(first, second, third,forth,fifth,sixth,seventh);

        AnimalDao dao1 =new AnimalDao();
        table.getItems().addAll(dao1.get(ShowroomKeeper));

        //底部
        //TODO 师弟建议思考一下这里有没有必要使用final，final的作用是什么呢
        final TextField addAnimalName=new TextField();
        addAnimalName.setPromptText("AnimalName");
        final TextField addAnimalType=new TextField();
        addAnimalType.setPromptText("AnimalType");
        final TextField addAnimalSex=new TextField();
        addAnimalSex.setPromptText("AnimalSex");
        final TextField addAnimalAge=new TextField();
        addAnimalAge.setPromptText("AnimalAge");
        final TextField addAnimalIntroduction=new TextField();
        addAnimalIntroduction.setPromptText("AnimalIntroduction");
        final TextField addAnimalPresentSituation=new TextField();
        addAnimalPresentSituation.setPromptText("AnimalPresentSituation");
        final TextField addAnimalKeeper=new TextField();
        addAnimalKeeper.setPromptText("AnimalKeeper");

        final Button addButton=new Button("添加");
        final Button updateButton=new Button("更新");
        final Button deleteButton=new Button("删除");

        HBox hBox1=new HBox();
        hBox1.getChildren().addAll(addAnimalName,addAnimalType,addAnimalSex,
                addAnimalAge,addAnimalIntroduction,addAnimalPresentSituation,
                addAnimalKeeper,addButton,updateButton,deleteButton);
        root.setBottom(hBox1);

        root.setCenter(table);
        Scene scene = new Scene(root);
        Stage mStage = new Stage();
        mStage.setScene(scene);
        mStage.setTitle("管理系统");
        mStage.setHeight(DEFAULT_StageHeight);
        mStage.setWidth(DEFAULT_StageWidth);
        mStage.show();
        //增加按钮的实现
        addButton.setOnAction(actionEvent->{
                //TODO 建议修改一下命名方式哦
                Animal animal=new Animal();
                animal.setAnimalName(addAnimalName.getText());
                animal.setAnimalType(addAnimalType.getText());
                animal.setAnimalSex(addAnimalSex.getText());
                animal.setAnimalAge(addAnimalAge.getText());
                animal.setAnimalIntroduction(addAnimalIntroduction.getText());
                animal.setAnimalPresentSituation(addAnimalPresentSituation.getText());
                animal.setAnimalKeeper(addAnimalKeeper.getText());
                dao1.addAnimal(animal);
                table.getItems().clear();
                table.getItems().addAll(dao1.get(ShowroomKeeper));
            addAnimalName.clear();
                addAnimalAge.clear();
                addAnimalType.clear();
                addAnimalKeeper.clear();
                addAnimalPresentSituation.clear();
                addAnimalIntroduction.clear();
                addAnimalSex.clear();
        });
        //更新按钮实现
        updateButton.setOnAction(actionEvent->{
                Animal animal=new Animal();
                animal.setAnimalType(addAnimalType.getText());
                animal.setAnimalSex(addAnimalSex.getText());
                animal.setAnimalAge(addAnimalAge.getText());
                animal.setAnimalIntroduction(addAnimalIntroduction.getText());
                animal.setAnimalPresentSituation(addAnimalPresentSituation.getText());
                animal.setAnimalKeeper(addAnimalKeeper.getText());
                animal.setAnimalName(addAnimalName.getText());
            dao1.updateAnimal(animal);
            table.getItems().clear();
            table.getItems().addAll(dao1.get(ShowroomKeeper));
            addAnimalName.clear();
                addAnimalAge.clear();
                addAnimalType.clear();
                addAnimalKeeper.clear();
                addAnimalPresentSituation.clear();
                addAnimalIntroduction.clear();
                addAnimalSex.clear();

        });
        //删除按钮的实现
        deleteButton.setOnAction(actionEvent->{
                String name=addAnimalName.getText();
            dao1.deleteAnimal(name);
            table.getItems().clear();
            table.getItems().addAll(dao1.get(ShowroomKeeper));
            addAnimalName.clear();
        });
    }
}
