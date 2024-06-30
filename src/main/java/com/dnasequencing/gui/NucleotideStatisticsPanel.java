package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

import javax.swing.*;
import java.awt.*;

public class NucleotideStatisticsPanel extends Panel implements StatisticsPanel {
    private final JTextArea nucleotideStatisticsTextArea;

    public NucleotideStatisticsPanel() {
        nucleotideStatisticsTextArea = new JTextArea();
        nucleotideStatisticsTextArea.setEditable(false);
        setLayout(new BorderLayout());
        add(new JScrollPane(nucleotideStatisticsTextArea), BorderLayout.CENTER);
    }

    @Override
    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {
            double cContent = analyzer.calculateCContent();
            double gContent = analyzer.calculateGContent();
            double aContent = analyzer.calculateAContent();
            double tContent = analyzer.calculateTContent();

            nucleotideStatisticsTextArea.setText("\n *Statistics for Nucleotides in DNA* \n");
            nucleotideStatisticsTextArea.append("C content: " + cContent + "%\n");
            nucleotideStatisticsTextArea.append("G content: " + gContent + "%\n");
            nucleotideStatisticsTextArea.append("A content: " + aContent + "%\n");
            nucleotideStatisticsTextArea.append("T content: " + tContent + "%\n");
            nucleotideStatisticsTextArea.append("\n *Statistics for Nucleotides in RNA* \n");
            nucleotideStatisticsTextArea.append("T content: " + tContent + "%\n");
            nucleotideStatisticsTextArea.append("T content: " + tContent + "%\n");
            nucleotideStatisticsTextArea.append("T content: " + tContent + "%\n");
            nucleotideStatisticsTextArea.append("T content: " + tContent + "%\n");

        }
    }
}
