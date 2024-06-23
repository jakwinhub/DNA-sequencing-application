package main.java.com.dnasequencing.analysis;

/**
 *  Class in which specific sequences are queried and the position of these is returned.
 *  The specific sequence we are looking for is called "codon".
 */

public class SequenceFinder {
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
