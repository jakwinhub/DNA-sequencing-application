package main.java.com.dnasequencing.analysis;

import java.util.HashMap;
import java.util.Map;

/**
 * Class in which the translation of DNA is realized.
 */

public class DnaTranslation {
    private static final Map<String, String> codonMap = new HashMap<>();

    static {
        codonMap.put("UUU", "Phenylalanine"); codonMap.put("UUC", "Phenylalanine");
        codonMap.put("UUA", "Leucine"); codonMap.put("UUG", "Leucine");
        codonMap.put("CUU", "Leucine"); codonMap.put("CUC", "Leucine");
        codonMap.put("CUA", "Leucine"); codonMap.put("CUG", "Leucine");
        codonMap.put("AUU", "Isoleucine"); codonMap.put("AUC", "Isoleucine");
        codonMap.put("AUA", "Isoleucine"); codonMap.put("AUG", "Methionine");
        codonMap.put("GUU", "Valine"); codonMap.put("GUC", "Valine");
        codonMap.put("GUA", "Valine"); codonMap.put("GUG", "Valine");
        codonMap.put("UCU", "Serine"); codonMap.put("UCC", "Serine");
        codonMap.put("UCA", "Serine"); codonMap.put("UCG", "Serine");
        codonMap.put("CCU", "Proline"); codonMap.put("CCC", "Proline");
        codonMap.put("CCA", "Proline"); codonMap.put("CCG", "Proline");
        codonMap.put("ACU", "Threonine"); codonMap.put("ACC", "Threonine");
        codonMap.put("ACA", "Threonine"); codonMap.put("ACG", "Threonine");
        codonMap.put("GCU", "Alanine"); codonMap.put("GCC", "Alanine");
        codonMap.put("GCA", "Alanine"); codonMap.put("GCG", "Alanine");
        codonMap.put("UAU", "Tyrosine"); codonMap.put("UAC", "Tyrosine");
        codonMap.put("UAA", "Stop"); codonMap.put("UAG", "Stop");
        codonMap.put("CAU", "Histidine"); codonMap.put("CAC", "Histidine");
        codonMap.put("CAA", "Glutamine"); codonMap.put("CAG", "Glutamine");
        codonMap.put("AAU", "Asparagine"); codonMap.put("AAC", "Asparagine");
        codonMap.put("AAA", "Lysine"); codonMap.put("AAG", "Lysine");
        codonMap.put("GAU", "Aspartic Acid"); codonMap.put("GAC", "Aspartic Acid");
        codonMap.put("GAA", "Glutamic Acid"); codonMap.put("GAG", "Glutamic Acid");
        codonMap.put("UGU", "Cysteine"); codonMap.put("UGC", "Cysteine");
        codonMap.put("UGA", "Stop"); codonMap.put("UGG", "Tryptophan");
        codonMap.put("CGU", "Arginine"); codonMap.put("CGC", "Arginine");
        codonMap.put("CGA", "Arginine"); codonMap.put("CGG", "Arginine");
        codonMap.put("AGU", "Serine"); codonMap.put("AGC", "Serine");
        codonMap.put("AGA", "Arginine"); codonMap.put("AGG", "Arginine");
        codonMap.put("GGU", "Glycine"); codonMap.put("GGC", "Glycine");
        codonMap.put("GGA", "Glycine"); codonMap.put("GGG", "Glycine");
    }

    public static String translateToProtein(String sequence) {
        StringBuilder protein = new StringBuilder();
        for (int i = 0; i < sequence.length() - 2; i += 3) {
            String codon = sequence.substring(i, i + 3);
            protein.append(codonMap.getOrDefault(codon, "Unknown")).append(" ");
        }
        return protein.toString().trim();
    }
}
