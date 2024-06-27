package main.java.com.dnasequencing.utils;


import main.java.com.dnasequencing.analysis.DNAAnalyzer;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class FileLoader {
    private DNAAnalyzer analyzer;

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