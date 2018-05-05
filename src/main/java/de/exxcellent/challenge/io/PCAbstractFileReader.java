package de.exxcellent.challenge.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * file reader that provide a function for reading file contents
 *
 * @author Aleksander Kus(akus@stud.hs-heilbronn.de)
 */
public abstract class PCAbstractFileReader implements PCFileReader {


    /**
     * reading a file content and puts the hole content into a string
     *
     * @param fileName the file name of the wanted file may not be <code>null</code> the file should be readable and UTF-8
     * @return the file content as {@link String}
     */
    protected String readFile(String fileName) {
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
