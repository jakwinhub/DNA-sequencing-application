package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

import javax.swing.*;
import java.awt.*;

public class DNAStatisticsPanel extends JPanel implements StatisticsPanel {
    private final JTextArea dnaStatisticsTextArea;

    public DNAStatisticsPanel() {
        dnaStatisticsTextArea = new JTextArea();
        dnaStatisticsTextArea.setEditable(false);
        setLayout(new BorderLayout());
        add(new JScrollPane(dnaStatisticsTextArea), BorderLayout.CENTER);
    }

    @Override
    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {
            double cContent = analyzer.calculateCContent();
            double gContent = analyzer.calculateGContent();
            double aContent = analyzer.calculateAContent();
            double tContent = analyzer.calculateTContent();

            dnaStatisticsTextArea.setText("C content: " + cContent + "%\n");
            dnaStatisticsTextArea.append("G content: " + gContent + "%\n");
            dnaStatisticsTextArea.append("A content: " + aContent + "%\n");
            dnaStatisticsTextArea.append("T content: " + tContent + "%\n");
        }
    }
}
