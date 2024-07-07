package main.java.com.dnasequencing.analysis;

import main.java.com.dnasequencing.utils.LoggerUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Transcription of given DNA-Sequence into RNA-Sequence. The nucleotides Adenine transcripts into Uracil, Thymine into Adenine,
 * Guanine into Cytosine and Cytosine into Guanine.
 */

public class DNATranscriber {
    private static final Logger logger = LoggerUtils.getLogger();
    private static final Map<String, String> rnaMap = new HashMap<>();

    static {
        rnaMap.put("A", "U");
        rnaMap.put("C", "G");
        rnaMap.put("G", "C");
        rnaMap.put("T", "A");
    }

    public static String transcribeToRna(String dna) {
        StringBuilder rnaSequence = new StringBuilder();

        for (int i = 0; i < dna.length(); i++) {
            String nucleotide = dna.substring(i, i + 1);
            rnaSequence.append(rnaMap.get(nucleotide));
        }
        logger.info("Transcription performed successfully.");
        return rnaSequence.toString().trim();
    }

    public static String transcribeToRnaFromStartCodon(String dna) {
        String rnaSequence = transcribeToRna(dna);
        int startCodonIndex = rnaSequence.indexOf("AUG");
        if (startCodonIndex == -1) {
            return ""; // No start codon found
        }

        // Substring from the start codon
        rnaSequence = rnaSequence.substring(startCodonIndex);

        // Define stop codons
        List<String> stopCodons = Arrays.asList("UAA", "UAG", "UGA");
        int endIndex = -1;

        // Find the earliest stop codon in frame
        for (int i = 0; i < rnaSequence.length() - 2; i += 3) {
            String codon = rnaSequence.substring(i, i + 3);
            if (stopCodons.contains(codon)) {
                endIndex = i;
                break;
            }
        }

        if (endIndex == -1) {
            return rnaSequence; // No stop codon found
        }

        return rnaSequence.substring(0, endIndex + 3); // Include the stop codon
    }
}
