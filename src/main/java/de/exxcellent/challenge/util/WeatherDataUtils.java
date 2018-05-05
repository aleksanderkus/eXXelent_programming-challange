package de.exxcellent.challenge.util;

import de.exxcellent.challenge.App;
import de.exxcellent.challenge.data.PCWeatherDayData;

import java.util.List;

/**
 * utils class for working with {@link PCWeatherDayData}
 *
 * @author Aleksander Kus(akus@stud.hs-heilbronn.de)
 */
public class WeatherDataUtils {

    /**
     * @param weatherDataList the list with all days that should be tested
     * @return the day as <code>int</code>
     * @throws IllegalArgumentException if the input list is empty
     */
    public static int getDayWithSmallestTemperatureSpread(List<PCWeatherDayData> weatherDataList) {
        if (weatherDataList == null || weatherDataList.isEmpty()) {
            throw new IllegalArgumentException("illegal weather data list " + (weatherDataList == null ? "(NULL)" : "(EMPTY)"));
        }
        PCWeatherDayData dayWithSmallestTemperatureSpread = null;
        for (PCWeatherDayData data : weatherDataList) {
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
                    if (App.VERBOSE_LOG)
                        System.out.println("Day " + dayWithSmallestTemperatureSpread.getDayOfMonth() + " and day " + data.getDayOfMonth() + " have the same temperature spread!");
                }
            } else {
                dayWithSmallestTemperatureSpread = data;
            }
        }
        return dayWithSmallestTemperatureSpread.getDayOfMonth();
    }


    /**
     * @param contentAsString the weather information as array
     * @return a new instance of {@link PCWeatherDayData}
     * @throws NumberFormatException    if the file is wrong formatted
     * @throws IllegalArgumentException if the input array is wrong
     */
    public static PCWeatherDayData createWeatherDataFromStringArray(String[] contentAsString) {
        if (contentAsString.length < 3) {
            throw new IllegalArgumentException("input string array has wrong size!");
        }
        PCWeatherDayData weatherData = null;
        try {
            int dayOfMonth = Integer.parseInt(contentAsString[0]);
            int maxTemp = Integer.parseInt(contentAsString[1]);
            int minTemp = Integer.parseInt(contentAsString[2]);
            weatherData = new PCWeatherDayData(dayOfMonth, maxTemp, minTemp);
        } catch (NumberFormatException e) {
            System.err.println("wrong format of file for weather data");
            e.printStackTrace();
        }
        return weatherData;
    }
}
