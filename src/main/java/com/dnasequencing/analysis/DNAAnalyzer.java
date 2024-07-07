package main.java.com.dnasequencing.analysis;

import main.java.com.dnasequencing.utils.DNAUtils;
import main.java.com.dnasequencing.utils.FileUtils;
import main.java.com.dnasequencing.utils.LoggerUtils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class in which the coordination of the DNA analysis should take place.
 */

public class DNAAnalyzer {
    private static final Logger logger = LoggerUtils.getLogger();
    private final String dnaSequence;
    private final String rnaSequence;

    public DNAAnalyzer(String dnaSequence) {
        this.dnaSequence = dnaSequence;
        this.rnaSequence = DNATranscriber.transcribeToRna(dnaSequence);
    }

    public static DNAAnalyzer fromFile(String filePath) throws IOException {
        String sequence = FileUtils.readFileAsString(filePath);
        if (DNAUtils.isValidDNA(sequence)) {
            logger.info("DNA sequence: " + sequence);
            return new DNAAnalyzer(sequence);
        } else {
            logger.log(Level.SEVERE, "Invalid DNA sequence: " + sequence);
            throw new IllegalArgumentException("Invalid DNA sequence your selected file! ");
        }
    }

    public String findCodonPosition(String codon) {
        return SequenceFinder.findCodonPosition(dnaSequence, codon);
    }

    public String transcribeToRnaFromStartCodon() {
        return DNATranscriber.transcribeToRna(dnaSequence);
    }

    public String translateToProtein() {
        return RNATranslator.translateToProtein(rnaSequence);
    }

    public String getDnaSequence() {
        return dnaSequence;
    }
}
