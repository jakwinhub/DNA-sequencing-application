package main.java.com.dnasequencing.analysis;

import java.util.HashMap;
import java.util.Map;

/**
 * Class in which the proportion of guanine and cytosine in the genome is to be calculated.
 * Addition: Proportion of Adenine and Thymine is also calculated, following the same schema as CG-Calculation.
 */

public class DNANucleotideContentCalculator {
    private final DNAAnalyzer analyzer;

    public DNANucleotideContentCalculator(DNAAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

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