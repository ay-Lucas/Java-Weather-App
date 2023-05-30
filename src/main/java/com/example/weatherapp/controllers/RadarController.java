package com.example.weatherapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

public class RadarController {
    public TextFlow dateTextFlow;
    public TextFlow tempsTextFlow;
    @FXML
    private Label logoLabel;
    @FXML
    private Button homeButton;
    @FXML
    private ToolBar toolBar;
    @FXML
    private Button hourlyButton;
    @FXML
    private Button fourteenDayButton;
    @FXML
    private Button radarButton;
    @FXML
    private Label currentWeatherLabel;
    @FXML
    private Text currentWeatherInt;
    @FXML
    private Text currentHighAndLow;
    @FXML
    private TextField searchField;
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
}
