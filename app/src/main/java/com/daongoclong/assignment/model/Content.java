package com.daongoclong.assignment.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Content {
    private String DateTime;
    private int WeatherIcon;
    private Temp Temperature;

    public String getDateTime() {
        return convertTime(DateTime);
    }

    public void setDateTime(String dateTime) {
        this.DateTime = dateTime;
    }

    public int getWeatherIcon() {
        return WeatherIcon;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.WeatherIcon = weatherIcon;
    }

    public Temp getTemperature() {
        return Temperature;
    }

    public void setTemperature(Temp temprature) {
        this.Temperature = temprature;
    }

    public String convertTime(String inputTime) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = inFormat.parse(inputTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("ha");
        String goal = outFormat.format(date);
        return goal;
    }

}
