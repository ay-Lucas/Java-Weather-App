package com.example.weatherapp;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class LocationAndWeatherApi {
    //private static final int WEEK_LENGTH = 7;
    //private static final int DAY_LENGTH = 24;
    public LocationApiData setUserLocation(String input){
        int zipcode = 0;
        String city = null, state = null, countryCode = null;
        if(input!=null){

            if (input.matches("[0-9]+") && input.length() == 5) {
                zipcode = Integer.parseInt(input);
                System.out.println(Integer.parseInt(input));
            }
            //splits input from TextField searchfield to validate
            else if ((input.contains(" ") || input.contains(","))) {
                String[] split = input.split(", |,| ");
                //.split("[,\\s]");
                //checks for city and state code format
                //sets US as default country
                if (split.length == 2 && split[0].matches("[a-zA-Z]+") && split[1].matches("[a-zA-Z]+") && split[1].length() == 2) {
                    city = split[0];
                    state = split[1];
                    System.out.println(Arrays.toString(split));
                }
                //checks for zipcode and 2 letter country code
                else if (split.length == 2 && split[0].matches("[0-9]+") && split[0].length() == 5 && split[1].matches("[a-zA-Z]+") && split[1].length() == 2) {
                    zipcode = Integer.parseInt(split[0]);
                    countryCode = split[1];

                    System.out.println(Arrays.toString(split));
                    //TODO - allow more than one space
                }
                else if(split.length==3) {
                    //joins together a city which had a space between its name
                    if(split[0].matches("[a-zA-Z]+") && split[1].matches("[a-zA-Z]+") && split[2].matches("[a-zA-Z]+")&&split[2].length()!=2){
                        city = split[0].concat("%20"+split[1]);
                        state = split[2];
                        //userLocationInput = new UserLocationInput(split[0].concat("%20" +split[1]), split[2]);
                    }
                    //checks for city, state, and country code
                    else if (split[0].matches("[a-zA-Z]+") && split[1].matches("[a-zA-Z]+") && split[2].matches("[a-zA-Z]+") && split[1].length() == 2 && split[2].length() == 2){
                        //userLocationInput = new UserLocationInput(split[0], split[1], split[2]);
                        city = split[0];
                        state = split[1];
                        countryCode = split[2];
                        System.out.println(Arrays.toString(split));
                    }
                }
            }
            //currentHighAndLow.setText("current temperature: " + weather.getCurrentTemp());
            //currentWeatherInt.setText("Hourly temperature: " + weather.getSingleDayHourlyTempsAndDates());
            //currentHighAndLow.setText(("timezone: " + userLocationInput.getTimezone()));//+"City: " + userLocationInput.getCity() + " State: " +userLocationInput.getState()+ " Country: " + userLocationInput.getCountry() + " Latitude : " + String.valueOf(userLocationInput.getLatitude()) + " Longitude: " + String.valueOf(userLocationInput.getLongitude())));
        }
        return callCoordinatesAPI(zipcode, countryCode, state, city);
        //callCoordinatesAPI(zipcode, countryCode, state, city);
    }

    public WeatherApiData callWeatherAPI(LocationApiData data, Units units) {
        if(data.isValid()) {
            try{
                String urlString = "https://api.open-meteo.com/v1/forecast?latitude="+ data.getLat() + "&" + "longitude=" + data.getLon() +
                        "&hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,apparent_temperature,precipitation_probability,precipitation,rain,winddirection_10m," +
                        "showers,snowfall,weathercode,uv_index,uv_index_clear_sky,geopotential_height_1000hPa,cloudcover,visibility,windspeed_10m,windgusts_10m" +
                        ",&daily=weathercode,apparent_temperature_max,apparent_temperature_min,uv_index_max,uv_index_clear_sky_max,windspeed_10m_max," +
                        "windspeed_10m_min,winddirection_10m_dominant,shortwave_radiation_sum,temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,"+
                        "rain_sum,showers_sum,snowfall_sum,precipitation_hours,precipitation_probability_max" +
                        ",windgusts_10m_max"+"&current_weather=true&temperature_unit=" + units.getTempUnit() +
                        "&windspeed_unit="+units.getWindUnit() +"&precipitation_unit="+units.getPrecipitationUnit() +
                        "&timezone=" + "auto";
                URL url = new URL(urlString);
                URLConnection con = url.openConnection();
                BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String str = rd.readLine();
                WeatherApiData weatherData = new Gson().fromJson(str, WeatherApiData.class);
                rd.close();
                System.out.println(weatherData.toString());
                //System.out.println(weatherData.getPrecipitation_sum());
                return weatherData;
            }
            catch (IOException e){
                System.out.println(e.getMessage()+
                        "Weather API failed");
            } 
        }
        System.out.println("locationApiData contains null values: lat, lon");
        return null;
        /*
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        Map<String, Object> response = jsonToMap(result.toString());
        Weather weather = parseAPIData(response);
        //parseAPIData(jsonToMap(result.toString()));
       */
    }
    public static Map<String, Object> jsonToMap(String str){
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {}.getType());
        return map;
    }
    public LocationApiData callCoordinatesAPI(int zipcode, String countryCode, String state, String city ){
        LocationApiData locationApiData = new LocationApiData();
        if(countryCode==null)
            countryCode="us";
        String accessKey = "8865844abbd559c5002b93536691d5be";
        String urlString;
        if(zipcode == 0) {
            urlString = "https://api.openweathermap.org/geo/1.0/direct?q=" + city + "," + state + "," + countryCode + "&limit=1" + "&appid=" + accessKey;
        }
        else{
            urlString = "https://api.openweathermap.org/geo/1.0/zip?zip=" + zipcode + "," + countryCode + "&limit=1" + "&appid=" + accessKey;}
        try {
        URL url = new URL(urlString);
        URLConnection con = url.openConnection();
        BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String str = rd.readLine();
            if(zipcode==0){
                Type location= new TypeToken<ArrayList<LocationApiData>>(){}.getType();
                List<LocationApiData> locationApiData1 = new Gson().fromJson(str, location);
                System.out.println(locationApiData1);
                locationApiData = locationApiData1.get(0);
                rd.close();
                return locationApiData;
            }
            else {
                locationApiData = new Gson().fromJson(str, LocationApiData.class);
                System.out.println(locationApiData);
                rd.close();
                return locationApiData;
            }
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
        return locationApiData;
    }
    /*
    public Weather parseAPIData(Map<String, Object> result){
        //TODO = deserialize JSON
        //https://www.youtube.com/watch?v=BbI8FdQOKNs
        System.out.println(result.toString());
        return null;
        /*
        Map<String, Object> currentWeather = (Map<String, Object>) result.get("current_weather");
        Map<String, Object> tempMap = (Map<String, Object>) result.get("hourly");
        weather.setSingleDayHourlyDateTimes((List<String>) tempMap.get("time"));
        this.sevenDayHourlyTemps = (List<String>) tempMap.get("temperature_2m");
        this.sevenDayHourlyApparentTemps = (List<Double>) tempMap.get("apparent_temperature");
        this.sevenDayHourlyChanceOfPrecip = (List<Double>) tempMap.get("precipitation_probability");
        this.currentTemp = (Double) currentWeather.get("temperature");
        this.currentWindSpeed = (Double) currentWeather.get("windspeed");
        this.is_day = Boolean.valueOf(String.valueOf(currentWeather.get("is_day")));
        this.currentDataTimeStamp = (String) currentWeather.get("time");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        DateTimeFormatter weekday_day = DateTimeFormatter.ofPattern("MM/dd hh:mm a");

        //System.out.println(this.currentTemp + " " + this.currentWindSpeed +": " + is_day + dataTimeStamp);
        double[][]dayTemps = new double[WEEK_LENGTH][DAY_LENGTH];
        int count = 0;
        for(int i = 0;i<WEEK_LENGTH;i++){
            for(int j = 0; j<DAY_LENGTH;j++){
                dayTemps[i][j] = Double.parseDouble(String.valueOf(sevenDayHourlyTemps.get(count++)));
            }
            Arrays.sort(dayTemps[i]);
            this.weeklyLows[i]=dayTemps[i][0];
            this.weeklyHighs[i]=dayTemps[i][DAY_LENGTH-1];
        }
        //System.out.println(Arrays.deepToString(dayTemps));
        //System.out.println("\nweekly highs: " +Arrays.toString(weeklyHighs) + "\nweekly lows: " + Arrays.toString(weeklyLows));
        for (ListIterator<String> i = this.sevenDayHourlyDateTimes.listIterator(); i.hasNext(); ) {
            LocalDateTime newLocalDateTime = LocalDateTime.parse(i.next(), formatter);
            String element = newLocalDateTime.format(weekday_day);
            i.set(element);
        }
        for (ListIterator<String> i = this.sevenDayHourlyTemps.listIterator(); i.hasNext(); ) {
            String temp = String.valueOf(i.next()) + "°";
            i.set(temp);
        }
        setSingleDayHourlyTemps(this.sevenDayHourlyTemps.subList(0, 24));
        setSingleDayHourlyDateTimes(this.sevenDayHourlyDateTimes.subList(0, 24));

        LocalDateTime dateTime = LocalDateTime.now();
        //TODO
        //Find a way to show only weather from the present onward
        return weather;
    } */


}
