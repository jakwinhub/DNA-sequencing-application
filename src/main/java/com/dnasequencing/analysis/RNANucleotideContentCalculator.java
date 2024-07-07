package main.java.com.dnasequencing.analysis;

import java.util.HashMap;
import java.util.Map;

public class RNANucleotideContentCalculator {
    private final DNAAnalyzer analyzer;

    public RNANucleotideContentCalculator(DNAAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

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
