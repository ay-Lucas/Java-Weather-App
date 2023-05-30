package com.example.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Scene HomeScene, HourlyScene, FourteenDayScene, RadarScene;




    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("TodayScene.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("MainSceneCSS.css").toExternalForm());
        String css = this.getClass().getResource("MainSceneCSS.css").toExternalForm();
        scene.getStylesheets().add(css);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }




}