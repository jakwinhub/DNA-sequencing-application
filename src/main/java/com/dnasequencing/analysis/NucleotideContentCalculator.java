package main.java.com.dnasequencing.analysis;

/**
 * Class in which the proportion of guanine and cytosine in the genome is to be calculated.
 * Addition: Proportion of Adenine and Thymine is also calculated, following the same schema as CG-Calculation.
 */

public class NucleotideContentCalculator {

    public static double calculateCContent(String sequence) {
        int cCount = 0;
        for (char nucleotide : sequence.toCharArray()) {
            if (nucleotide == 'C') {
                cCount++;
            }
        }
        return (cCount / (double) sequence.length() * 100);
    }

    public static double calculateGContent(String sequence) {
        int gCount = 0;
        for (char nucleotide : sequence.toCharArray()) {
            if (nucleotide == 'G') {
                gCount++;
            }
        }
        return (gCount / (double) sequence.length() * 100);
    }

    public static double calculateAContent(String sequence) {
        int aCount = 0;
        for (char nucleotide : sequence.toCharArray()) {
            if (nucleotide == 'A') {
                aCount++;
            }
        }
        return (aCount / (double) sequence.length() * 100);
    }

    public static double calculateTContent(String sequence) {
        int tCount = 0;
        for (char nucleotide : sequence.toCharArray()) {
            if (nucleotide == 'T') {
                tCount++;
            }
        }
        return (tCount / (double) sequence.length() * 100);
    }
}
