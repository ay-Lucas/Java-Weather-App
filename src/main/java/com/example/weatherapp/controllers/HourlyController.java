package com.example.weatherapp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

public class HourlyController {
    public Label dailyWeatherLabel;
    public MenuBar menu;
    @FXML private TableView hourlyTableView;
    public Text title;
    public TextField searchField;
    public TextFlow tempsTextFlow;
    public TextFlow dateTextFlow;
    public Button homeButton;
    public Button hourlyButton;
    public ToolBar toolBar;
    public Text currentHighAndLow;
    public Text currentWeatherInt;
    public Label currentWeatherLabel;
    public Button fourteenDayButton;
    public Label logoLabel;
    public Button radarButton;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private ListView<String> listView;
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
    public void displayTextFlow(){



    }
}
