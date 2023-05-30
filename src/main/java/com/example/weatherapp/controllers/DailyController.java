package com.example.weatherapp.controllers;

import com.example.weatherapp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class DailyController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label title;
    @FXML
    private Menu todayButton;
    @FXML
    private Menu tomorrowButton;
    @FXML
    private Menu fiveDaysButton;
    @FXML
    private Menu radarButton;
    @FXML
    private TextField searchField;
    @FXML
    private MenuBar menu;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void SwitchToHome(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("TodayScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void SwitchToHourly(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HourlyScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void SwitchToFourteenDay(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DailyScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void SwitchToRadar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RadarScene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void getWeather(){
        Main main = new Main();
    }


}


