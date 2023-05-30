module com.example.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
    requires org.json;
    requires com.google.gson;
    requires java.net.http;


    opens com.example.weatherapp to javafx.fxml, com.google.gson;
    exports com.example.weatherapp;
    exports com.example.weatherapp.models;
    opens com.example.weatherapp.models to com.google.gson, javafx.fxml;
    exports com.example.weatherapp.controllers;
    opens com.example.weatherapp.controllers to com.google.gson, javafx.fxml;
}