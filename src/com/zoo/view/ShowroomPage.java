package com.zoo.view;
/*
@author 黄浩
游客界面
显示展厅的信息，选择要参观的展厅，进行参观
 */

import com.zoo.bean.Animal;
import com.zoo.bean.Showroom;
import com.zoo.model.AnimalDao;
import com.zoo.model.ShowroomDao;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowroomPage {
    private Integer DEFAULT_StageHeight=600;
    private Integer DEFAULT_StageWidth=1500;
    private Integer DEFAULT_HEIGHT=250;
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
        first.setCellValueFactory(new PropertyValueFactory<>("ShowroomName"));

        TableColumn<Showroom, String> second = new TableColumn<>("ShowroomIntroduction");
        second.setCellValueFactory(new PropertyValueFactory<>("ShowroomIntroduction"));

        TableColumn<Showroom, String> third = new TableColumn<>("ShowroomLocation");
        third.setCellValueFactory(new PropertyValueFactory<>("ShowroomLocation"));

        TableColumn<Showroom, String> forth = new TableColumn<>("ShowroomLocationSize");
        forth.setCellValueFactory(new PropertyValueFactory<>("ShowroomLocationSize"));

        TableColumn<Showroom, String> fifth= new TableColumn<>("ShowroomKeeper");
        fifth.setCellValueFactory(new PropertyValueFactory<>("ShowroomKeeper"));

        table.getColumns().addAll(first, second, third,forth,fifth);

        ShowroomDao dao = new ShowroomDao();
        table.getItems().addAll(dao.query());
        VBox vBox=new VBox(hBox,table);
        //中部，展现游客想要查看的动物的信息
        root.setTop(vBox);
        Stage mStage = new Stage();
        mStage.setScene(scene);
        mStage.setTitle("管理系统");
        mStage.setHeight(DEFAULT_StageHeight);
        mStage.setWidth(DEFAULT_StageWidth);
        mStage.show();
        //查询按钮的实现
        Search.setOnAction(actionEvent->{
                String animalType = (String) choiceBox.getValue();
                TableView<Animal> table1 = new TableView<>();
                TableColumn<Animal, String> first1 = new TableColumn<>("AnimalName");
                first1.setCellValueFactory(new PropertyValueFactory<>("AnimalName"));

                TableColumn<Animal, String> second1 = new TableColumn<>("AnimalType");
                second1.setCellValueFactory(new PropertyValueFactory<>("AnimalType"));

                TableColumn<Animal, String> third1 = new TableColumn<>("AnimalSex");
                third1.setCellValueFactory(new PropertyValueFactory<>("AnimalSex"));

                TableColumn<Animal, String> forth1 = new TableColumn<>("AnimalAge");
                forth1.setCellValueFactory(new PropertyValueFactory<>("AnimalAge"));

                TableColumn<Animal, String> fifth1 = new TableColumn<>("AnimalIntroduction");
                fifth1.setCellValueFactory(new PropertyValueFactory<>("AnimalIntroduction"));

                TableColumn<Animal, String> sixth1 = new TableColumn<>("AnimalPresentSituation");
                sixth1.setCellValueFactory(new PropertyValueFactory<>("AnimalPresentSituation"));

                TableColumn<Animal, String> seventh1 = new TableColumn<>("AnimalKeeper");
                seventh1.setCellValueFactory(new PropertyValueFactory<>("AnimalKeeper"));

                table1.getColumns().addAll(first1, second1, third1, forth1, fifth1, sixth1, seventh1);

                AnimalDao dao1 = new AnimalDao();
                try {
                    table1.getItems().addAll(dao1.query(animalType));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(animalType);
                root.setCenter(table1);
               // mStage.show();
        });
    }
}
