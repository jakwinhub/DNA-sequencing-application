package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

import javax.swing.*;
import java.awt.*;

public class CodonFinderPanel extends JPanel implements  StatisticsPanel {
    private final JTextArea CodonFinderTextArea;

    public CodonFinderPanel() {
        CodonFinderTextArea = new JTextArea();
        CodonFinderTextArea.setEditable(false);
        setLayout(new BorderLayout());
        add(new JScrollPane(CodonFinderTextArea), BorderLayout.CENTER);
    }
    @Override
    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {
            String codonPosition = analyzer.findCodonPosition("ATG");

            CodonFinderTextArea.setText("Codon Position for ATG: \n" + codonPosition);
        }
    }
}
