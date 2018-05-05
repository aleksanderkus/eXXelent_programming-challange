package de.exxcellent.challenge.io;


import de.exxcellent.challenge.data.PCData;
import de.exxcellent.challenge.data.PCDataType;
import de.exxcellent.challenge.data.PCWeatherDayData;
import de.exxcellent.challenge.util.FootballDataUtils;
import de.exxcellent.challenge.util.WeatherDataUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * file reader that parses a csv file into {@link PCWeatherDayData}
 *
 * @author Aleksander Kus(akus@stud.hs-heilbronn.de)
 */
public class PCCsvFileReader extends PCAbstractFileReader {

    private static final String LINE_SEPARATOR = "\n";
    private static final String VALUE_SEPARATOR = ",";


    /**
     * {@inheritDoc}
     */
    @Override
    public List<PCData> parseFile(String fileName, PCDataType type) {
        String fileContent = readFile(fileName);
        // deleting first row
        String[] rawLines = fileContent.split(LINE_SEPARATOR);
        String[] lines = new String[rawLines.length - 1];
        System.arraycopy(rawLines, 1, lines, 0, lines.length);
        List<PCData> pcDataList = new ArrayList<>();
        switch (type) {
            case Weather:
                for (String line : lines) {
                    String[] weatherData = line.split(VALUE_SEPARATOR);
                    pcDataList.add(WeatherDataUtils.createWeatherDataFromStringArray(weatherData));
                }
                break;
            case Football:
                for (String line : lines) {
                    String[] footballData = line.split(VALUE_SEPARATOR);
                    pcDataList.add(FootballDataUtils.createFootballDataFromStringArray(footballData));
                }
                break;
            default:
                throw new IllegalArgumentException("unknown data type: " + type);
        }
        return pcDataList;
    }

}
