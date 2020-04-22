package com.zoo.view;
/*
@author 黄浩
龙妈页面的布局，将上部与中部分开两个方法，
 */
import com.zoo.bean.Showroom;
import com.zoo.bean.User;
import com.zoo.model.ShowroomDao;
import com.zoo.model.UserDao;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BossPageLayout {
    private Integer DEFAULT_HEIGHT=250;
    //龙妈界面的顶部，显示展厅的信息，对展厅进行增删改查
    public Node setPageTop(){
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
        Showroom showroom = new Showroom();
        table1.getItems().addAll(dao.query());
        VBox vBox = new VBox(hBox, table1);
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
        return vBox;
    }

    //龙妈界面的中部，显示管理员的信息，对管理员进行增删改查
    public Node setPageCenter(){
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
        User user=new User();
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
        return vBox1;
    }
}
