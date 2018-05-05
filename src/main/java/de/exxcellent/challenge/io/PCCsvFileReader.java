package de.exxcellent.challenge.io;

import de.exxcellent.challenge.data.PCData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * file reader that parses a csv file into {@link de.exxcellent.challenge.data.PCCsvData}
 *
 * @author Aleksander Kus(akus@stud.hs-heilbronn.de)
 */
public class PCCsvFileReader implements PCFileReader {


    @Override
    public PCData parseFile(String fileName) {

        return null;
    }

    /***/
    private String readFile(String fileName) {
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return stringBuilder.toString();
    }
}
