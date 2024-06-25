package main.java.com.dnasequencing.utils;

/**
 * Class with general auxiliary functions for DNA analysis.
 * Checks whether the content of the entered file contains only the nucleotide bases.
 */

public class DNAUtils {
    public static boolean isValidDNA(String sequence) {
        return sequence != null && sequence.matches("[ATCG]+");
    }
}
