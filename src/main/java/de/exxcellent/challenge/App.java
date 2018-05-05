package de.exxcellent.challenge;

import de.exxcellent.challenge.data.PCData;
import de.exxcellent.challenge.data.PCDataType;
import de.exxcellent.challenge.data.PCWeatherData;
import de.exxcellent.challenge.io.PCCsvFileReader;
import de.exxcellent.challenge.util.WeatherDataUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    public static void main(String... args) {

        // Your preparation code …


        List<PCWeatherData> data = (ArrayList<PCWeatherData>) (ArrayList<?>) new PCCsvFileReader().parseFile("C:\\Users\\Aleks\\Desktop\\Bewerbung\\eXXelent Solutions\\programming-challenge\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv", PCDataType.Weather);

        System.out.println(WeatherDataUtils.getDayWithSmallestTemperatureSpread(data));

        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
