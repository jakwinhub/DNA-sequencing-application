package main.java.com.dnasequencing.utils;

// usage of own classes.

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

//usage of external libraries.

import javax.swing.*;
import java.io.File;
import java.io.IOException;

// FileLoader is responsible for loading the DNA file and creating a DNAAnalyzer instance.
public class FileLoader {
    private DNAAnalyzer analyzer;

    /**
     * Main Function:
     * Loading file and creating a DNAAnalyzer object.
     * <p>
     * Process:
     * Creates a JFileChooser to allow the user to select a file.
     * Shows an open dialog to the user.
     * If user selects a file and clicks 'open' it gets the selected file.
     * Tries to create a DNAAnalyzer object
     * If an Exception occurs during file loading, it shows and error message.
     *
     * @return null.
     */
    public DNAAnalyzer loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                analyzer = DNAAnalyzer.fromFile(selectedFile.getAbsolutePath());
                return analyzer;
            } catch (IOException | IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, "Error while loading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
    }
}