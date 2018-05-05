package de.exxcellent.challenge.util;

import de.exxcellent.challenge.data.PCWeatherData;

import java.util.List;

public class WeatherDataUtils {


    public static int getDayWithSmallestTemperatureSpread(List<PCWeatherData> weatherDataList) {
        PCWeatherData dayWithSmallestTemperatureSpread = null;
        for (PCWeatherData data : weatherDataList) {
            if (dayWithSmallestTemperatureSpread != null) {
                int minTemp1 = dayWithSmallestTemperatureSpread.getMinTemp();
                int maxTemp1 = dayWithSmallestTemperatureSpread.getMaxTemp();
                int tempSpread1 = (maxTemp1 - minTemp1);
                int minTemp2 = data.getMinTemp();
                int maxTemp2 = data.getMaxTemp();
                int tempSpread2 = (maxTemp2 - minTemp2);
                if (tempSpread2 < tempSpread1) {
                    dayWithSmallestTemperatureSpread = data;
                } else if (tempSpread2 == tempSpread1) {
                    // for the first time if there are two days with the same spread only notify via console
                    System.out.println("Day " + dayWithSmallestTemperatureSpread.getDayOfMonth() + " and day " + data.getDayOfMonth() + " have the same temperature spread!");
                }
            } else {
                dayWithSmallestTemperatureSpread = data;
            }
        }
        assert dayWithSmallestTemperatureSpread != null;
        return dayWithSmallestTemperatureSpread.getDayOfMonth();
    }


    public static PCWeatherData createWeatherDataFromStringArray(String[] contentAsString) {
        PCWeatherData weatherData = null;
        try {
            int dayOfMonth = Integer.parseInt(contentAsString[0]);
            int maxTemp = Integer.parseInt(contentAsString[1]);
            int minTemp = Integer.parseInt(contentAsString[2]);
            weatherData = new PCWeatherData(dayOfMonth, maxTemp, minTemp);
        } catch (NumberFormatException e) {
            System.err.println("wrong format of file for weather data");
            e.printStackTrace();
        }
        return weatherData;
    }
}
