package com.example.weatherapp.models;

import java.util.List;

public class HourlyModel {
    private List<String> time;
    private List<Double> temperature_2m;
    private List<Double> dewpoint_2m;
    private List<Double> apparent_temperature;
    private List<Double> precipitation_probability;
    private List<Double> precipitation;
    private List<Double> snowfall;
    private List<Integer> weathercode;
    private List<Double> uv_index;
    private List<Double> uv_index_clear_sky;
    private List<Double> geopotential_height_1000hpa;
    private List<Double> rain;
    private List<Double> showers;
    private List<Double> cloudcover;
    private List<Double> visibility;
    private List<Double> windspeed_10m;
    private List<Double> winddirection_10m;
    private List<Double> windgusts_10m;

    public HourlyModel() {
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<Double> getTemperature_2m() {
        return temperature_2m;
    }

    public void setTemperature_2m(List<Double> temperature_2m) {
        this.temperature_2m = temperature_2m;
    }

    public List<Double> getDewpoint_2m() {
        return dewpoint_2m;
    }

    public void setDewpoint_2m(List<Double> dewpoint_2m) {
        this.dewpoint_2m = dewpoint_2m;
    }

    public List<Double> getApparent_temperature() {
        return apparent_temperature;
    }

    public void setApparent_temperature(List<Double> apparent_temperature) {
        this.apparent_temperature = apparent_temperature;
    }

    public List<Double> getPrecipitation_probability() {
        return precipitation_probability;
    }

    public void setPrecipitation_probability(List<Double> precipitation_probability) {
        this.precipitation_probability = precipitation_probability;
    }

    public List<Double> getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(List<Double> precipitation) {
        this.precipitation = precipitation;
    }

    public List<Double> getSnowfall() {
        return snowfall;
    }

    public void setSnowfall(List<Double> snowfall) {
        this.snowfall = snowfall;
    }

    public List<Integer> getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(List<Integer> weathercode) {
        this.weathercode = weathercode;
    }

    public List<Double> getUv_index() {
        return uv_index;
    }

    public void setUv_index(List<Double> uv_index) {
        this.uv_index = uv_index;
    }

    public List<Double> getUv_index_clear_sky() {
        return uv_index_clear_sky;
    }

    public void setUv_index_clear_sky(List<Double> uv_index_clear_sky) {
        this.uv_index_clear_sky = uv_index_clear_sky;
    }

    public List<Double> getGeopotential_height_1000hpa() {
        return geopotential_height_1000hpa;
    }

    public void setGeopotential_height_1000hpa(List<Double> geopotential_height_1000hpa) {
        this.geopotential_height_1000hpa = geopotential_height_1000hpa;
    }

    public List<Double> getRain() {
        return rain;
    }

    public void setRain(List<Double> rain) {
        this.rain = rain;
    }

    public List<Double> getShowers() {
        return showers;
    }

    public void setShowers(List<Double> showers) {
        this.showers = showers;
    }

    public List<Double> getCloudcover() {
        return cloudcover;
    }

    public void setCloudcover(List<Double> cloudcover) {
        this.cloudcover = cloudcover;
    }

    public List<Double> getVisibility() {
        return visibility;
    }

    public void setVisibility(List<Double> visibility) {
        this.visibility = visibility;
    }

    public List<Double> getWindspeed_10m() {
        return windspeed_10m;
    }

    public void setWindspeed_10m(List<Double> windspeed_10m) {
        this.windspeed_10m = windspeed_10m;
    }

    public List<Double> getWinddirection_10m() {
        return winddirection_10m;
    }

    public void setWinddirection_10m(List<Double> winddirection_10m) {
        this.winddirection_10m = winddirection_10m;
    }

    public List<Double> getWindgusts_10m() {
        return windgusts_10m;
    }

    public void setWindgusts_10m(List<Double> windgusts_10m) {
        this.windgusts_10m = windgusts_10m;
    }
}