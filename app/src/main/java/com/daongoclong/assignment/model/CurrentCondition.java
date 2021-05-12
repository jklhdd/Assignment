package com.daongoclong.assignment.model;

public class CurrentCondition {
    private String WeatherText;
    private TwoTemp Temperature;

    public String getWeatherText() {
        return WeatherText;
    }

    public void setWeatherText(String weatherText) {
        WeatherText = weatherText;
    }

    public TwoTemp getTemperature() {
        return Temperature;
    }

    public void setTemperature(TwoTemp temperature) {
        Temperature = temperature;
    }

    public class TwoTemp{
        private Temp Metric;
        private Temp Imperial;

        public Temp getMetric() {
            return Metric;
        }
    };
}
