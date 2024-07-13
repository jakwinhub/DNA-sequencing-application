package main.java.com.dnasequencing.gui;

// usage of own classes.

import main.java.com.dnasequencing.analysis.DNAAnalyzer;
import main.java.com.dnasequencing.analysis.DNANucleotideContentCalculator;
import main.java.com.dnasequencing.analysis.RNANucleotideContentCalculator;

// usage of external libraries.

import javax.swing.*;
import java.awt.*;
import java.util.Map;

// NucleotideStatisticsPanel is a GUI component that allows users to view the statistics of the nucleotides in the DNA.
// Implementation of StatisticsPanel and ActionListener.

public class NucleotideStatisticsPanel extends Panel implements StatisticsPanel {
    private final JTextArea nucleotideStatisticsTextArea;

    // Formatting of the NucleotideStatisticsPanel

    public NucleotideStatisticsPanel() {
        nucleotideStatisticsTextArea = new JTextArea();
        nucleotideStatisticsTextArea.setEditable(false);

        JPanel nucleotideStatisticsPanel = new JPanel();

        setLayout(new BorderLayout());
        add(nucleotideStatisticsPanel, BorderLayout.NORTH);
        add(new JScrollPane(nucleotideStatisticsTextArea), BorderLayout.CENTER);
    }

    /**
     * Main Function:
     * Updating the GUI with statistics when the DNAAnalyzer instance is provided.
     * <p>
     * Process:
     * Creating an instance of the DNANucleotideContentCalculator and RNANucleotideContentCalculator.
     * Calls the calculateNucleotideContent() to get the nucleotide proportions as a Map.
     * Builds a String to display the nucleotides proportions using a StringBuilder.
     * Sets the text of the nucleotideStatisticsTextArea with the display String.
     *
     *
     * @param analyzer Analyzer instance.
     */
    @Override
    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {
            DNANucleotideContentCalculator dnaCalculator = new DNANucleotideContentCalculator(analyzer);
            Map<Character, Double> dnaProportions = dnaCalculator.calculateNucleotideContent();

            RNANucleotideContentCalculator rnaCalculator = new RNANucleotideContentCalculator(analyzer);
            Map<Character, Double> rnaProportions = rnaCalculator.calculateNucleotideContent();

            StringBuilder displayText = new StringBuilder(" Nucleotide Proportions in DNA Sequence:\n");
            for (Map.Entry<Character, Double> entry : dnaProportions.entrySet()) {
                displayText.append("   ").append(entry.getKey()).append(": ").append(String.format("%.2f", entry.getValue())).append("%\n");
            }
            displayText.append("\n Nucleotide Proportions in coding RNA Sequence:\n");
            for (Map.Entry<Character, Double> entry : rnaProportions.entrySet()) {
                displayText.append("   ").append(entry.getKey()).append(": ").append(String.format("%.2f", entry.getValue())).append("%\n");
            }
            nucleotideStatisticsTextArea.setText(displayText.toString());
        }
    }
}
