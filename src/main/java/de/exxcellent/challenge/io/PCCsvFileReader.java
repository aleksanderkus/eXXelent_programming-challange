package de.exxcellent.challenge.io;


import de.exxcellent.challenge.data.PCData;
import de.exxcellent.challenge.data.PCDataType;
import de.exxcellent.challenge.data.PCWeatherData;

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
        String[] lines = new String[fileContent.length()];
        System.arraycopy(fileContent.split("\n"), 1, lines, 0, lines.length);

        switch (type) {
            case Weather:
                return null;
            case Football:
                return null;
            default:
                throw new IllegalArgumentException("unknown data type: " + type);
        }

        for (String line : lines) {
            String[] weaterdata = line.split(",");
            try {
                int dayOfMonth = Integer.parseInt(weaterdata[0]);
                int maxTemp = Integer.parseInt(weaterdata[1]);
                int minTemt = Integer.parseInt(weaterdata[2]);
            } catch (NumberFormatException e) {
                System.err.println("wrong formatted csv file from type: ");
                e.fillInStackTrace();
            }
        }
        return null;
    }


    enum Type {
        Weater, Football
    }

}
