package de.exxcellent.challenge.io;

import de.exxcellent.challenge.data.PCData;
import de.exxcellent.challenge.data.PCWeatherData;

/**
 * file reader that parses a csv file into {@link PCWeatherData}
 *
 * @author Aleksander Kus(akus@stud.hs-heilbronn.de)
 */
public class PCCsvFileReader extends PCAbstractFileReader {


    @Override
    public PCData parseFile(String fileName) {
        String fileContent = readFile(fileName);
        // deleting first row
        String[] lines = new String[fileContent.length()];
        System.arraycopy(fileContent.split("\n"), 1, lines, 0, lines.length);


        for (String line : lines){

        }
        return null;
    }


}
