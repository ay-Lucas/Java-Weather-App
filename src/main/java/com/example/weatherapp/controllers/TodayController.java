package com.example.weatherapp.controllers;
import com.example.weatherapp.LocationAndWeatherApi;
import com.example.weatherapp.LocationApiData;
import com.example.weatherapp.Units;
import com.example.weatherapp.WeatherApiData;
import javafx.beans.property.StringProperty;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
public class TodayController {
    @FXML private GridPane gridPane;
    //@FXML private ListView<Object> listView;
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
    @FXML private RadioMenuItem hourlyTemperature;
    @FXML private RadioMenuItem hourlyApparentTemperature;
    @FXML private RadioMenuItem hourlyPrecipitation;
    @FXML private RadioMenuItem hourlyPrecipitationProbability;
    @FXML private RadioMenuItem hourlyShowers;
    @FXML private RadioMenuItem hourlyRain;
    @FXML private RadioMenuItem hourlySnowfall;
    @FXML private RadioMenuItem hourlyDewpoint;
    @FXML private RadioMenuItem hourlyWindGusts;
    @FXML private RadioMenuItem hourlyWindSpeed;
    @FXML private RadioMenuItem hourlyCloudCover;
    @FXML private RadioMenuItem hourlyVisibility;
    @FXML private RadioMenuItem hourlyUVIndexClearSky;
    @FXML private RadioMenuItem hourlyUVIndex;
    @FXML private RadioMenuItem hourlyPressure;
    @FXML private RadioMenuItem hourlyWindDirection;
    @FXML private RadioMenuItem hourlyWeatherCode;
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
        setWeather(event);
    }
    @FXML public void changeUnitsToMetric(ActionEvent event){
       units.setMetric();
       setWeather(event);
       //TODO: change units of all columns currently displayed
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
    @FXML public void addHourlyCloudCover(ActionEvent event){
        Label cloudCover = new Label("Cloud  Cover");
        if(!hourlyCloudCover.isSelected()) {
            removeColumn(cloudCover);
            hourlyCloudCover.setSelected(false);
        }
        else{
            setColumn(getWeather().getHourly().getCloudcover(), cloudCover);
        }
    }
    @FXML public void addHourlyVisibility(ActionEvent event){
        Label visibility = new Label("Visibility");
        if(!hourlyVisibility.isSelected()) {
            removeColumn(visibility);
            hourlyVisibility.setSelected(false);
        }
        else{
            setColumn(getWeather().getHourly().getVisibility(), visibility);
        }
    }
    @FXML public void addHourlyPressure(ActionEvent event){
        Label pressure = new Label("Pressure");
        if(!hourlyPressure.isSelected()) {
            removeColumn(pressure);
            hourlyPressure.setSelected(false);
        }
        else{
            setColumn(getWeather().getHourly().getGeopotential_height_1000hPa(), pressure);
        }
    }
    @FXML public void addHourlyUVIndex(ActionEvent event){
        Label uvIndex = new Label("UV Index");
        if(!hourlyUVIndex.isSelected()) {
            removeColumn(uvIndex);
            hourlyUVIndex.setSelected(false);
        }
        else{
            setColumn(getWeather().getHourly().getUv_index(), uvIndex);
        }
    }
    @FXML public void addHourlyUVIndexClearSky(ActionEvent event){
        Label uvIndexClearSky = new Label("UV Index (Clear Sky)");
        if(!hourlyUVIndexClearSky.isSelected()) {
            removeColumn(uvIndexClearSky);
            hourlyUVIndexClearSky.setSelected(false);
        }
        else{
            setColumn(getWeather().getHourly().getUv_index_clear_sky(), uvIndexClearSky);
        }
    }
    @FXML public void addHourlyPrecipitation(ActionEvent event) {
        Label precipitation = new Label("Precipitation");
        if (!hourlyPrecipitation.isSelected()) {
            removeColumn(precipitation);
            hourlyPrecipitation.setSelected(false);
        } else {
            setColumn(getWeather().getHourly().getPrecipitation(), precipitation);
        }
    }
    @FXML public void addHourlyApparentTemperature(ActionEvent event){
        Label apparentTemperature = new Label("Feels Like");
        if (!hourlyApparentTemperature.isSelected()) {
            removeColumn(apparentTemperature);
            hourlyApparentTemperature.setSelected(false);
        } else {
            setColumn(getWeather().getHourly().getApparent_temperature(), apparentTemperature);
        }
    }
    @FXML public void addHourlyWindDirection(ActionEvent event){
        Label windDirection = new Label("Wind Direction");
        if (!hourlyWindDirection.isSelected()) {
            removeColumn(windDirection);
            hourlyWindDirection.setSelected(false);
        } else {
            setColumn(getWeather().getHourly().getWinddirection_10m(), windDirection);
        }
    }
    @FXML public void addHourlyDewpoint(ActionEvent event){
        Label dewpoint = new Label("Dewpoint");
        if (!hourlyDewpoint.isSelected()) {
            removeColumn(dewpoint);
            hourlyDewpoint.setSelected(false);
        } else {
            setColumn(getWeather().getHourly().getDewpoint_2m(), dewpoint);
        }
    }
    @FXML public void addHourlySnowfall(ActionEvent event){
        Label snowfall = new Label("Snowfall");
        if (!hourlySnowfall.isSelected()) {
            removeColumn(snowfall);
            hourlySnowfall.setSelected(false);
        } else {
            setColumn(getWeather().getHourly().getSnowfall(), snowfall);
        }
    }
    @FXML public void addHourlyRain(ActionEvent event){
        Label rain = new Label("Rain");
        if (!hourlyRain.isSelected()) {
            removeColumn(rain);
            hourlyRain.setSelected(false);
        } else {
            setColumn(getWeather().getHourly().getRain(), rain);
        }
    }
    @FXML public void addHourlyShowers(ActionEvent event){
        Label showers = new Label("Showers");
        if (!hourlyShowers.isSelected()) {
            removeColumn(showers);
            hourlyShowers.setSelected(false);
        } else {
            setColumn(getWeather().getHourly().getShowers(), showers);
        }
    }
    @FXML public void addHourlyPrecipitationProbability(ActionEvent event){
        Label precipitationProbability = new Label("Precipitation Probability");
        if (!hourlyPrecipitationProbability.isSelected()) {
            removeColumn(precipitationProbability);
            hourlyPrecipitationProbability.setSelected(false);
        } else {
            setColumn(getWeather().getHourly().getPrecipitation_probability(), precipitationProbability);
        }
    }
    @FXML public void addHourlyWeatherCode(ActionEvent event){
        Label weatherCode = new Label("Weather Code");
        if (!hourlyWeatherCode.isSelected()) {
            removeColumn(weatherCode);
            hourlyWeatherCode.setSelected(false);
        } else {
            setColumn(getWeather().getHourly().getWeathercode(), weatherCode);
        }
    }
    @FXML public void addHourlyTemperature(ActionEvent event){

        Label temperature = new Label("Temperature");
        if (!hourlyTemperature.isSelected()) {
            removeColumn(temperature);
            hourlyTemperature.setSelected(false);
        } else {
            setColumn(getWeather().getHourly().getTemperature_2m(), temperature);
        }
    }
    public void addHourlyTime(List<String> formattedTime){
        Label time = new Label("Time");
        gridPane.add(time, 1, 0);
        for(int i = 0; i<formattedTime.size(); i++){
            gridPane.add(new Label(formattedTime.get(i)), 1, i+1);
        }
    }
    public void addDays(List<String> weekDays){
        for(int i = 0; i<weekDays.size(); i++){
            gridPane.add(new Label(weekDays.get(i)), 0, i);
        }
    }
    public void removeColumn(Label label){
        String columnName = label.getText();
        int gridSize = gridPane.getChildren().size();
            for(int i = 0; i<gridSize; i++){
                String node = gridPane.getChildren().get(i).toString();

                if(node.contains(columnName)){
                    gridPane.getChildren().remove(i, i+(169-indexCut));
                    break;
                }
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

    }
    @FXML public void setWeather(ActionEvent event){
        setHourlyTable(event, getWeather());
    }
    @FXML public WeatherApiData getWeather(){
        if (searchField.getText() == null)
            return null;
        System.out.println("called getWeather");
        LocationAndWeatherApi api = new LocationAndWeatherApi();
        LocationApiData locationApiData = api.setUserLocation(searchField.getText());
        return api.callWeatherAPI(locationApiData, units);
    }
    public void setColumn(List type, Label label){
        ColumnConstraints column = new ColumnConstraints();
        int columnCount = gridPane.getColumnCount();
        column.setFillWidth(true);

        gridPane.add(label, columnCount, 0);
        for(int i = 0; i<type.size()-indexCut; i++){
            gridPane.add(new Label(String.valueOf(type.get(i+indexCut-1))), columnCount, i+1);
        }
        centerNodes();
    }
    public void setHourlyTable(ActionEvent event, WeatherApiData weather){
        hourlyTemperature.setSelected(true);
        hourlyApparentTemperature.setSelected(true);
        hourlyPrecipitation.setSelected(true);
        gridPane.getChildren().clear();
        List<String> formattedTime = trimListToCurrentTime(weather);
        addDays(weekDay);
        addHourlyTime(formattedTime);
        addHourlyTemperature(event);
        addHourlyPrecipitation(event);
        addHourlyApparentTemperature(event);
        centerNodes();
        //gridPane.setPadding(new Insets(10, 10, 10, 10));
        //gridPane.setVgap(10);
        //gridPane.setHgap(10);
    }

    public static List<String> trimListToCurrentTime(WeatherApiData weather){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        DateTimeFormatter dateTimeMonth = DateTimeFormatter.ofPattern("E, M/d, hh:mm a");
        for(int i = 0; i<weather.getHourly().getTime().size();i++){
            if(weather.getCurrent_weather().getTime().equals(weather.getHourly().getTime().get(i))){
                indexCut = i;
                break;
            }
        }
        //Sets time to "hh:mm a"
        for(ListIterator<String> e = weather.getHourly().getTime().listIterator(); e.hasNext();){
            LocalDateTime localDateTime = LocalDateTime.parse(e.next(), formatter);
            String date = localDateTime.format(dateTimeMonth);
            e.set(date);
        }

        weekDay = new ArrayList<>(weather.getHourly().getTime().size()-indexCut);
        String[] temp = weather.getHourly().getTime().get(indexCut).split(", ", 3);
        weekDay.add(0, "");
        weekDay.add(1, temp[0] + " " + temp[1]);

        weather.getHourly().getTime().subList(0, indexCut).clear();
        for(int i = 0; i<weather.getHourly().getTime().size();i++) {
            temp = weather.getHourly().getTime().get(i).split(", ", 3);
            if (temp[2].equals("12:00 AM")) {
                weekDay.add(i+1, temp[0] + " " + temp[1]);
            }
            else
                weekDay.add(i+1, "");
            weather.getHourly().getTime().set(i, temp[2]);
        }
        if(weekDay.get(weekDay.size()-1)!=""){
            weekDay.set(weekDay.size()-1,"");
        }
        for(ListIterator<String> i = weather.getHourly().getTime().listIterator();i.hasNext();){
            System.out.println(i.next());
        }
        return weather.getHourly().getTime();
    }
    /*
    public void setGridFont(){
        ObservableList<Node>textList = gridPane.getChildren();
         for (Node node : textList) {
          Label.class.cast(node).setFont(Font.font("verdana", 17));
        }
    }
     */
    /*
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
        gridPane.add(new Label("Temperature"+" ("+weather.getHourly_units().getTemperature_2m()+")"), 2, 0);
        gridPane.add(new Label("Feels Like"+" ("+weather.getHourly_units().getApparent_temperature()+")"), 3, 0);
        gridPane.add(new Label("Precipitation"+" ("+weather.getHourly_units().getRain()+")"), 4, 0);

        for(int i = 0; i<weather.getHourly().getTime().size(); i++) {
           // GridPane.setFillWidth(gridPane.getChildren().get(i), true);
            //gridPane.add(new Label(weekDay.get(i)), 0, i+1);
            gridPane.add(new Label(weather.getHourly().getTime().get(i)), 1, i+1);
            gridPane.add(new Label(weather.getHourly().getTemperature_2m().get(i + indexCut) +"°"), 2, i+1 );
            gridPane.add(new Label(weather.getHourly().getApparent_temperature().get(i + indexCut) + "°"), 3, i+1);
            gridPane.add(new Label(String.valueOf(weather.getHourly().getPrecipitation().get(i+indexCut))), 4, i+1);
        }
        //setGridFont();
        centerNodes();
        hourlyTemperature.setSelected(true);
        hourlyApparentTemperature.setSelected(true);
        hourlyPrecipitation.setSelected(true);
    }

     */
}