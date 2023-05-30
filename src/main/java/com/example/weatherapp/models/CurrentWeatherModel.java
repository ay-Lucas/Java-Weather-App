package com.example.weatherapp.models;

public class CurrentWeatherModel {
    private Double temperature;
    private Double windspeed;
    private Double winddirection;
    private int weathercode;
    private int is_day;
    private String time;

    public Double getTemperature() {
        return temperature;
    }

    public Double getWindspeed() {
        return windspeed;
    }

    public Double getWinddirection() {
        return winddirection;
    }

    public int getWeathercode() {
        return weathercode;
    }

    public int getIs_day() {
        return is_day;
    }

    public String getTime() {
        return time;
    }
}
