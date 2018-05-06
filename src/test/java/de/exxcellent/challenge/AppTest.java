package de.exxcellent.challenge;

import de.exxcellent.challenge.data.PCData;
import de.exxcellent.challenge.data.PCDataType;
import de.exxcellent.challenge.data.PCFootballTeamData;
import de.exxcellent.challenge.data.PCWeatherDayData;
import de.exxcellent.challenge.io.PCCsvFileReader;
import de.exxcellent.challenge.io.PCFileReader;
import de.exxcellent.challenge.util.FootballDataUtils;
import de.exxcellent.challenge.util.WeatherDataUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Example JUnit4 test case.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

    private List<PCData> pcWeatherData = null;
    private List<PCData> pcFootballData = null;

    private PCFileReader pcFileReader = null;

    @Before
    public void setUp() {
        pcFileReader = new PCCsvFileReader();
    }


    @Test
    public void checkWeatherData() {
        pcWeatherData = pcFileReader.parseFile(App.WEATHER_CSV_FILE, PCDataType.Weather);
        Assert.assertTrue("Type of PCData in pcWeatherData is not PCWeatherDayData", (pcWeatherData.get(0) instanceof PCWeatherDayData));
        Assert.assertEquals("Count of pcWeatherData is not 30", 30, pcWeatherData.size());
    }

    @Test
    public void checkSettingWrongDataTypeByWeather() {
        pcWeatherData = pcFileReader.parseFile(App.WEATHER_CSV_FILE, PCDataType.Football);
    }


    @Test(expected = IllegalArgumentException.class)
    public void checkSettingWrongDataTypeByFootball() {
        pcWeatherData = pcFileReader.parseFile(App.FOOTBALL_CSV_FILE, PCDataType.Weather);
    }


    @Test
    public void checkFootballData() {
        pcFootballData = pcFileReader.parseFile(App.FOOTBALL_CSV_FILE, PCDataType.Football);
        Assert.assertEquals("Count of pcFootballData is not 20", 20, pcFootballData.size());
        Assert.assertTrue("Type of PCData in pcFootballData is not PCFootballTeamData", pcFootballData.get(0) instanceof PCFootballTeamData);
    }

    @Test
    public void checkDayWithSmallestTemperatureSpread() {
        pcWeatherData = pcFileReader.parseFile(App.WEATHER_CSV_FILE, PCDataType.Weather);
        int dayWithSmallestTemperatureSpread = WeatherDataUtils.getDayWithSmallestTemperatureSpread((ArrayList<PCWeatherDayData>) (ArrayList<?>) pcWeatherData);
        Assert.assertEquals("Wrong calculated day with smallest spread should be 7 was: " + dayWithSmallestTemperatureSpread, 14, dayWithSmallestTemperatureSpread);
    }

    @Test
    public void checkTeamWithSmallestGoalSpread() {
        pcFootballData = pcFileReader.parseFile(App.FOOTBALL_CSV_FILE, PCDataType.Football);
        String teamWithSmallestGoalSpread = FootballDataUtils.getTeamWithSmallestGoalSpread((ArrayList<PCFootballTeamData>) (ArrayList<?>) pcFootballData);
        Assert.assertEquals("Wrong calculated team with smallest goal spread should be Aston_Villa was : " + teamWithSmallestGoalSpread, "Aston_Villa", teamWithSmallestGoalSpread);
    }

    @Test
    public void checkCreateWeatherDataCorrect() {
        PCWeatherDayData dayData = WeatherDataUtils.createWeatherDataFromStringArray(new String[]{String.valueOf(1), String.valueOf(37), String.valueOf(52)});
        Assert.assertNotNull("PCWeatherDayData was not created successful", dayData);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCreateWeatherDataInCorrect() {
        PCWeatherDayData dayData = WeatherDataUtils.createWeatherDataFromStringArray(new String[]{String.valueOf(1), String.valueOf(37)});
    }


    @Test
    public void checkCreateFootballTeamDataCorrect() {
        PCFootballTeamData pcFootballTeamData = FootballDataUtils.createFootballDataFromStringArray(new String[]{"FC Bayern München", String.valueOf(80), String.valueOf(42), String.valueOf(12), String.valueOf(42), String.valueOf(22), String.valueOf(32)});
        Assert.assertNotNull("PCFootballTeamData was not created successful", pcFootballTeamData);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCreateFootballTeamDataInCorrect() {
        PCFootballTeamData dayData = FootballDataUtils.createFootballDataFromStringArray(new String[]{String.valueOf(1), "FC Bayern München"});
    }


    @Test(expected = IllegalArgumentException.class)
    public void testGetDayWithSmallestTemperatureSpreadWithNullList() {

        WeatherDataUtils.getDayWithSmallestTemperatureSpread((ArrayList<PCWeatherDayData>) (ArrayList<?>) pcWeatherData);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTeamWithSmallestGoalSpreadWithNullList() {
        FootballDataUtils.getTeamWithSmallestGoalSpread((ArrayList<PCFootballTeamData>) (ArrayList<?>) pcFootballData);
    }

}