package main.java.com.dnasequencing.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *  Class with general auxiliary functions for DNA analysis.
 */

public class FileUtils {
    public static String readFileAsString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath))).replaceAll("\\s", "").toUpperCase();
    }
}