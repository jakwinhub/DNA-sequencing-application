package main.java.com.dnasequencing.analysis;

import java.util.HashMap;
import java.util.Map;

/**
 * Transcription of given DNA-Sequence into RNA-Sequence. The nucleotides Adenine transcripts into Uracil, Thymine into Adenine,
 * Guanine into Cytosine and Cytosine into Guanine.
 */

public class DNATranscriber {
    private static final Map<String, String> rnaMap = new HashMap<>();

    static {
        rnaMap.put("A", "U");
        rnaMap.put("C", "G");
        rnaMap.put("G", "C");
        rnaMap.put("T", "A");
    }

    public static String transcribeToRna(String dna) {
        StringBuilder rnaSequence = new StringBuilder();

        for (int i = 0; i < dna.length(); i++) {
            String codon = dna.substring(i, i + 1);
            rnaSequence.append(rnaMap.get(codon));
        }
        return rnaSequence.toString().trim();
    }
}
