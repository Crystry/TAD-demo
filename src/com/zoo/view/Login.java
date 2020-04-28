package com.zoo.view;
/**
登录界面，
@author 黄浩
 */

import com.zoo.controller.UserController;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Login extends Application {
    private int DEFAULT_HEIGHT=300;
    private int DEFAULT_WIDTH=500;
    private int DEFAULT_FONT=14;
    private int DEFAULT_HGAP=2;
    private int DEFAULT_VGAP=10;
    private double DEFAULT_Seconds=0.1,DEFAULT_FromValue=0,DEFAULT_ToValue=1;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        GridPane gr =new GridPane();
         gr.setStyle("-fx-background-color: #FFF5EE");

        Scene scene=new Scene(gr);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.setHeight(DEFAULT_HEIGHT);
        primaryStage.setWidth(DEFAULT_WIDTH);
        primaryStage.setResizable(false);
        primaryStage.show();

        Label labelName=new Label("用户名：");
        labelName.setFont(Font.font(DEFAULT_FONT));
        Label labelPassword=new Label("密码：");
        labelPassword.setFont(Font.font(DEFAULT_FONT));
        Label labelAttribute=new Label("身份：");
        labelPassword.setFont(Font.font(DEFAULT_FONT));

        TextField textFieldName =new TextField();
        textFieldName.setPromptText("请输入用户名：");
        PasswordField passwordFieldName =new PasswordField();
        passwordFieldName.setPromptText("请输入密码");
        ChoiceBox choiceBox=new ChoiceBox();
        choiceBox.setItems(FXCollections.observableArrayList(
                "Chief","Tourist","PandaAdministrator","BearAdministrator",
                "TigerAdministrator","RabbitAdministrator","WolfAdministrator"
        ));
        choiceBox.setTooltip(new Tooltip("请选择身份"));

        Button login =new Button("登录");
        Button clear = new Button("清除");
        Button register=new Button("注册");

        gr.add(labelName,0,0);
        gr.add(textFieldName,1,0);
        gr.add(labelPassword,0,1);
        gr.add(passwordFieldName,1,1);
        gr.add(labelAttribute,0,2);
        gr.add(choiceBox,1,2);

        gr.add(login,1,3);
        gr.add(clear,0,3);
        gr.add(register, 0,4);

        gr.setAlignment(Pos.CENTER);

        gr.setHgap(DEFAULT_HGAP);
        gr.setVgap(DEFAULT_VGAP);

        GridPane.setMargin(login,new Insets(0,0,0,120));

        //设置清除按键效果
        clear.setOnAction(actionEvent->{
                textFieldName.setText("");
                passwordFieldName.setText("");
        });

        //登录按键效果
        login.setOnAction(actionEvent->{
                String name=textFieldName.getText();                   //获取文本上的内容
                String password=passwordFieldName.getText();
                String identity= (String) choiceBox.getValue();
                UserController userController =new UserController();

                //闪动的画面
                FadeTransition fade =new FadeTransition();
                fade.setDuration(Duration.seconds(DEFAULT_Seconds));
                fade.setNode(gr);
                fade.setFromValue(DEFAULT_FromValue);
                fade.setToValue(DEFAULT_ToValue);

                if(userController.selectName(name)) {                              //与数据库的信息进行判断
                    if (userController.selectPassword(name,password)) {
                        if (userController.selectIdentity(name,identity)) {
                            System.out.println("登录成功");
                            primaryStage.close();
                            switch (identity){
                                case "Chief" :BossPage bossPage =new BossPage();break;
                                case "Tourist" : ShowroomPage showroomPage =new ShowroomPage();break;
                                default:AttributePage attributePage =new AttributePage(name);
                            }
                        }
                        else {
                            primaryStage.setTitle("身份选择错误，请重新选择！");
                            fade.play();
                        }
                    }
                    else {
                        primaryStage.setTitle("密码错误");
                        System.out.println("登录失败");
                        passwordFieldName.setText("");
                        fade.play();
                    }
                }else {
                    primaryStage.setTitle("这个Id不存在，请注册！");
                    textFieldName.setText("");
                    passwordFieldName.setText("");
                    fade.play();
            }
        });
        //注册按钮
        register.setOnAction(actionEvent->{
                Register _register=new Register();
        });
    }
}
