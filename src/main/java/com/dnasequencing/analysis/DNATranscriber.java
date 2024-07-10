package main.java.com.dnasequencing.analysis;

// usage of own classes.

import main.java.com.dnasequencing.utils.LoggerUtils;

// usage of external Libraries.

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

// DNATranscriber is responsible for transcribing a given DNA sequence into an RNA sequence.

public class DNATranscriber {
    private static final Logger logger = LoggerUtils.getLogger();
    private static final Map<String, String> rnaMap = new HashMap<>();

    // Mapping DNA nucleotides into corresponding RNA nucleotides.
    static {
        rnaMap.put("A", "U");
        rnaMap.put("C", "G");
        rnaMap.put("G", "C");
        rnaMap.put("T", "A");
    }

    /**
     * Main function:
     * Transcription of DNA into RNA.
     * <p>
     * Process:
     * Creating String builder to build RNA-Sequence.
     * Iteration through DNA-Sequence for each nucleotide.
     * Looking up the corresponding RNA nucleotide and appending to StringBuilder.
     * Log info message if transcription was successful.
     *
     * @param dna Sequence out of chosen file as String.
     * @return RNA Sequence as String.
     */
    public static String transcribeToRna(String dna) {
        StringBuilder rnaSequence = new StringBuilder();

        for (int i = 0; i < dna.length(); i++) {
            String nucleotide = dna.substring(i, i + 1);
            rnaSequence.append(rnaMap.get(nucleotide));
        }
        logger.info("Transcription performed successfully.");
        return rnaSequence.toString().trim();
    }

    /**
     * Main function:
     * Trimming of transcribed RNA start-codon to stop-codon.
     * <p>
     * Process:
     * Calling transcribeToRna Method to transcribe DNA into RNA.
     * Searching for index of "AUG". If not found --> return of empty String.
     * Substrings RNA-Sequence from the Start-codon on.
     * Defining list of stop-codons.
     * Looking up the earliest stop codon in frame of 3 nucleotides in the RNA-Sequence. If not found --> return whole Sequence.
     * If stop codon is found. --> return of RNA Sequence schema: start-rna-stop
     *
     * @param dna Sequence out of chosen file as String.
     * @return RNA Sequence from start-codon to stop-codon.
     */
    public static String transcribeToRnaFromStartCodon(String dna) {
        String rnaSequence = transcribeToRna(dna);
        int startCodonIndex = rnaSequence.indexOf("AUG");
        if (startCodonIndex == -1) {
            return "";
        }

        rnaSequence = rnaSequence.substring(startCodonIndex);

        List<String> stopCodons = Arrays.asList("UAA", "UAG", "UGA");
        int endIndex = -1;

        for (int i = 0; i < rnaSequence.length() - 2; i += 3) {
            String codon = rnaSequence.substring(i, i + 3);
            if (stopCodons.contains(codon)) {
                endIndex = i;
                break;
            }
        }

        if (endIndex == -1) {
            return rnaSequence;
        }

        return rnaSequence.substring(0, endIndex + 3);
    }
}
