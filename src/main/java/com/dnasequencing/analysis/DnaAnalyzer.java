package main.java.com.dnasequencing.analysis;

import main.java.com.dnasequencing.utils.DnaUtils;
import main.java.com.dnasequencing.utils.FileUtils;

import java.io.IOException;

/**
 * Main class in which the coordination of the DNA analysis should take place.
 */

public class DnaAnalyzer {
    private String dnaSequence;

    public DnaAnalyzer(String dnaSequence) {
        this.dnaSequence = dnaSequence;
    }

    public static DnaAnalyzer fromFile(String filePath) throws IOException {
        String sequence = FileUtils.readFileAsString(filePath);
        if (DnaUtils.isValidDNA(sequence)) {
            return new DnaAnalyzer(sequence);
        } else {
            throw new IllegalArgumentException("Invalid DNA sequence your selected file! ");
        }
    }


    public double calculateCContent() {
        return ContentCalculator.calculateCContent(dnaSequence);
    }

    public double calculateGContent() {
        return ContentCalculator.calculateGContent(dnaSequence);
    }

    public double calculateAContent() {
        return ContentCalculator.calculateAContent(dnaSequence);
    }

    public double calculateTContent() {
        return ContentCalculator.calculateTContent(dnaSequence);
    }

    public String findCodonPosition(String codon) {
        return SequenceFinder.findCodonPosition(dnaSequence, codon);
    }

}
