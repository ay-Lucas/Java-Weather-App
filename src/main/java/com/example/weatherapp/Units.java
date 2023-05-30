package com.example.weatherapp;
public class Units {
    String tempUnit;
    String windUnit;
    String precipitationUnit;
    public Units(){
        tempUnit = "fahrenheit";
        precipitationUnit = "inch";
        windUnit = "mph";
    }
    public void setMetric(){
        this.tempUnit ="celsius";
        this.windUnit ="kmh";
        this.precipitationUnit = "mm";
    }
    public void setImperial(){
        this.tempUnit ="fahrenheit";
        this.windUnit = "mph";
        this.precipitationUnit = "inch";
    }
    public String getTempUnit() {
        return tempUnit;
    }
    public void setTempUnit(String tempUnit) {
        this.tempUnit = tempUnit;
    }
    public String getWindUnit() {
        return windUnit;
    }
    public void setWindUnit(String windUnit) {
        this.windUnit = windUnit;
    }
    public String getPrecipitationUnit() {
        return precipitationUnit;
    }
    public void setPrecipitationUnit(String precipitationUnit) {
        this.precipitationUnit = precipitationUnit;
    }
}
