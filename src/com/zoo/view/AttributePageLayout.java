package com.zoo.view;
/*
管理员页面的布局，将上部与中部分开两个方法，
@author 黄浩
 */

import com.zoo.bean.Animal;
import com.zoo.bean.Showroom;
import com.zoo.controller.AnimalController;
import com.zoo.controller.ShowroomController;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AttributePageLayout {
    private int DEFAULT_WIDTH=150;
    private int DEFAULT_HEIGHT=50;
    //管理员页面的顶部，显示查询自己展厅信息的表格还有信息
    public Node setPageTop(String ShowroomKeeper){
        ShowroomController showroomController=new ShowroomController();
        TableView<Showroom> table = new TableView<Showroom>();

        table.setMaxHeight(DEFAULT_HEIGHT);
        TableColumn<Showroom, String> first = new TableColumn<>("ShowroomName");
        first.setCellValueFactory(param->param.getValue().showroomNameProperty());

        TableColumn<Showroom, String> second = new TableColumn<>("ShowroomIntroduction");
        second.setCellValueFactory(param->param.getValue().showroomIntroductionProperty());

        TableColumn<Showroom, String> third = new TableColumn<>("ShowroomLocation");
        third.setCellValueFactory(param->param.getValue().showroomLocationProperty());

        TableColumn<Showroom, String> forth = new TableColumn<>("ShowroomLocationSize");
        forth.setCellValueFactory(param->param.getValue().showroomLocationSizeProperty());

        TableColumn<Showroom, String> fifth = new TableColumn<>("ShowroomKeeper");
        fifth.setCellValueFactory(param->param.getValue().showroomKeeperProperty());

        table.getColumns().addAll(first, second, third,forth,fifth);
        table.getItems().addAll(showroomController.query(ShowroomKeeper));

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
        update.setOnAction(actionEvent->{
            Showroom showroom=new Showroom();
            showroom.setShowroomIntroduction(showroomIntroduction.getText());
            showroom.setShowroomLocation(showroomLocation.getText());
            showroom.setShowroomLocationSize(showroomLocationSize.getText());
            showroom.setShowroomKeeper(showroomKeeper.getText());
            showroom.setShowroomName(showroomName.getText());

            showroomController.updateShowroom(showroom);
            table.getItems().clear();
            table.getItems().addAll(showroomController.query(ShowroomKeeper));

            showroomName.clear();
            showroomIntroduction.clear();
            showroomLocation.clear();
            showroomLocationSize.clear();
            showroomKeeper.clear();
        });
        HBox hBox=new HBox(showroomName,showroomIntroduction,showroomLocation,
                showroomLocationSize,showroomKeeper,update);
        VBox vBox=new VBox(hBox,table);
        return vBox;

    }

    //管理员页面的中部，显示自己管理的动物
    public Node setPageCenter(String ShowroomKeeper) {
        TableView<Animal> table = new TableView<>();

        TableColumn<Animal, String> first = new TableColumn<>("AnimalName");
        first.setMinWidth(DEFAULT_WIDTH);
        first.setCellValueFactory(param->param.getValue().animalNameProperty());

        TableColumn<Animal, String> second = new TableColumn<>("AnimalType");
        second.setMinWidth(DEFAULT_WIDTH);
        second.setCellValueFactory(param->param.getValue().animalTypeProperty());

        TableColumn<Animal, String> third = new TableColumn<>("AnimalSex");
        third.setMinWidth(DEFAULT_WIDTH);
        third.setCellValueFactory(param->param.getValue().animalSexProperty());


        TableColumn<Animal, String> forth = new TableColumn<>("AnimalAge");
        forth.setMinWidth(DEFAULT_WIDTH);
        forth.setCellValueFactory(param->param.getValue().animalAgeProperty());


        TableColumn<Animal, String> fifth = new TableColumn<>("AnimalIntroduction");
        fifth.setMinWidth(DEFAULT_WIDTH);
        fifth.setCellValueFactory(param->param.getValue().animalIntroductionProperty());


        TableColumn<Animal, String> sixth = new TableColumn<>("AnimalPresentSituation");
        sixth.setMinWidth(DEFAULT_WIDTH);
        sixth.setCellValueFactory(param->param.getValue().animalPresentSituationProperty());


        TableColumn<Animal, String> seventh = new TableColumn<>("AnimalKeeper");
        seventh.setMinWidth(DEFAULT_WIDTH);
        seventh.setCellValueFactory(param->param.getValue().animalKeeperProperty());
        table.getColumns().addAll(first, second, third, forth, fifth, sixth, seventh);

        AnimalController animalController = new AnimalController();
        table.getItems().addAll(animalController.get(ShowroomKeeper));

        final TextField addAnimalName = new TextField();
        addAnimalName.setPromptText("AnimalName");
        final TextField addAnimalType = new TextField();
        addAnimalType.setPromptText("AnimalType");
        final TextField addAnimalSex = new TextField();
        addAnimalSex.setPromptText("AnimalSex");
        final TextField addAnimalAge = new TextField();
        addAnimalAge.setPromptText("AnimalAge");
        final TextField addAnimalIntroduction = new TextField();
        addAnimalIntroduction.setPromptText("AnimalIntroduction");
        final TextField addAnimalPresentSituation = new TextField();
        addAnimalPresentSituation.setPromptText("AnimalPresentSituation");
        final TextField addAnimalKeeper = new TextField();
        addAnimalKeeper.setPromptText("AnimalKeeper");

        final Button addButton = new Button("添加");
        final Button updateButton = new Button("更新");
        final Button deleteButton = new Button("删除");

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(addAnimalName, addAnimalType, addAnimalSex,
                addAnimalAge, addAnimalIntroduction, addAnimalPresentSituation,
                addAnimalKeeper, addButton, updateButton, deleteButton);
        VBox vBox = new VBox(table, hBox1);
        addButton.setOnAction(actionEvent -> {
            Animal animal = new Animal();
            animal.setAnimalName(addAnimalName.getText());
            animal.setAnimalType(addAnimalType.getText());
            animal.setAnimalSex(addAnimalSex.getText());
            animal.setAnimalAge(addAnimalAge.getText());
            animal.setAnimalIntroduction(addAnimalIntroduction.getText());
            animal.setAnimalPresentSituation(addAnimalPresentSituation.getText());
            animal.setAnimalKeeper(addAnimalKeeper.getText());

            animalController.addAnimal(animal);
            table.getItems().clear();
            table.getItems().addAll(animalController.get(ShowroomKeeper));

            addAnimalName.clear();
            addAnimalAge.clear();
            addAnimalType.clear();
            addAnimalKeeper.clear();
            addAnimalPresentSituation.clear();
            addAnimalIntroduction.clear();
            addAnimalSex.clear();
        });
        //更新按钮实现
        updateButton.setOnAction(actionEvent -> {
            Animal animal = new Animal();
            animal.setAnimalType(addAnimalType.getText());
            animal.setAnimalSex(addAnimalSex.getText());
            animal.setAnimalAge(addAnimalAge.getText());
            animal.setAnimalIntroduction(addAnimalIntroduction.getText());
            animal.setAnimalPresentSituation(addAnimalPresentSituation.getText());
            animal.setAnimalKeeper(addAnimalKeeper.getText());
            animal.setAnimalName(addAnimalName.getText());

            animalController.updateAnimal(animal);
            table.getItems().clear();
            table.getItems().addAll(animalController.get(ShowroomKeeper));

            addAnimalName.clear();
            addAnimalAge.clear();
            addAnimalType.clear();
            addAnimalKeeper.clear();
            addAnimalPresentSituation.clear();
            addAnimalIntroduction.clear();
            addAnimalSex.clear();
        });
        //删除按钮的实现
        deleteButton.setOnAction(actionEvent -> {
            String name = addAnimalName.getText();
            animalController.deleteAnimal(name);
            table.getItems().clear();
            table.getItems().addAll(animalController.get(ShowroomKeeper));
            addAnimalName.clear();
        });
        return vBox;
    }
}
