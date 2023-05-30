package com.example.weatherapp.models;

import java.util.List;

public class DailyModel {
    private List<String> time;
    private List<Double> temperature_2m_max;
    private List<Double> temperature_2m_min;
    private List<String> sunrise;
    private List<String> sunset;
    private List<Double> precipitation_sum;
    private List<Double> rain_sum;
    private List<Double> weathercode;
    private List<Double> apparent_temperature_max;
    private List<Double> apparent_temperature_min;
    private List<Double> uv_index_max;
    private List<Double> uv_index_clear_sky_max;
    private List<Double> windspeed_10m_max;
    private List<Double> windspeed_10m_min;
    private List<Double> winddirection_10m_dominant;
    private List<Double> shortwave_radiation_sum;
    private List<Double> showers_sum;
    private List<Double> snowfall_sum;
    private List<Double> precipitation_hours;
    private List<Double> precipitation_probability_max;
    private List<Double> windgusts_10m_max;

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<Double> getTemperature_2m_max() {
        return temperature_2m_max;
    }

    public void setTemperature_2m_max(List<Double> temperature_2m_max) {
        this.temperature_2m_max = temperature_2m_max;
    }

    public List<Double> getTemperature_2m_min() {
        return temperature_2m_min;
    }

    public void setTemperature_2m_min(List<Double> temperature_2m_min) {
        this.temperature_2m_min = temperature_2m_min;
    }

    public List<String> getSunrise() {
        return sunrise;
    }

    public void setSunrise(List<String> sunrise) {
        this.sunrise = sunrise;
    }

    public List<String> getSunset() {
        return sunset;
    }

    public void setSunset(List<String> sunset) {
        this.sunset = sunset;
    }

    public List<Double> getPrecipitation_sum() {
        return precipitation_sum;
    }

    public void setPrecipitation_sum(List<Double> precipitation_sum) {
        this.precipitation_sum = precipitation_sum;
    }

    public List<Double> getRain_sum() {
        return rain_sum;
    }

    public void setRain_sum(List<Double> rain_sum) {
        this.rain_sum = rain_sum;
    }

    public List<Double> getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(List<Double> weathercode) {
        this.weathercode = weathercode;
    }

    public List<Double> getApparent_temperature_max() {
        return apparent_temperature_max;
    }

    public void setApparent_temperature_max(List<Double> apparent_temperature_max) {
        this.apparent_temperature_max = apparent_temperature_max;
    }

    public List<Double> getApparent_temperature_min() {
        return apparent_temperature_min;
    }

    public void setApparent_temperature_min(List<Double> apparent_temperature_min) {
        this.apparent_temperature_min = apparent_temperature_min;
    }

    public List<Double> getUv_index_max() {
        return uv_index_max;
    }

    public void setUv_index_max(List<Double> uv_index_max) {
        this.uv_index_max = uv_index_max;
    }

    public List<Double> getUv_index_clear_sky_max() {
        return uv_index_clear_sky_max;
    }

    public void setUv_index_clear_sky_max(List<Double> uv_index_clear_sky_max) {
        this.uv_index_clear_sky_max = uv_index_clear_sky_max;
    }

    public List<Double> getWindspeed_10m_max() {
        return windspeed_10m_max;
    }

    public void setWindspeed_10m_max(List<Double> windspeed_10m_max) {
        this.windspeed_10m_max = windspeed_10m_max;
    }

    public List<Double> getWindspeed_10m_min() {
        return windspeed_10m_min;
    }

    public void setWindspeed_10m_min(List<Double> windspeed_10m_min) {
        this.windspeed_10m_min = windspeed_10m_min;
    }

    public List<Double> getWinddirection_10m_dominant() {
        return winddirection_10m_dominant;
    }

    public void setWinddirection_10m_dominant(List<Double> winddirection_10m_dominant) {
        this.winddirection_10m_dominant = winddirection_10m_dominant;
    }

    public List<Double> getShortwave_radiation_sum() {
        return shortwave_radiation_sum;
    }

    public void setShortwave_radiation_sum(List<Double> shortwave_radiation_sum) {
        this.shortwave_radiation_sum = shortwave_radiation_sum;
    }

    public List<Double> getShowers_sum() {
        return showers_sum;
    }

    public void setShowers_sum(List<Double> showers_sum) {
        this.showers_sum = showers_sum;
    }

    public List<Double> getSnowfall_sum() {
        return snowfall_sum;
    }

    public void setSnowfall_sum(List<Double> snowfall_sum) {
        this.snowfall_sum = snowfall_sum;
    }

    public List<Double> getPrecipitation_hours() {
        return precipitation_hours;
    }

    public void setPrecipitation_hours(List<Double> precipitation_hours) {
        this.precipitation_hours = precipitation_hours;
    }

    public List<Double> getPrecipitation_probability_max() {
        return precipitation_probability_max;
    }

    public void setPrecipitation_probability_max(List<Double> precipitation_probability_max) {
        this.precipitation_probability_max = precipitation_probability_max;
    }

    public List<Double> getWindgusts_10m_max() {
        return windgusts_10m_max;
    }

    public void setWindgusts_10m_max(List<Double> windgusts_10m_max) {
        this.windgusts_10m_max = windgusts_10m_max;
    }
}
