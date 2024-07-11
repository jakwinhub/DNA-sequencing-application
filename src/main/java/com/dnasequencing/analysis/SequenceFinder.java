package main.java.com.dnasequencing.analysis;

// Sequence Finder is responsible for finding the position of a specific in a given sequence.


public class SequenceFinder {
    /**
     * Process:
     * Creating a StringBuilder to build the position String.
     * Using the indexOf() method to find the first occurrence of the codon.
     * Returning -1 if codon is not found.
     * Repeating this process in a while-loop as long as the codon is found in the sequence.
     * Appending the current index to the position String.
     * Loop continues until the codon is no longer found.
     *
     * @param sequence Read out of file, translated during process.
     * @param codon given by the user through the input.
     * @return positionString trimmed of the codon.
     */
    public static String findCodonPosition(String sequence, String codon) {
        StringBuilder position = new StringBuilder();
        int index = sequence.indexOf(codon);
        while (index >= 0) {
            position.append(index).append(" ");
            index = sequence.indexOf(codon, index + 1);
        }
        return position.toString().trim();
    }
}
