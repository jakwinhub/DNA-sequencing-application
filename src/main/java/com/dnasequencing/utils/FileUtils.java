package main.java.com.dnasequencing.utils;

// usage of external libraries.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// FileUtils provides a utility method for reading the file as a String.
public class FileUtils {
    /**
     * Main function:
     * Reads a file as String and returns the content.
     * <p>
     * Process:
     * Takes a string parameter 'filepath' representing the path of the file to be read.
     * Uses Files.readAllBytes() to read the entire file into a byte array.
     * Converts the byte array to a String.
     * Removes any whitespaces using replaceAll(\\s).
     * Converts the String to upperCase.
     *
     * @param filePath representing the path of the chosen file.
     * @return resulted String.
     * @throws IOException if error occurs while reading the file.
     */
    public static String readFileAsString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath))).replaceAll("\\s", "").toUpperCase();
    }
}