package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

import javax.swing.*;
import java.awt.*;

public class DNAStatisticsPanel extends JPanel implements StatisticsPanel {
    private final JTextArea textArea;

    public DNAStatisticsPanel() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    @Override
    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {
            double cContent = analyzer.calculateCContent();
            double gContent = analyzer.calculateGContent();
            double aContent = analyzer.calculateAContent();
            double tContent = analyzer.calculateTContent();

            textArea.setText("C content: " + cContent + "%\n");
            textArea.append("G content: " + gContent + "%\n");
            textArea.append("A content: " + aContent + "%\n");
            textArea.append("T content: " + tContent + "%\n");
        }
    }
}
