package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RNAViewerPanel extends JPanel implements StatisticsPanel, ActionListener {
    private final JTextArea rnaSequenceTextArea;
    private final JButton showRnaButton;
    private DNAAnalyzer analyzer;

    public RNAViewerPanel() {
        rnaSequenceTextArea = new JTextArea();
        rnaSequenceTextArea.setEditable(false);

        showRnaButton = new JButton("Show RNA Sequence");
        showRnaButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showRnaButton);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(rnaSequenceTextArea), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (analyzer != null) {
            String rnaSequence = analyzer.transcribeToRna();

            rnaSequenceTextArea.setText("RNA Sequence: \n" + rnaSequence + "\n");
        }
    }

    @Override
    public void updateData(DNAAnalyzer analyzer) {
        this.analyzer = analyzer;
    }
}
