package de.exxcellent.challenge.io;

import de.exxcellent.challenge.data.PCData;
import de.exxcellent.challenge.data.PCDataType;

import java.io.IOException;
import java.util.List;

/**
 * interface for reading files
 *
 * @author Aleksander Kus(akus@stud.hs-heilbronn.de)
 */
public interface PCFileReader {

    /**
     * @param fileName the file name of the wanted file to be parsed, must be readable and UTF-8
     * @param type     the type of the incoming data must be one of {@link PCDataType} and not <code>null</code>
     * @return the data holder class that implements {@link PCData}
     */
    List<PCData> parseFile(String fileName, PCDataType type);


}
