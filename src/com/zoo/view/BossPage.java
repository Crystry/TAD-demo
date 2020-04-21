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
    private Integer DEFAULT_StageHeight=600;
    private Integer DEFAULT_StageWidth=1500;
    private Integer DEFAULT_HEIGHT=250;
    public BossPage()  {
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

        HBox hBox = new HBox(addShowroomName, addShowroomIntroduction,
                addShowroomLocation, addShowroomLocationSize, addShowroomKeeper,
                addButton, updateButton, deleteButton);

        TableView<Showroom> table1 = new TableView<>();
        table1.setMaxHeight(DEFAULT_HEIGHT);
        TableColumn<Showroom, String> first1 = new TableColumn<>("ShowroomName");
        first1.setCellValueFactory(param->param.getValue().showroomNameProperty());

        TableColumn<Showroom, String> second1 = new TableColumn<>("ShowroomIntroduction");
        second1.setCellValueFactory(param->param.getValue().showroomIntroductionProperty());

        TableColumn<Showroom, String> third1 = new TableColumn<>("ShowroomLocation");
        third1.setCellValueFactory(param->param.getValue().showroomLocationProperty());

        TableColumn<Showroom, String> forth1 = new TableColumn<>("ShowroomLocationSize");
        forth1.setCellValueFactory(param->param.getValue().showroomLocationSizeProperty());

        TableColumn<Showroom, String> fifth1 = new TableColumn<>("ShowroomKeeper");
        fifth1.setCellValueFactory(param->param.getValue().showroomKeeperProperty());

        table1.getColumns().addAll(first1, second1, third1,forth1,fifth1);

        ShowroomDao dao = new ShowroomDao();
        table1.getItems().addAll(dao.query());
        VBox vBox = new VBox(hBox, table1);
        root.setTop(vBox);

        //中部显示管理员的信息
        TableView<User> table = new TableView<User>();
        table.setEditable(true);

        TableColumn<User, Number> first = new TableColumn<User, Number>("Id");
        first.setCellValueFactory(param->param.getValue().IdProperty());

        TableColumn<User, String> second = new TableColumn<User, String>("Name");
        second.setCellValueFactory(param->param.getValue().NameProperty());

        TableColumn<User, String> third = new TableColumn<User, String>("Password");
        third.setCellValueFactory(param->param.getValue().PasswordProperty());

        TableColumn<User, String> forth = new TableColumn<User, String>("Identity");
        forth.setCellValueFactory(param->param.getValue().IdentityProperty());

        table.getColumns().addAll(first, second, third, forth);
        UserDao dao1 = new UserDao();
        table.getItems().addAll(dao1.query());

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

        Showroom showroom = new Showroom();
        User user=new User();

        Stage mStage = new Stage();
        mStage.setScene(scene);
        mStage.setTitle("管理系统");
        mStage.setHeight(DEFAULT_StageHeight);
        mStage.setWidth(DEFAULT_StageWidth);
        mStage.show();
        //增加展厅按键
        addButton.setOnAction(actionEvent->{
                showroom.setShowroomName(addShowroomName.getText());
                showroom.setShowroomIntroduction(addShowroomIntroduction.getText());
                showroom.setShowroomLocation(addShowroomLocation.getText());
                showroom.setShowroomLocationSize(addShowroomLocationSize.getText());
                showroom.setShowroomKeeper(addShowroomKeeper.getText());
            dao.addShowroom(showroom);
            table1.getItems().clear();
            table1.getItems().addAll(dao.query());
            addShowroomName.clear();
                addShowroomIntroduction.clear();
                addShowroomLocation.clear();
                addShowroomLocationSize.clear();
                addShowroomKeeper.clear();
        });

        //删除展厅
        deleteButton.setOnAction(actionEvent->{
            dao.deleteShowroom(addShowroomName.getText());
            table1.getItems().clear();
            table1.getItems().addAll(dao.query());
            addShowroomName.clear();
        });
        //更新展厅
        updateButton.setOnAction(actionEvent->{
                showroom.setShowroomName(addShowroomName.getText());
                showroom.setShowroomIntroduction(addShowroomIntroduction.getText());
                showroom.setShowroomLocation(addShowroomLocation.getText());
                showroom.setShowroomLocationSize(addShowroomLocationSize.getText());
                showroom.setShowroomKeeper(addShowroomKeeper.getText());
            dao.updateShowroom(showroom);
            table1.getItems().clear();
            table1.getItems().addAll(dao.query());
            addShowroomName.clear();
                addShowroomIntroduction.clear();
                addShowroomLocation.clear();
                addShowroomLocationSize.clear();
                addShowroomKeeper.clear();
        });

        //增加管理员
        add.setOnAction(actionEvent->{
                String attribute ="Administrator";
                user.setName(Name.getText());
                user.setPassword(Password.getText());
                user.setAttribute(attribute);
                user.setIdentity(Identity.getText());
            dao1.addUser(user);
            table.getItems().clear();
            table.getItems().addAll(dao1.query());
            Name.clear();
                Password.clear();
                Identity.clear();
        });

        //更新管理员
        update.setOnAction(actionEvent->{
                user.setPassword(Password.getText());
                user.setIdentity(Identity.getText());
                user.setAttribute("Administrator");
                user.setName(Name.getText());
            dao1.updateUser(user);
            table.getItems().clear();
            table.getItems().addAll(dao1.query());
            Name.clear();
                Password.clear();
                Identity.clear();
        });

        //删除管理员
        delete.setOnAction(actionEvent->{
            dao1.deleteUser(Name.getText());
            table.getItems().clear();
            table.getItems().addAll(dao1.query());
            Name.clear();
        });
    }
}
