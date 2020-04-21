package com.zoo.view;
/*
@author 黄浩
登录界面，
 */

import com.zoo.model.UserDao;
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
    private Integer DEFAULT_HEIGHT=300,DEFAULT_WIDTH=500;
    private Integer DEFAULT_FONT=14;
    private Integer DEFAULT_HGAP=2,DEFAULT_VGAP=10;
    private double DEFAULT_Seconds=0.1,DEFAULT_FromValue=0,DEFAULT_ToValue=1;



    public static void main(String[] args) {
        launch(args);
    }
    //Todo 代码全部写在一个方法中会比较臃肿，建议将其中的代码分离出来写在其他方法中
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

        //TODO 对于多次调用的接口，如下方的EventHandler，
        // 可以考虑有没有更好的方式去简化代码，而不是使用很多个匿名内部类，避免代码过于臃肿
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
                UserDao way=new UserDao();

                //闪动的画面
                FadeTransition fade =new FadeTransition();
                fade.setDuration(Duration.seconds(DEFAULT_Seconds));
                fade.setNode(gr);
                fade.setFromValue(DEFAULT_FromValue);
                fade.setToValue(DEFAULT_ToValue);

                if(way.selectName(name)) {                              //与数据库的信息进行判断
                    if (way.selectPassword(name,password)) {
                        if (way.selectIdentity(name,identity)) {
                            System.out.println("登录成功");
                            primaryStage.close();
                             if (identity.equals("Chief")) {       //判断是否为Boss
                                 try {
                                     BossPage bossPage =new BossPage();//打开Boss界面
                                 } catch (Exception e) {
                                     e.printStackTrace();
                                 }
                             }else if (identity.equals("Tourist")) {        //判断是否为游客
                                try {
                                    ShowroomPage showroomPage =new ShowroomPage();//打开游客界面
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }else {                 //管理员
                                try {
                                    AttributePage attributePage =new AttributePage(name);//打开管理员界面
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
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
                Register register1=new Register();
        });
    }
}
