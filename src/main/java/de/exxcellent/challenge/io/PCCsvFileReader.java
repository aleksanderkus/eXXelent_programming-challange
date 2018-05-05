package de.exxcellent.challenge.io;


import de.exxcellent.challenge.data.PCData;
import de.exxcellent.challenge.data.PCDataType;
import de.exxcellent.challenge.data.PCWeatherData;
import de.exxcellent.challenge.util.WeatherDataUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * file reader that parses a csv file into {@link PCWeatherData}
 *
 * @author Aleksander Kus(akus@stud.hs-heilbronn.de)
 */
public class PCCsvFileReader extends PCAbstractFileReader {


    @Override
    public List<PCData> parseFile(String fileName, PCDataType type) {
        String fileContent = readFile(fileName);
        // deleting first row
        String[] rawLines = fileContent.split("\n");
        String[] lines = new String[rawLines.length - 1];
        System.arraycopy(rawLines, 1, lines, 0, lines.length);
        List<PCData> pcDataList = new ArrayList<>();
        switch (type) {
            case Weather:
                for (String line : lines) {
                    String[] weatherData = line.split(",");
                    pcDataList.add(WeatherDataUtils.createWeatherDataFromStringArray(weatherData));
                }
                break;
            case Football:

            default:
                throw new IllegalArgumentException("unknown data type: " + type);
        }
        return pcDataList;
    }

}
