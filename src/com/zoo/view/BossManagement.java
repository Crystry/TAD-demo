package com.zoo.view;
/*
Boss界面
 */

import com.zoo.controller.ShowroomAction;
import com.zoo.controller.UserAction;
import com.zoo.model.Showroom;
import com.zoo.model.User;
import com.zoo.util.ShowroomWay;
import com.zoo.util.UserWay;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.SQLException;

public class BossManagement {
    private final Stage stage = new Stage();

    public BossManagement() throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);

        //界面的顶部，展示展厅的信息，实现增删改查
        final TextField addShowroomName = new TextField();
        addShowroomName.setPromptText("ShowroomName");
        final TextField addShowroomIntroduction = new TextField();
        addShowroomIntroduction.setPromptText("ShowroomIntroduction");
        final TextField addShowroomLocation = new TextField();
        addShowroomLocation.setPromptText("ShowroomLocation");
        final TextField addShowroomLocationSize = new TextField();
        addShowroomLocationSize.setPromptText("ShowroomLocationSize");
        final TextField addShowroomKeeper = new TextField();
        addShowroomKeeper.setPromptText("ShowroomKeeper");

        final Button addButton = new Button("添加");
        final Button updateButton = new Button("更新");
        final Button deleteButton = new Button("删除");

        HBox hBox = new HBox();
        hBox.getChildren().addAll(addShowroomName, addShowroomIntroduction,
                addShowroomLocation, addShowroomLocationSize, addShowroomKeeper,
                addButton, updateButton, deleteButton);
        TableView<Showroom> table1 = new TableView<>();
        table1.setMaxHeight(200);

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

        ShowroomAction action = new ShowroomAction();
        table1.getColumns().addAll(first1, second1, third1, forth1, fifth1);
        table1.getItems().addAll(action.query());
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, table1);
        root.setTop(vBox);

        //中部显示管理员的信息
        TableView<User> table = new TableView<User>();
        table.setEditable(true);

        TableColumn<User, Integer> first = new TableColumn<>("Id");
        first.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<User, String> second = new TableColumn<>("Name");
        second.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<User, String> third = new TableColumn<>("Password");
        third.setCellValueFactory(new PropertyValueFactory<>("Password"));

        TableColumn<User, String> forth = new TableColumn<>("Identity");
        forth.setCellValueFactory(new PropertyValueFactory<>("identity"));

        table.getColumns().addAll(first, second, third, forth);
        UserAction action1 = new UserAction();
        table.getItems().addAll(action1.query());

        final TextField Name = new TextField();
        Name.setPromptText("Name");
        final TextField Password = new TextField();
        Password.setPromptText("Password");
        final TextField Identity = new TextField();
        Identity.setPromptText("Identity");

        final Button add = new Button("添加");
        final Button update = new Button("更新");
        final Button delete = new Button("删除");

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll( Name, Password, Identity, add, update, delete);


        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(table, hBox1);
        root.setCenter(vBox1);
        stage.setScene(scene);
        stage.setTitle("管理系统");
        stage.setHeight(600);
        stage.setWidth(1000);
        stage.show();

        //增加展厅按键
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Showroom showroom = new Showroom();
                ShowroomAction action2 = new ShowroomAction();
                showroom.setShowroomName(addShowroomName.getText());
                showroom.setShowroomIntroduction(addShowroomIntroduction.getText());
                showroom.setShowroomLocation(addShowroomLocation.getText());
                showroom.setShowroomLocationSize(addShowroomLocationSize.getText());
                showroom.setShowroomKeeper(addShowroomKeeper.getText());
                try {
                    action2.addShowroom(showroom);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                addShowroomName.clear();
                addShowroomIntroduction.clear();
                addShowroomLocation.clear();
                addShowroomLocationSize.clear();
                addShowroomKeeper.clear();
            }
        });

        //删除展厅
        deleteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ShowroomAction action2 = new ShowroomAction();
                try {
                    action2.deleteShowroom(addShowroomName.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                addShowroomName.clear();
            }

        });

        //更新展厅
        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ShowroomWay way = new ShowroomWay();
                Showroom showroom = new Showroom();
                showroom.setShowroomName(addShowroomName.getText());
                showroom.setShowroomIntroduction(addShowroomIntroduction.getText());
                showroom.setShowroomLocation(addShowroomLocation.getText());
                showroom.setShowroomLocationSize(addShowroomLocationSize.getText());
                showroom.setShowroomKeeper(addShowroomKeeper.getText());
                try {
                    way.updateShowroom(showroom);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                addShowroomName.clear();
                addShowroomIntroduction.clear();
                addShowroomLocation.clear();
                addShowroomLocationSize.clear();
                addShowroomKeeper.clear();
            }
        });

        //增加管理员
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                User user=new User();
                String attribute ="Administrator";
                user.setName(Name.getText());
                user.setPassword(Password.getText());
                user.setAttribute(attribute);
                user.setIdentity(Identity.getText());
                UserAction action2=new UserAction();
                try {
                    action2.add(user);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Name.clear();
                Password.clear();
                Identity.clear();
            }
        });

        //更新管理员
        update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                User user=new User();
                user.setPassword(Password.getText());
                user.setIdentity(Identity.getText());
                user.setAttribute("Administrator");
                user.setName(Name.getText());
                UserAction action2=new UserAction();
                try {
                    action2.update(user);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Name.clear();
                Password.clear();
                Identity.clear();
            }
        });

        //删除管理员
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                User user=new User();
                UserWay way=new UserWay();
                try {
                    way.deleteUser(Name.getText());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                Name.clear();
            }
        });
    }
}
