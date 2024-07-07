package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;
import main.java.com.dnasequencing.analysis.DNATranscriber;

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
            String dnaSequence = analyzer.getDnaSequence();
            String rnaSequence = DNATranscriber.transcribeToRnaFromStartCodon(dnaSequence);
            StringBuilder rnaSequenceBuilder = new StringBuilder("RNA Sequence: " + "\n");

            for (int i = 0; i < rnaSequence.length(); i += 3) {
                rnaSequenceBuilder.append(rnaSequence, i, Math.min(i + 3, rnaSequence.length()));
                if (i + 3 < rnaSequence.length()) {
                    rnaSequenceBuilder.append(" ");
                }
            }

            rnaSequenceTextArea.setText(rnaSequenceBuilder.toString());
        }
    }

    @Override
    public void updateData(DNAAnalyzer analyzer) {
        this.analyzer = analyzer;
    }
}
