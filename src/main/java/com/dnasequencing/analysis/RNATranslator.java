package main.java.com.dnasequencing.analysis;

// usage of external Libraries.

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

// RNA Translator is responsible for the translation of the RNA-Sequence into a protein sequence.

public class RNATranslator {
    private static final Map<String, String> codonMap = new HashMap<>();

    // codonMap with every codon-amino acid pair. This Map is used to translate RNA codons into amino acids.
    static {
        codonMap.put("UUU", "Phenylalanine");
        codonMap.put("UUC", "Phenylalanine");
        codonMap.put("UUA", "Leucine");
        codonMap.put("UUG", "Leucine");
        codonMap.put("CUU", "Leucine");
        codonMap.put("CUC", "Leucine");
        codonMap.put("CUA", "Leucine");
        codonMap.put("CUG", "Leucine");
        codonMap.put("AUU", "Isoleucine");
        codonMap.put("AUC", "Isoleucine");
        codonMap.put("AUA", "Isoleucine");
        codonMap.put("AUG", "Methionine");
        codonMap.put("GUU", "Valine");
        codonMap.put("GUC", "Valine");
        codonMap.put("GUA", "Valine");
        codonMap.put("GUG", "Valine");
        codonMap.put("UCU", "Serine");
        codonMap.put("UCC", "Serine");
        codonMap.put("UCA", "Serine");
        codonMap.put("UCG", "Serine");
        codonMap.put("CCU", "Proline");
        codonMap.put("CCC", "Proline");
        codonMap.put("CCA", "Proline");
        codonMap.put("CCG", "Proline");
        codonMap.put("ACU", "Threonine");
        codonMap.put("ACC", "Threonine");
        codonMap.put("ACA", "Threonine");
        codonMap.put("ACG", "Threonine");
        codonMap.put("GCU", "Alanine");
        codonMap.put("GCC", "Alanine");
        codonMap.put("GCA", "Alanine");
        codonMap.put("GCG", "Alanine");
        codonMap.put("UAU", "Tyrosine");
        codonMap.put("UAC", "Tyrosine");
        codonMap.put("UAA", "Stop");
        codonMap.put("UAG", "Stop");
        codonMap.put("CAU", "Histidine");
        codonMap.put("CAC", "Histidine");
        codonMap.put("CAA", "Glutamine");
        codonMap.put("CAG", "Glutamine");
        codonMap.put("AAU", "Asparagine");
        codonMap.put("AAC", "Asparagine");
        codonMap.put("AAA", "Lysine");
        codonMap.put("AAG", "Lysine");
        codonMap.put("GAU", "Aspartic Acid");
        codonMap.put("GAC", "Aspartic Acid");
        codonMap.put("GAA", "Glutamic Acid");
        codonMap.put("GAG", "Glutamic Acid");
        codonMap.put("UGU", "Cysteine");
        codonMap.put("UGC", "Cysteine");
        codonMap.put("UGA", "Stop");
        codonMap.put("UGG", "Tryptophan");
        codonMap.put("CGU", "Arginine");
        codonMap.put("CGC", "Arginine");
        codonMap.put("CGA", "Arginine");
        codonMap.put("CGG", "Arginine");
        codonMap.put("AGU", "Serine");
        codonMap.put("AGC", "Serine");
        codonMap.put("AGA", "Arginine");
        codonMap.put("AGG", "Arginine");
        codonMap.put("GGU", "Glycine");
        codonMap.put("GGC", "Glycine");
        codonMap.put("GGA", "Glycine");
        codonMap.put("GGG", "Glycine");
    }

    /**
     * Main function:
     * Translation of the RNA-Sequence into a protein sequence.
     * <p>
     * Process:
     * Creating a StringBuilder to build the protein Sequence.
     * Looking for the first occurrence of the start codon "AUG" in the RNA using the indexOf() method.
     * If the codon is not found --> throw new NoSuchElementException.
     * Iterating over the RNA Sequence in steps of 3 (ech codon is 3 nucleotides long) using a for loop.
     * Extracting the 3-nucleotide sequence using the substring() method.
     * Looking up the corresponding amino acid in the codonMap using the getOrDefault().
     * If the codon is not found in the Map it returns UNKNOWN. (shouldn't happen, because of DNA-Utils but will happen if a corresponding amino-acid is missing).
     * With "STOP" as an amino-acid the loop breaks.
     * Appending the acid to the protein sequence using append() method.
     *
     * @param rnaSequence transcribed earlier in the DNATranscriber.
     * @return the Protein sequence as a string, trimming any trailing whitespace.
     */
    public static String translateToProtein(String rnaSequence) {
        StringBuilder protein = new StringBuilder();

        int startIndex = rnaSequence.indexOf("AUG");
        if (startIndex == -1) {

            throw new NoSuchElementException();
        }

        for (int i = startIndex; i < rnaSequence.length() - 2; i += 3) {
            String codon = rnaSequence.substring(i, i + 3);
            String aminoAcid = codonMap.getOrDefault(codon, "Unknown");

            if (aminoAcid.equals("Stop")) {
                break;
            }

            protein.append(aminoAcid).append(" ");
        }
        return protein.toString().trim();
    }

    /**
     * Main function:
     * Returning a copy of the codonMap instance, allowing external classes to access the codon-amino acid mapping.
     *
     * @return codonMap.
     */
    public static Map<String, String> getCodonMap() {
        return codonMap;
    }
}
