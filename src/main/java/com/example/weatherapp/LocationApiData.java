package com.example.weatherapp;

public class LocationApiData {

    private String name;
    private LocalName local_names;
    private Float lat;
    private Float lon;
    private String country;
    private String state;
    public LocationApiData() {
    }
    public LocationApiData(String name, LocalName local_names, Float lat, Float lon, String country, String state) {
        this.name = name;
        this.local_names = local_names;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
        this.state = state;
    }
    public boolean isValid(){
        return this.lon!=null||this.lat!=null;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalName getLocal_names() {
        return local_names;
    }
    public void setLocal_names(LocalName local_names) {
        this.local_names = local_names;
    }
    public static class LocalName {
        //null
    }


}

