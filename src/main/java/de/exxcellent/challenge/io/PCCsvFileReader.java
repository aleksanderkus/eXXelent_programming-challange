package de.exxcellent.challenge.io;

import com.sun.deploy.util.StringUtils;
import de.exxcellent.challenge.data.PCData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * file reader that parses a csv file into {@link de.exxcellent.challenge.data.PCCsvData}
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
