package com.example.weatherapp.controllers;

import com.example.weatherapp.LocationAndWeatherApi;
import com.example.weatherapp.LocationApiData;
import com.example.weatherapp.Units;
import com.example.weatherapp.WeatherApiData;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TodayController {
    @FXML private GridPane gridPane;
    @FXML private MenuItem metric;
    @FXML private MenuItem imperial;
    @FXML private MenuButton unitMenu;
    @FXML private Label logoLabel;
    @FXML private TilePane tilePane;
    @FXML private ToolBar toolBar;
    @FXML private Button todayButton;
    @FXML private Button hourlyButton;
    @FXML private Button dailyButton;
    @FXML private Button radarButton;
    @FXML private TextField searchField;
    @FXML private RadioMenuItem hourlyWindGusts;
    @FXML private RadioMenuItem hourlyWindSpeed;

    @FXML private AnchorPane todayPane;
    @FXML private Text errorText;
    @FXML private TableView<StringProperty> hourlyTable;
    @FXML private AnchorPane hourlyPane;
    @FXML private AnchorPane dailyPane;
    @FXML private AnchorPane radarPane;
    private static Units units = new Units();
    private static ArrayList<String>weekDay;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private static int indexCut;
    private static LinkedHashMap<String, Integer> columnLogger = new LinkedHashMap<>();
    @FXML public void SwitchToToday(ActionEvent event) throws IOException {
       todayPane.setVisible(true);
       hourlyPane.setVisible(false);
       radarPane.setVisible(false);
    }
    @FXML public void SwitchToHourly(ActionEvent event) throws IOException {
        hourlyPane.setVisible(true);
        todayPane.setVisible(false);
        radarPane.setVisible(false);
    }
    @FXML public void SwitchToDaily(ActionEvent event) throws IOException {
        //Change Table WeatherApiData
    }
    @FXML public void SwitchToRadar(ActionEvent event) throws IOException {
        radarPane.setVisible(true);
        hourlyPane.setVisible(false);
        dailyPane.setVisible(false);
    }
    @FXML public void changeUnitsToImperial(ActionEvent event){
        units.setImperial();
    }
    @FXML public void changeUnitsToMetric(ActionEvent event){
       units.setMetric();
    }
    @FXML public void addHourlyWindGusts(ActionEvent event){
        Label windGusts = new Label("Wind Gusts");
        if(!hourlyWindGusts.isSelected()) {
            removeColumn(windGusts);
            hourlyWindGusts.setSelected(false);
        }
        else{
                setColumn(getWeather().getHourly().getWindgusts_10m(), windGusts);
            }
    }
    @FXML public void addHourlyWindSpeed(ActionEvent event){
        Label windSpeed = new Label("Wind Speed");
        if(!hourlyWindSpeed.isSelected()) {
            removeColumn(windSpeed);
            hourlyWindSpeed.setSelected(false);
        }
        else{
            setColumn(getWeather().getHourly().getWindspeed_10m(), windSpeed);
        }
    }
    public void removeColumn(Label label){
        if(gridPane.getChildren().size()>916){
//            for(String i : columnLogger.keySet()){
//                columnLogger.put(i, columnLogger.get(i)-168-(indexCut-1) );
//            }
        }
        gridPane.getChildren().remove(columnLogger.get(label.getText()), columnLogger.get(label.getText())+(168-(indexCut-1)));
        columnLogger.remove(label.getText());
        if(!columnLogger.isEmpty()){

        }
        centerNodes();
    }
    public void centerNodes(){
        for (Node s: gridPane.getChildren()){
            GridPane.setHalignment(s, HPos.CENTER);
        }
    }
    @FXML public void addHourlyCloudCover(){

    }
    @FXML public void setCurrentWeatherInt() {
    }
    @FXML public void setCurrentHighAndLow() {
    }
    /*
     * Validates user input from the TextField searchField.
     *
     */
    @FXML
    public void initialize(){
        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        ColumnConstraints column3 = new ColumnConstraints();
        ColumnConstraints column4 = new ColumnConstraints();
       column1.setFillWidth(true);
       column2.setFillWidth(true);
       column3.setFillWidth(true);
       column4.setFillWidth(true);
        gridPane.getColumnConstraints().addAll(column1, column2 ,column3, column4);
    }
    @FXML public void setWeather(ActionEvent event){
        setHourlyTable(getWeather());
    }
    @FXML public WeatherApiData getWeather(){
        //need to validate more
        if (searchField.getText() == null)
            return null;
        LocationAndWeatherApi api = new LocationAndWeatherApi();
        LocationApiData locationApiData = api.setUserLocation(searchField.getText());
        return api.callWeatherAPI(locationApiData, units);
    }
    public void setColumn(List<Double> type, Label label){
        final int startingIndex = gridPane.getChildren().size();
        ColumnConstraints column = new ColumnConstraints();
        int columnCount = gridPane.getColumnCount();
        column.setFillWidth(true);

        if(!columnLogger.isEmpty()){

        }
            columnLogger.put(label.getText(), startingIndex);
        gridPane.add(label, columnCount, 0);

        for(int i = 0; i<type.size()-indexCut; i++){
          // GridPane.setFillWidth(gridPane.getChildren().get(i), true);
           gridPane.add(new Label(String.valueOf(type.get(i+indexCut))), columnCount, i+1);

           //Column 5 Children start at Index 739
           // GridPane.setFillWidth(gridPane.getChildren().get(i), true);
        }
       setGridFont();
    }
    public void setHourlyTable(WeatherApiData weather){
        trimListToCurrentTime(weather);
        gridPane.getChildren().clear();
       // gridPane.setPadding(new Insets(10, 10, 10, 10));
        //gridPane.setVgap(10);
       // gridPane.setHgap(10);
        Label label1 = new Label();
        label1.setText("Time"+"("+weather.getHourly_units().getTime()+")");

        gridPane.add(label1, 1, 0);
      //  GridPane.setMargin(label1, new Insets(10, 10, 10, 10));
        gridPane.add(new Label("Temperature"+"("+weather.getHourly_units().getTemperature_2m()+")"), 2, 0);
        gridPane.add(new Label("Feels Like"+"("+weather.getHourly_units().getApparent_temperature()+")"), 3, 0);
        gridPane.add(new Label("Precipitation"+"("+weather.getHourly_units().getRain()+")"), 4, 0);

        for(int i = 0; i<weather.getHourly().getTime().size(); i++) {
           // GridPane.setFillWidth(gridPane.getChildren().get(i), true);
            gridPane.add(new Label(weekDay.get(i)), 0, i+1);
            gridPane.add(new Label(weather.getHourly().getTime().get(i)), 1, i+1);
            gridPane.add(new Label(weather.getHourly().getTemperature_2m().get(i + indexCut) +"°"), 2, i+1 );
            gridPane.add(new Label(weather.getHourly().getApparent_temperature().get(i + indexCut) + "°"), 3, i+1);
            gridPane.add(new Label(String.valueOf(weather.getHourly().getPrecipitation().get(i+indexCut))), 4, i+1);
        }
        //setGridFont();
        centerNodes();
    }
    public void setGridFont(){
        ObservableList<Node>textList = gridPane.getChildren();
  //      for (Node node : textList) {
          //  Label.class.cast(node).setFont(Font.font("verdana", 17));
     //   }
    }

    public static WeatherApiData trimListToCurrentTime(WeatherApiData weather){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm a");
        DateTimeFormatter weekDayAndMonth = DateTimeFormatter.ofPattern("E, M/d");
        DateTimeFormatter dateTimeMonth = DateTimeFormatter.ofPattern("E, M/d, hh:mm a");
        //Cuts out hours that have passed by to the present
        for(int i = 0; i<weather.getHourly().getTime().size();i++){
            if(weather.getCurrent_weather().getTime().equals(weather.getHourly().getTime().get(i))){
                weather.getHourly().getTime().subList(0, i-1).clear();
                indexCut = i-1;
                i=weather.getHourly().getTime().size();
            }
        }

        //Sets time to "hh:mm a"
        for(ListIterator<String> e = weather.getHourly().getTime().listIterator(); e.hasNext();){
            LocalDateTime localDateTime = LocalDateTime.parse(e.next(), formatter);
            String date = localDateTime.format(dateTimeMonth);
            e.set(date);
        }

        weekDay = new ArrayList<>(weather.getHourly().getTime().size());
        for(int i = 0; i<weather.getHourly().getTime().size();i++) {
            String[] temp = weather.getHourly().getTime().get(i).split(", ", 3);
            if (temp[2].equals("12:00 AM")) {
                //String date = weather.getHourly().getTime().get(i+)
                weekDay.add(i, temp[0] + " " + temp[1]);
            }
            else if(i==0){
                weekDay.add(i, temp[0] + " " + temp[1]);
            }
            else
                weekDay.add(i, "");
            weather.getHourly().getTime().set(i, temp[2]);
        }

        for(ListIterator<String> i = weather.getHourly().getTime().listIterator();i.hasNext();){
            System.out.println(i.next());
        }
        return weather;
    }
        /*
        for(int i = 0; i<weather.getHourly().getTime().size();i++) {
            String[] temp = weather.getHourly().getTime().get(i).split(", ", 3);
            if (temp[2].equals("12:00 AM")) {
                //String date = weather.getHourly().getTime().get(i+)
                weather.getHourly().getTime().add(i, temp[0] + " " + temp[1]);
                weather.getHourly().getTime().set(i+1, temp[2]);
                i++;
            }
            else if(i==0){
                weather.getHourly().getTime().add(i,temp[0] + " " + temp[1]);
            }
            else{
                weather.getHourly().getTime().set(i, temp[2]);
            }
        }

         */
        /*
            //needs to be array list!!
        for(ListIterator<String> e = weather.getHourly().getTime().listIterator(); e.hasNext();){
            String[] temp = e.next().split(", ");
            if(temp[2].equals("11:00 PM")) {
                e.add(temp[0]+temp[1]);


            }
            else{
                e.set(temp[2]);
            }
        }

         */

        /*
        for (ListIterator<String> i = weather.getHourly().getTime().listIterator(); i.hasNext();){
            if (i.nextIndex() % 24 == 0) {
                //LocalDateTime localDateTime = LocalDateTime.parse(i.next(), time);
                LocalDateTime.parse(i.next(), )
                String element =
                i.set(element);
            }
            System.out.println(i.next());
        }

         */


 /*
        for(int i = 0; i<weather.getHourly().getTime().size(); i++){
            LocalDateTime newLocalDateTime = LocalDateTime.parse(i.next(), formatter);
            if (weather.getHourly().getTime().indexOf()% 24 == 0) {
                String twentyFourth = newLocalDateTime.format(dateWithTIme);
                i.set(twentyFourth);
            }
            else{
                String element = newLocalDateTime.format(time);
                i.set(element);
            }
            System.out.println(i.next());
        }
        */


/*
    @FXML public void setHourlyTable(WeatherApiData weather) {

        int listSize = weather.getHourly().getTime().size();

        //List<List<String>>values = new ArrayList<List<String>>();

        ObservableList<StringProperty> data = FXCollections.observableArrayList(
                weather.
        //timeCol.setCellValueFactory(data -> data.getValue().getDaily().getTime());

        int count = 0;
        StringProperty row;
        //for(int i = 0; i <listSize; i++){
          //  int finalI = i;
            timeCol.setCellValueFactory(value -> new SimpleStringProperty());
        //}
        for(int r = 0; r <listSize; r++){
            //timeCol.setCellValueFactory(date -> new SimpleStringProperty(weather.getHourly().getTime().get(finalR)));
            //row.add(new SimpleStringProperty(weather.getHourly().getTime().get(r)));
            row= (new SimpleStringProperty(weather.getHourly().getTime().get(r)));
            data.add(row);
            //data.addStringProperty
        }
        //hourlyTable.setItems(getWeatherData(weather));
        hourlyTable.setItems(data);
        hourlyTable.isVisible();
    }

//Create a class with matching constructors that match the columns
    public ObservableList<String> getWeatherData(WeatherApiData weather){
       ObservableList<String> data = FXCollections.observableArrayList();
       return data;
     */


    }













