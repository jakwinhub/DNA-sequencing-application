package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

import javax.swing.*;
import java.awt.*;

public class ProteinStatisticsPanel extends JPanel implements StatisticsPanel {
    private final JTextArea proteinStatisticsTextArea;

    public ProteinStatisticsPanel() {
        proteinStatisticsTextArea = new JTextArea();
        proteinStatisticsTextArea.setEditable(false);
        setLayout(new BorderLayout());
        add(new JScrollPane(proteinStatisticsTextArea), BorderLayout.CENTER);
    }

    @Override
    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {

        }
    }
}
