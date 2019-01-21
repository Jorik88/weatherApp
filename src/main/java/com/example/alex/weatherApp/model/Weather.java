package com.example.alex.weatherApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    private String dayOfWeek;
    private String dayDate;
    private String month;
    private String maxTemperature;
    private String minTemperature;

    @Override
    public String toString() {
        return "Weather{" +
                "dayOfWeek='" + dayOfWeek + '\'' +
                ", dayDate='" + dayDate + '\'' +
                ", month='" + month + '\'' +
                ", maxTemperature='" + maxTemperature + '\'' +
                ", minTemperature='" + minTemperature + '\'' +
                '}';
    }
}
