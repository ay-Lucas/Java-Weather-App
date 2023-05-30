package com.example.weatherapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Weather {
    private String currentDataTimeStamp;
    private List<String> singleDayHourlyTemps;
    private List<String> singleDayHourlyDateTimes;
    private List<String> sevenDayHourlyTemps;
    private List<String> sevenDayHourlyDateTimes;
    private Double currentTemp;
    private Double currentWindSpeed;
    private int currentWeatherCode;
    private Boolean is_day;
    private String tempUnits;
    private String windUnits;
    private String precipitationUnits;
    private Double[] weeklyLows;
    private Double[] weeklyHighs;
    private String currentHighandLow;
    private List<Double> sevenDayHourlyApparentTemps;
    private List<Double> sevenDayHourlyChanceOfPrecip;
    private List<Double> weeklyPrecipitationProbability;
    private List<Double> weeklyPrecipitation;
    private List<Double> weeklyShowers;
    private List<Double> weeklyCloudCover;
    private List<Double> weeklyVisibility;
    private List<Double> weeklyWindSpeed;
    private List<Double> weeklyWindDirection;
    private List<Double> weeklyWindGusts;
    public Weather(){
        this.currentDataTimeStamp = "none";
        this.singleDayHourlyTemps = new ArrayList<>();
        this.singleDayHourlyDateTimes = new ArrayList<>();
        this.sevenDayHourlyDateTimes = new ArrayList<>();
        this.sevenDayHourlyTemps = new ArrayList<>();
        this.weeklyHighs = new Double[7];
        this.weeklyLows = new Double[7];
    }
    public Weather(String tempUnits, String windUnits, String precipitationUnits) throws IOException {
        this.setTempUnits(tempUnits);
        this.setWindUnits(windUnits);
        this.setPrecipitationUnits(precipitationUnits);
        this.currentDataTimeStamp = "none";
        this.singleDayHourlyTemps = new ArrayList<>();
        this.singleDayHourlyDateTimes = new ArrayList<>();
        this.sevenDayHourlyDateTimes = new ArrayList<>();
        this.sevenDayHourlyTemps = new ArrayList<>();
        this.weeklyHighs = new Double[7];
        this.weeklyLows = new Double[7];
        //fetchWeather();
    }
    /*TODO
    * ORGANIZE data model
     */
    public String getCurrentHighandLow() {

        return currentHighandLow;
    }
    public void setCurrentHighandLow(String currentHighandLow) {
        this.currentHighandLow = currentHighandLow;
    }
    public String getTempUnits() {
        return tempUnits;
    }
    public void setTempUnits(String tempUnits) {
        this.tempUnits = tempUnits;
    }
    public String getWindUnits() {
        return windUnits;
    }
    public void setWindUnits(String windUnits) {
        this.windUnits = windUnits;
    }

    public String getPrecipitationUnits() {
        return precipitationUnits;
    }

    public void setPrecipitationUnits(String precipitationUnits) {
        this.precipitationUnits = precipitationUnits;
    }

    public Double getCurrentTemp(){
        return this.currentTemp;
    }
    public Double getCurrentWindSpeed(){
        return this.currentWindSpeed;
    }
    public String getCurrentDataTimeStamp(){
        return this.currentDataTimeStamp;
    }
    public Boolean getIs_day(){
        return this.is_day;
    }
    public List<String> getSevenDayHourlyDateTimes(){
        return this.sevenDayHourlyDateTimes;
    }
    public List<String> getSevenDayHourlyTemps(){
        return this.sevenDayHourlyTemps;
    }
    public List<String> getSingleDayHourlyTemps() {
        return singleDayHourlyTemps;
    }
    public void setSingleDayHourlyTemps(List<String> singleDayHourlyTemps) {
        this.singleDayHourlyTemps = singleDayHourlyTemps;
    }
    public List<String> getSingleDayHourlyDateTimes() {
        return singleDayHourlyDateTimes;
    }
    public void setSingleDayHourlyDateTimes(List<String> singleDayHourlyDateTimes) {
        this.singleDayHourlyDateTimes = singleDayHourlyDateTimes;
    }
    public Double[] getWeeklyLows() {
        return weeklyLows;
    }
    public void setWeeklyLows(Double[] weeklyLows) {
        this.weeklyLows = weeklyLows;
    }
    public Double[] getWeeklyHighs() {
        return weeklyHighs;
    }
    public void setWeeklyHighs(Double[] weeklyHighs) {
        this.weeklyHighs = weeklyHighs;
    }

    public List<Double> getSevenDayHourlyApparentTemps() {
        return sevenDayHourlyApparentTemps;
    }
    public void setSevenDayHourlyApparentTemps(List<Double> sevenDayHourlyApparentTemps) {
        this.sevenDayHourlyApparentTemps = sevenDayHourlyApparentTemps;
    }
    public List<Double> getSevenDayHourlyChanceOfPrecip() {
        return sevenDayHourlyChanceOfPrecip;
    }

    public void setSevenDayHourlyChanceOfPrecip(List<Double> sevenDayHourlyChanceOfPrecip) {
        this.sevenDayHourlyChanceOfPrecip = sevenDayHourlyChanceOfPrecip;
    }
    public List<Double> getWeeklyPrecipitationProbability() {
        return weeklyPrecipitationProbability;
    }

    public void setWeeklyPrecipitationProbability(List<Double> weeklyPrecipitationProbability) {
        this.weeklyPrecipitationProbability = weeklyPrecipitationProbability;
    }

    public List<Double> getWeeklyPrecipitation() {
        return weeklyPrecipitation;
    }

    public void setWeeklyPrecipitation(List<Double> weeklyPrecipitation) {
        this.weeklyPrecipitation = weeklyPrecipitation;
    }

    public List<Double> getWeeklyShowers() {
        return weeklyShowers;
    }

    public void setWeeklyShowers(List<Double> weeklyShowers) {
        this.weeklyShowers = weeklyShowers;
    }

    public List<Double> getWeeklyCloudCover() {
        return weeklyCloudCover;
    }

    public void setWeeklyCloudCover(List<Double> weeklyCloudCover) {
        this.weeklyCloudCover = weeklyCloudCover;
    }

    public List<Double> getWeeklyVisibility() {
        return weeklyVisibility;
    }

    public void setWeeklyVisibility(List<Double> weeklyVisibility) {
        this.weeklyVisibility = weeklyVisibility;
    }

    public List<Double> getWeeklyWindSpeed() {
        return weeklyWindSpeed;
    }

    public void setWeeklyWindSpeed(List<Double> weeklyWindSpeed) {
        this.weeklyWindSpeed = weeklyWindSpeed;
    }

    public List<Double> getWeeklyWindDirection() {
        return weeklyWindDirection;
    }

    public void setWeeklyWindDirection(List<Double> weeklyWindDirection) {
        this.weeklyWindDirection = weeklyWindDirection;
    }

    public List<Double> getWeeklyWindGusts() {
        return weeklyWindGusts;
    }

    public void setWeeklyWindGusts(List<Double> weeklyWindGusts) {
        this.weeklyWindGusts = weeklyWindGusts;
    }

    public void setCurrentDataTimeStamp(String currentDataTimeStamp) {
        this.currentDataTimeStamp = currentDataTimeStamp;
    }

}
