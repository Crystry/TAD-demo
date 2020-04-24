package com.zoo.view;
/*
游客界面
显示展厅的信息，选择要参观的展厅，进行参观
@author 黄浩
 */

import com.zoo.bean.Animal;
import com.zoo.bean.Showroom;
import com.zoo.controller.AnimalController;
import com.zoo.controller.ShowroomController;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ShowroomPage {
    private int DEFAULT_HEIGHT=250;
    public ShowroomPage()  {
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
        TableView<Showroom> table = new TableView<>();
        table.setMaxHeight(DEFAULT_HEIGHT);
        TableColumn<Showroom, String> first = new TableColumn<>("ShowroomName");
        first.setCellValueFactory(param->param.getValue().showroomNameProperty());

        TableColumn<Showroom, String> second = new TableColumn<>("ShowroomIntroduction");
        second.setCellValueFactory(param->param.getValue().showroomIntroductionProperty());

        TableColumn<Showroom, String> third = new TableColumn<>("ShowroomLocation");
        third.setCellValueFactory(param->param.getValue().showroomLocationProperty());

        TableColumn<Showroom, String> forth = new TableColumn<>("ShowroomLocationSize");
        forth.setCellValueFactory(param->param.getValue().showroomLocationSizeProperty());

        TableColumn<Showroom, String> fifth= new TableColumn<>("ShowroomKeeper");
        fifth.setCellValueFactory(param->param.getValue().showroomKeeperProperty());

        table.getColumns().addAll(first, second, third,forth,fifth);

        ShowroomController showroomController = new ShowroomController();
        table.getItems().addAll(showroomController.query());
        VBox vBox=new VBox(hBox,table);
        //中部，展现游客想要查看的动物的信息
        root.setTop(vBox);
        StageInitialization stageInitialization=new StageInitialization(scene);
        //查询按钮的实现
        Search.setOnAction(actionEvent->{
                String animalType = (String) choiceBox.getValue();
                TableView<Animal> table1 = new TableView<>();
                TableColumn<Animal, String> first1 = new TableColumn<>("AnimalName");
                first1.setCellValueFactory(param->param.getValue().animalNameProperty());

                TableColumn<Animal, String> second1 = new TableColumn<>("AnimalType");
                second1.setCellValueFactory(param->param.getValue().animalTypeProperty());

                TableColumn<Animal, String> third1 = new TableColumn<>("AnimalSex");
                third1.setCellValueFactory(param->param.getValue().animalSexProperty());

                TableColumn<Animal, String> forth1 = new TableColumn<>("AnimalAge");
                forth1.setCellValueFactory(param->param.getValue().animalAgeProperty());

                TableColumn<Animal, String> fifth1 = new TableColumn<>("AnimalIntroduction");
                fifth1.setCellValueFactory(param->param.getValue().animalIntroductionProperty());

                TableColumn<Animal, String> sixth1 = new TableColumn<>("AnimalPresentSituation");
                sixth1.setCellValueFactory(param->param.getValue().animalPresentSituationProperty());

                TableColumn<Animal, String> seventh1 = new TableColumn<>("AnimalKeeper");
                seventh1.setCellValueFactory(param->param.getValue().animalKeeperProperty());

                table1.getColumns().addAll(first1, second1, third1, forth1, fifth1, sixth1, seventh1);

                AnimalController animalController = new AnimalController();
                try {
                    table1.getItems().addAll(animalController.query(animalType));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                root.setCenter(table1);
        });
    }
}
