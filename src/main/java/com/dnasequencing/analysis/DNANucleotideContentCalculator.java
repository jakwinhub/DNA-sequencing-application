package main.java.com.dnasequencing.analysis;

// usage of external Libraries.

import java.util.HashMap;
import java.util.Map;

// DNANucleotideContentCalculator is responsible for the Calculation of the proportion
// for each nucleotide (Adenine, Thymine, Cytosine, and Guanine) in a DNA sequence.

public class DNANucleotideContentCalculator {
    private final DNAAnalyzer analyzer;

    /**
     * Initializing the DNAAnalyzer as analyzer.
     *
     * @param analyzer initialized as DNAAnalyzer.
     */
    public DNANucleotideContentCalculator(DNAAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    /**
     * Main function:
     * Calculating the proportion of each nucleotide in the DNA Sequence.
     * <p>
     * Process:
     * Retrieving DNA-Sequence from DNAAnalyzer.
     * Initializing counter for each nucleotide.
     * Iterating through DNA-Sequence and incrementing the corresponding counter for each nucleotide.
     * Calculation the number of nucleotides in the DNASequence String.
     * Creating a Hash-Map to store the proportion of each nucleotide.
     * Calculation the proportion of each nucleotide by dividing count by total amount of nucleotides in DNA-Sequence and multiplying by 100 --> percentage.
     * Proportion getting put into HashMap as Key-value.
     * <p>
     * Usage of switch-case:
     * Handling of each nucleotide character.
     * Default for unusual characters. --> shouldn't be in usage due to DNA-Utils requirements.
     *
     * @return nucleotideProportions as map with result of content Calculation.
     */
    public Map<Character, Double> calculateNucleotideContent() {
        String dnaSequence = analyzer.getDnaSequence();

        int aCount = 0;
        int uCount = 0;
        int cCount = 0;
        int gCount = 0;

        for (char nucleotide : dnaSequence.toCharArray()) {
            switch (nucleotide) {
                case 'A':
                    aCount++;
                    break;
                case 'T':
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

        int totalNucleotides = dnaSequence.length();
        Map<Character, Double> nucleotideProportions = new HashMap<>();
        nucleotideProportions.put('A', (aCount / (double) totalNucleotides) * 100);
        nucleotideProportions.put('T', (uCount / (double) totalNucleotides) * 100);
        nucleotideProportions.put('C', (cCount / (double) totalNucleotides) * 100);
        nucleotideProportions.put('G', (gCount / (double) totalNucleotides) * 100);

        return nucleotideProportions;
    }
}