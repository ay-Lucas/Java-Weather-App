package com.example.weatherapp;

import com.example.weatherapp.models.*;

public class WeatherApiData{
    private double latitude;
    private double longitude;
    private double generationtime_ms;
    private double utc_offset_seconds;
    private String timeZone;
    private String timezone_abbreviation;
    private double elevation;
    private CurrentWeatherModel current_weather;
    private HourlyUnitsModel hourly_units;
    private HourlyModel hourly;
    private DailyUnitsModel daily_units;
    private DailyModel daily;
    public WeatherApiData(double latitude, double longitude, double generationtime_ms, double utc_offset_seconds,
                          String timeZone, String timezone_abbreviation, double elevation, HourlyUnitsModel hourly_units, HourlyModel hourly, DailyUnitsModel daily_units, DailyModel daily) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.generationtime_ms = generationtime_ms;
        this.utc_offset_seconds = utc_offset_seconds;
        this.timeZone = timeZone;
        this.elevation = elevation;
        this.timezone_abbreviation = timezone_abbreviation;
        this.hourly_units = hourly_units;
        this.hourly = hourly;
        this.daily_units = daily_units;
        this.daily = daily;
        //this.hourly = hourly;
    }
    public WeatherApiData(){
    }

public double getLatitude() {
    return latitude;
}

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getGenerationtime_ms() {
        return generationtime_ms;
    }

    public void setGenerationtime_ms(double generationtime_ms) {
        this.generationtime_ms = generationtime_ms;
    }

    public double getUtc_offset_seconds() {
        return utc_offset_seconds;
    }

    public void setUtc_offset_seconds(double utc_offset_seconds) {
        this.utc_offset_seconds = utc_offset_seconds;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTimezone_abbreviation() {
        return timezone_abbreviation;
    }

    public void setTimezone_abbreviation(String timezone_abbreviation) {
        this.timezone_abbreviation = timezone_abbreviation;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public HourlyUnitsModel getHourly_units() {
        return hourly_units;
    }

    public void setHourly_units(HourlyUnitsModel hourly_units) {
        this.hourly_units = hourly_units;
    }

    public HourlyModel getHourly() {
        return hourly;
    }

    public void setHourly(HourlyModel hourly) {
        this.hourly = hourly;
    }

    public DailyUnitsModel getDaily_units() {
        return daily_units;
    }

    public void setDaily_units(DailyUnitsModel daily_units) {
        this.daily_units = daily_units;
    }

    public DailyModel getDaily() {
        return daily;
    }

    public void setDaily(DailyModel daily) {
        this.daily = daily;
    }
    public CurrentWeatherModel getCurrent_weather() {
        return current_weather;
    }

    public void setCurrent_weather(CurrentWeatherModel current_weather) {
        this.current_weather = current_weather;
    }
    /*
    String status;
    String message;
    String countryCode;
    String countryName;
    String regionName;
    String cityName;
    String zoneName;
    String abbreviation;
    String gmtOffset;
    String dst;
    String zoneStart;
    String nextAbbreviation;
    String timeStamp;
    String formatted;

 */




}
