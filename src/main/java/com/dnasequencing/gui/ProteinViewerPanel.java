package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

import javax.swing.*;
import java.awt.*;

public class ProteinViewerPanel extends JPanel implements StatisticsPanel {
    private final JTextArea proteinViewerTextArea;

    public ProteinViewerPanel() {
        proteinViewerTextArea = new JTextArea();
        proteinViewerTextArea.setEditable(false);
        setLayout(new BorderLayout());
        add(new JScrollPane(proteinViewerTextArea), BorderLayout.CENTER);
    }

    @Override
    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {
            String proteinSequence = analyzer.translateToProtein();
            proteinViewerTextArea.setText("Protein Sequence: \n" + proteinSequence + "\n");
        }
    }
}
