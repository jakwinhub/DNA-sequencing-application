package main.java.com.dnasequencing.analysis;

// usage of external Libraries.

import java.util.HashMap;
import java.util.Map;

// RNANucleotideContentCalculator is responsible for the calculation of proportion of each nucleotide (A, U, C and G)
// in a given RNA-Sequence.

public class RNANucleotideContentCalculator {
    private final DNAAnalyzer analyzer;

    /**
     * Constructor of the class, taking an instance of the DNAAnalyzer.
     *
     * @param analyzer initialized.
     */
    public RNANucleotideContentCalculator(DNAAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    /**
     * Main function:
     * Calculation of the proportion for each nucleotide in the RNA-Sequence. In contrast to the DNA Content calculation
     * the nucleotides change.
     * <p>
     * Process:
     * Loading the DNA Sequence from the Analyzer using the getDnaSequence() method in the Analyzer.
     * Transcribing the DNA into RNA-Sequence using the transcribeToRnaFromStartCodon() out of the DNATranscriber.
     * Initializing four different integer variables to count the occurrences of each nucleotide.
     * Iterating over the characters of the RNA using a for-loop.
     * Incrementation of the corresponding count variables is realized with a switch statement.
     * Calculation if the total number of nucleotides using length() method.
     * Creating a new HashMap for storage of nucleotide proportion.
     * Calculation the proportion of each nucleotide by dividing count by total amount of nucleotides in DNA-Sequence and multiplying by 100 --> percentage.
     * Proportion getting put into HashMap as Key-value.
     *
     * @return HashMap containing nucleotide proportions.
     */
    public Map<Character, Double> calculateNucleotideContent() {
        String dnaSequence = analyzer.getDnaSequence();
        String rnaSequence = DNATranscriber.transcribeToRnaFromStartCodon(dnaSequence);

        int aCount = 0;
        int uCount = 0;
        int cCount = 0;
        int gCount = 0;

        for (char nucleotide : rnaSequence.toCharArray()) {
            switch (nucleotide) {
                case 'A':
                    aCount++;
                    break;
                case 'U':
                    uCount++;
                    break;
                case 'C':
                    cCount++;
                    break;
                case 'G':
                    gCount++;
                    break;
                default:
                    // This should not happen in a valid RNA sequence
                    break;
            }
        }

        int totalNucleotides = rnaSequence.length();
        Map<Character, Double> nucleotideProportions = new HashMap<>();
        nucleotideProportions.put('A', (aCount / (double) totalNucleotides) * 100);
        nucleotideProportions.put('U', (uCount / (double) totalNucleotides) * 100);
        nucleotideProportions.put('C', (cCount / (double) totalNucleotides) * 100);
        nucleotideProportions.put('G', (gCount / (double) totalNucleotides) * 100);

        return nucleotideProportions;
    }
}
