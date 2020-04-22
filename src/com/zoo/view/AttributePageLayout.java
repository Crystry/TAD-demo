package com.zoo.view;

import com.zoo.bean.Animal;
import com.zoo.bean.Showroom;
import com.zoo.model.AnimalDao;
import com.zoo.model.ShowroomDao;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AttributePageLayout {
    private Integer DEFAULT_WIDTH=150;
    private Integer DEFAULT_HEIGHT=50;
    //管理员页面的顶部，显示查询自己展厅信息的表格还有信息
    public Node setPageTop(String ShowroomKeeper){
        ShowroomDao dao=new ShowroomDao();
        TableView<Showroom> table1 = new TableView<>();

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
        return vBox;
    }

    //管理员页面的中部，显示自己管理的动物
    public Node setPageCenter(String ShowroomKeeper) {
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
        table.getColumns().addAll(first, second, third, forth, fifth, sixth, seventh);

        AnimalDao dao1 = new AnimalDao();
        table.getItems().addAll(dao1.get(ShowroomKeeper));

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
            //TODO 建议修改一下命名方式哦
            Animal animal = new Animal();
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
        updateButton.setOnAction(actionEvent -> {
            Animal animal = new Animal();
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
        deleteButton.setOnAction(actionEvent -> {
            String name = addAnimalName.getText();
            dao1.deleteAnimal(name);
            table.getItems().clear();
            table.getItems().addAll(dao1.get(ShowroomKeeper));
            addAnimalName.clear();
        });
        return vBox;
    }
}
