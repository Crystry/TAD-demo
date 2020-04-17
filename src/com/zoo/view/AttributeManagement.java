package com.zoo.view;
/*
管理员界面
 */

import com.zoo.controller.AnimalAction;
import com.zoo.controller.ShowroomAction;
import com.zoo.model.Animal;
import com.zoo.model.Showroom;
import com.zoo.util.AnimalWay;
import com.zoo.util.ShowroomWay;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.sql.SQLException;

import static javafx.scene.control.cell.TextFieldTableCell.forTableColumn;

//TODO 师弟你的View包里的问题和下面的这个文件中出现的问题类似，所以你的问题我就在这个文件中指出了，
// View包里的其他文件的代码也要记得改一下哦

//TODO 考核需求提到的用JavaFx实际上是想让师弟师妹们用xml写布局，所以关于一些对控件的设置
// 如设置控件的宽高啥的建议放在xml文件中，其他view的文件类似
public class AttributeManagement {
    //TODO 成员变量建议在前面加上字母m,如mStage，并且这里可以不用final修饰

    //TODO 关于这个Stage我看到你下面的几个类中都有用到Stage，思考一下如何封装会使代码更加的简洁呢，
    // 这个问题不只适用于stage，在使用相同代码的时候都考虑一下能不能封装
    private final Stage stage = new Stage();

    //TODO 建议将代码从构造器中分离出来，如可以将初始化root的代码放在一个方法中，将初始化vBox的代码放在一个方法中，
    // 这里只是举个例子，具体的怎样去分离会比较使代码比较整洁还是要自己思考的哦

    //TODO 关于异常抛出的问题，并不是说异常抛出的越多越好，建议师弟思考一下代码中有需要抛出异常的必要吗
    public AttributeManagement(String aName) throws Exception {
        BorderPane root = new BorderPane();
        //顶部 展现管理员自己展厅的信息，
        ShowroomAction action=new ShowroomAction();
        VBox vBox=new VBox();
        TableView<Showroom> table1 = new TableView<>();

        //Todo 整个项目中有很多的常量，考虑一下我们怎么来管理这些常量，
        // 如果有一天我想要去修改这些常量，在这么多文件中去寻找岂不是很难受
        table1.setMaxHeight(50);
        TableColumn<Showroom, String> first1 = new TableColumn<>("ShowroomName");
        first1.setCellValueFactory(new PropertyValueFactory<>("ShowroomName"));

        TableColumn<Showroom, String> second1 = new TableColumn<>("ShowroomIntroduction");
        second1.setCellValueFactory(new PropertyValueFactory<>("ShowroomIntroduction"));

        TableColumn<Showroom, String> third1 = new TableColumn<>("ShowroomLocation");
        third1.setCellValueFactory(new PropertyValueFactory<>("ShowroomLocation"));

        TableColumn<Showroom, String> forth1 = new TableColumn<>("ShowroomLocationSize");
        forth1.setCellValueFactory(new PropertyValueFactory<>("ShowroomLocationSize"));

        TableColumn<Showroom, String> fifth1 = new TableColumn<>("ShowroomKeeper");
        fifth1.setCellValueFactory(new PropertyValueFactory<>("ShowroomKeeper"));

        table1.getColumns().addAll(first1, second1, third1,forth1,fifth1);
        table1.getItems().addAll(action.query(aName));
        HBox hBox=new HBox();
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
        update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Showroom showroom=new Showroom();
                showroom.setShowroomIntroduction(showroomIntroduction.getText());
                showroom.setShowroomLocation(showroomLocation.getText());
                showroom.setShowroomLocationSize(showroomLocationSize.getText());
                showroom.setShowroomKeeper(showroomKeeper.getText());
                showroom.setShowroomName(showroomName.getText());
                ShowroomWay way=new ShowroomWay();
                try {
                    way.updateShowroom(showroom);
                    table1.refresh();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                showroomName.clear();
                showroomIntroduction.clear();
                showroomLocation.clear();
                showroomLocationSize.clear();
                showroomKeeper.clear();
            }
        });
        hBox.getChildren().addAll(showroomName,showroomIntroduction,showroomLocation,
                showroomLocationSize,showroomKeeper,update);
        vBox.getChildren().addAll(hBox,table1);

        root.setTop(vBox);
        //中部，展现管理员管理动物的信息
        TableView<Animal> table = new TableView<>();

        TableColumn<Animal, String> first = new TableColumn<>("AnimalName");
        first.setMinWidth(200);
        first.setCellValueFactory(new PropertyValueFactory<>("AnimalName"));


        TableColumn<Animal, String> second = new TableColumn<>("AnimalType");
        second.setMinWidth(100);
        second.setCellValueFactory(new PropertyValueFactory<>("AnimalType"));



        TableColumn<Animal, String> third = new TableColumn<>("AnimalSex");
        third.setMinWidth(100);
        third.setCellValueFactory(new PropertyValueFactory<>("AnimalSex"));


        TableColumn<Animal, String> forth = new TableColumn<>("AnimalAge");
        forth.setMinWidth(100);
        forth.setCellValueFactory(new PropertyValueFactory<>("AnimalAge"));


        TableColumn<Animal, String> fifth = new TableColumn<>("AnimalIntroduction");
        fifth.setMinWidth(200);
        fifth.setCellValueFactory(new PropertyValueFactory<>("AnimalIntroduction"));


        TableColumn<Animal, String> sixth = new TableColumn<>("AnimalPresentSituation");
        sixth.setMinWidth(100);
        sixth.setCellValueFactory(new PropertyValueFactory<>("AnimalPresentSituation"));


        TableColumn<Animal, String> seventh = new TableColumn<>("AnimalKeeper");
        seventh.setMinWidth(200);
        seventh.setCellValueFactory(new PropertyValueFactory<>("AnimalKeeper"));
        table.getColumns().addAll(first, second, third,forth,fifth,sixth,seventh);

        AnimalAction action1 =new AnimalAction();
        table.getItems().addAll(action1.get(aName));

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
        stage.setScene(scene);
        stage.setTitle("管理系统");
        stage.setHeight(600);
        stage.setWidth(1500);
        stage.show();

        //增加按钮的实现
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //TODO 建议修改一下命名方式哦
                AnimalAction action2=new AnimalAction();
                Animal animal=new Animal();
                animal.setAnimalName(addAnimalName.getText());
                animal.setAnimalType(addAnimalType.getText());
                animal.setAnimalSex(addAnimalSex.getText());
                animal.setAnimalAge(addAnimalAge.getText());
                animal.setAnimalIntroduction(addAnimalIntroduction.getText());
                animal.setAnimalPresentSituation(addAnimalPresentSituation.getText());
                animal.setAnimalKeeper(addAnimalKeeper.getText());

                try {
                    action2.addAnimal(animal);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                addAnimalName.clear();
                addAnimalAge.clear();
                addAnimalType.clear();
                addAnimalKeeper.clear();
                addAnimalPresentSituation.clear();
                addAnimalIntroduction.clear();
                addAnimalSex.clear();
            }
        });
        //更新按钮实现
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AnimalWay way=new AnimalWay();
                Animal animal=new Animal();
                animal.setAnimalType(addAnimalType.getText());
                animal.setAnimalSex(addAnimalSex.getText());
                animal.setAnimalAge(addAnimalAge.getText());
                animal.setAnimalIntroduction(addAnimalIntroduction.getText());
                animal.setAnimalPresentSituation(addAnimalPresentSituation.getText());
                animal.setAnimalKeeper(addAnimalKeeper.getText());
                animal.setAnimalName(addAnimalName.getText());
                try {
                    way.updateAnimal(animal);
                    table.refresh();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                addAnimalName.clear();
                addAnimalAge.clear();
                addAnimalType.clear();
                addAnimalKeeper.clear();
                addAnimalPresentSituation.clear();
                addAnimalIntroduction.clear();
                addAnimalSex.clear();
            }
        });
        //删除按钮的实现
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AnimalAction action2=new AnimalAction();
                String name=addAnimalName.getText();
                try {
                    action2.delete(name);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                addAnimalName.clear();
            }
        });
    }
}
