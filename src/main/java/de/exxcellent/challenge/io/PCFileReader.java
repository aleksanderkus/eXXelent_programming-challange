package de.exxcellent.challenge.io;

import de.exxcellent.challenge.data.PCData;

import java.io.IOException;

/**
 * interface for reading files
 *
 * @author Aleksander Kus(akus@stud.hs-heilbronn.de)
 */
public interface PCFileReader {


    PCData parseFile(String fileName) throws IOException;

}
