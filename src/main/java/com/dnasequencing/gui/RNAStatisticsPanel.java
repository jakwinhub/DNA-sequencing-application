package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

import javax.swing.*;
import java.awt.*;

public class RNAStatisticsPanel extends JPanel implements StatisticsPanel {
    private final JTextArea rnaStatisticsTextArea;

    public RNAStatisticsPanel() {
        rnaStatisticsTextArea = new JTextArea();
        rnaStatisticsTextArea.setEditable(false);
        setLayout(new BorderLayout());
        add(new JScrollPane(rnaStatisticsTextArea), BorderLayout.CENTER);
    }

    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {
            double cContent = analyzer.calculateCContent();
            double gContent = analyzer.calculateGContent();
            double aContent = analyzer.calculateAContent();
            double tContent = analyzer.calculateTContent();

            rnaStatisticsTextArea.setText("G content: " + cContent + "%\n");
            rnaStatisticsTextArea.append("C content: " + gContent + "%\n");
            rnaStatisticsTextArea.append("T content: " + aContent + "%\n");
            rnaStatisticsTextArea.append("U content: " + tContent + "%\n");
        }
    }
}