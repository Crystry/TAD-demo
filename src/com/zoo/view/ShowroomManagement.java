package com.zoo.view;
/*
游客界面
 */

import com.zoo.controller.AnimalAction;
import com.zoo.controller.ShowroomAction;
import com.zoo.model.Animal;
import com.zoo.model.Showroom;
import com.zoo.util.AnimalWay;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ShowroomManagement {
    private final Stage stage = new Stage();

    public ShowroomManagement() throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
        //顶部，游客选择想要查询的展厅
        ChoiceBox choiceBox=new ChoiceBox();
        choiceBox.setItems(FXCollections.observableArrayList(
                "Panda","Bear","Tiger","Rabbit","Wolf"));
        choiceBox.setTooltip(new Tooltip("请选择展厅！"));
        Button Search=new Button("查询");
        HBox hBox=new HBox();
        hBox.getChildren().addAll(choiceBox,Search);
        root.setTop(hBox);

        //中部，展现游客想要查看的动物的信息
        TableView<Showroom> table = new TableView<>();

        TableColumn<Showroom, String> first = new TableColumn<>("ShowroomName");
        first.setCellValueFactory(new PropertyValueFactory<>("ShowroomName"));

        TableColumn<Showroom, String> second = new TableColumn<>("ShowroomIntroduction");
        second.setCellValueFactory(new PropertyValueFactory<>("ShowroomIntroduction"));

        TableColumn<Showroom, String> third = new TableColumn<>("ShowroomLocation");
        third.setCellValueFactory(new PropertyValueFactory<>("ShowroomLocation"));

        TableColumn<Showroom, String> forth = new TableColumn<>("ShowroomLocationSize");
        forth.setCellValueFactory(new PropertyValueFactory<>("ShowroomLocationSize"));

        TableColumn<Showroom, String> fifth = new TableColumn<>("ShowroomKeeper");
        fifth.setCellValueFactory(new PropertyValueFactory<>("ShowroomKeeper"));

        table.getColumns().addAll(first, second, third,forth,fifth);

        ShowroomAction action = new ShowroomAction();
        table.getItems().addAll(action.query());

        root.setCenter(table);

        stage.setScene(scene);
        stage.setTitle("管理系统");
        stage.setHeight(600);
        stage.setWidth(900);
        stage.show();
        //查询按钮的实现
        Search.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String animalType= (String) choiceBox.getValue();
                TableView<Animal> table=new TableView<>();
                TableColumn<Animal, String> first = new TableColumn<>("AnimalName");
                first.setCellValueFactory(new PropertyValueFactory<>("AnimalName"));

                TableColumn<Animal, String> second = new TableColumn<>("AnimalType");
                second.setCellValueFactory(new PropertyValueFactory<>("AnimalType"));

                TableColumn<Animal, String> third = new TableColumn<>("AnimalSex");
                third.setCellValueFactory(new PropertyValueFactory<>("AnimalSex"));

                TableColumn<Animal, String> forth = new TableColumn<>("AnimalAge");
                forth.setCellValueFactory(new PropertyValueFactory<>("AnimalAge"));

                TableColumn<Animal, String> fifth = new TableColumn<>("AnimalIntroduction");
                fifth.setCellValueFactory(new PropertyValueFactory<>("AnimalIntroduction"));

                TableColumn<Animal, String> sixth = new TableColumn<>("AnimalPresentSituation");
                sixth.setCellValueFactory(new PropertyValueFactory<>("AnimalPresentSituation"));

                TableColumn<Animal, String> seventh = new TableColumn<>("AnimalKeeper");
                seventh.setCellValueFactory(new PropertyValueFactory<>("AnimalKeeper"));

                table.getColumns().addAll(first, second, third,forth,fifth,sixth,seventh);

                AnimalWay way = new AnimalWay();
                try {
                    table.getItems().addAll(way.query(animalType));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(animalType);

                root.setCenter(table);
                stage.show();


            }
        });
    }
}
