package main.java.com.dnasequencing.analysis;

/**
 *  Class in which the proportion of guanine and cytosine in the genome is to be calculated.
 *  Addition: Proportion of Adenine and Thymine is also calculated, following the same schema as CG-Calculation.
 */

public class ContentCalculator {

    public static double calculateCGContent(String sequence) {
        int cgCount = 0;
        for (char nucleotide : sequence.toCharArray()) {
            if (nucleotide == 'C' || nucleotide == 'G') {
                cgCount++;
            }
        }
        return (cgCount / (double) sequence.length() * 100);
    }

    public static double calculateATContent(String sequence) {
        int atCount = 0;
        for (char nucleotide : sequence.toCharArray()) {
            if (nucleotide == 'A' || nucleotide == 'T') {
                atCount++;
            }
        }
        return (atCount / (double) sequence.length() * 100);
    }
}
