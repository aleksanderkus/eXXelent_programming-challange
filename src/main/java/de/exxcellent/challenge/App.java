package de.exxcellent.challenge;

import de.exxcellent.challenge.data.PCDataType;
import de.exxcellent.challenge.data.PCFootballTeamData;
import de.exxcellent.challenge.data.PCWeatherDayData;
import de.exxcellent.challenge.io.PCCsvFileReader;
import de.exxcellent.challenge.io.PCFileReader;
import de.exxcellent.challenge.util.FootballDataUtils;
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

    private static final String APP_DIR = System.getProperty("user.dir");
    public static final boolean VERBOSE_LOG = false;
    public static String WEATHER_CSV_FILE = APP_DIR + "\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv";
    public static String FOOTBALL_CSV_FILE = APP_DIR + "\\src\\main\\resources\\de\\exxcellent\\challenge\\football.csv";


    @SuppressWarnings("unchecked")
    public static void main(String... args) {


        PCFileReader fileReader = new PCCsvFileReader();
        List<PCWeatherDayData> weatherData = (ArrayList<PCWeatherDayData>) (ArrayList<?>) fileReader.parseFile(WEATHER_CSV_FILE, PCDataType.Weather);
        List<PCFootballTeamData> footballData = (ArrayList<PCFootballTeamData>) (ArrayList<?>) fileReader.parseFile(FOOTBALL_CSV_FILE, PCDataType.Football);


        String dayWithSmallestTempSpread = "Someday";     // Your day analysis function call …
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", WeatherDataUtils.getDayWithSmallestTemperatureSpread(weatherData));
        System.out.printf("Team with smallest goal spread       : %s%n", FootballDataUtils.getTeamWithSmallestGoalsAllowedDifference(footballData));
    }
}
