package main.java.com.dnasequencing.analysis;

import main.java.com.dnasequencing.utils.DNAUtils;
import main.java.com.dnasequencing.utils.FileUtils;

import java.io.IOException;

/**
 * Main class in which the coordination of the DNA analysis should take place.
 */

public class DNAAnalyzer {
    private final String dnaSequence;
    private String rnaSequence;

    public DNAAnalyzer(String dnaSequence) {
        this.dnaSequence = dnaSequence;
        this.rnaSequence = DNATranscriber.transcribeToRna(dnaSequence);
    }

    public static DNAAnalyzer fromFile(String filePath) throws IOException {
        String sequence = FileUtils.readFileAsString(filePath);
        if (DNAUtils.isValidDNA(sequence)) {
            return new DNAAnalyzer(sequence);
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

    public String transcribeToRna(){
        return DNATranscriber.transcribeToRna(dnaSequence);
    }

    public String getRnaSequence() {
        return rnaSequence;
    }

    public String translateToProtein() {
        return RNATranslator.translateToProtein(rnaSequence);
    }
}
