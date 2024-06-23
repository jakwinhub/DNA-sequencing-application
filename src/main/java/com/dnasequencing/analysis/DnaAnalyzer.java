package main.java.com.dnasequencing.analysis;

import main.java.com.dnasequencing.utils.DnaUtils;
import main.java.com.dnasequencing.utils.FileUtils;

import java.io.IOException;
import java.nio.file.Files;

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


    public double calculateCGContent() {
        return ContentCalculator.calculateCGContent(dnaSequence);
    }

    public double calculateATContent() {
        return ContentCalculator.calculateATContent(dnaSequence);
    }

    public String findCodonPosition(String codon) {
        return SequenceFinder.findCodonPosition(dnaSequence, codon);
    }

}
