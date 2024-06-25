package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

import javax.swing.*;
import java.awt.*;

public class ProteinStatisticsPanel extends JPanel implements StatisticsPanel {
    private final JTextArea textArea;

    public ProteinStatisticsPanel() {
        textArea = new JTextArea();
        textArea.setEditable(false);
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    @Override
    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {
            String proteinSequence = analyzer.translateToProtein();
            textArea.setText("Protein Sequence: " + proteinSequence + "\n");
        }
    }
}
