package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;
import main.java.com.dnasequencing.analysis.DNANucleotideContentCalculator;
import main.java.com.dnasequencing.analysis.RNANucleotideContentCalculator;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class NucleotideStatisticsPanel extends Panel implements StatisticsPanel {
    private final JTextArea nucleotideStatisticsTextArea;

    public NucleotideStatisticsPanel() {
        nucleotideStatisticsTextArea = new JTextArea();
        nucleotideStatisticsTextArea.setEditable(false);

        JPanel nucleotideStatisticsPanel = new JPanel();

        setLayout(new BorderLayout());
        add(nucleotideStatisticsPanel, BorderLayout.NORTH);
        add(new JScrollPane(nucleotideStatisticsTextArea), BorderLayout.CENTER);
    }

    @Override
    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {
            DNANucleotideContentCalculator dnaCalculator = new DNANucleotideContentCalculator(analyzer);
            Map<Character, Double> dnaProportions = dnaCalculator.calculateNucleotideContent();

            RNANucleotideContentCalculator rnaCalculator = new RNANucleotideContentCalculator(analyzer);
            Map<Character, Double> rnaProportions = rnaCalculator.calculateNucleotideContent();

            StringBuilder displayText = new StringBuilder(" Nucleotide Proportions in DNA Sequence:\n");
            for (Map.Entry<Character, Double> entry : dnaProportions.entrySet()) {
                displayText.append(entry.getKey()).append(": ").append(String.format("%.2f", entry.getValue())).append("%\n");
            }
            displayText.append("\n Nucleotide Proportions in coding RNA Sequence:\n");
            for (Map.Entry<Character, Double> entry : rnaProportions.entrySet()) {
                displayText.append(entry.getKey()).append(": ").append(String.format("%.2f", entry.getValue())).append("%\n");
            }
            nucleotideStatisticsTextArea.setText(displayText.toString());
        }
    }
}
