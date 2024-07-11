package main.java.com.dnasequencing.gui;

// usage of own classes.

import main.java.com.dnasequencing.analysis.DNAAnalyzer;
import main.java.com.dnasequencing.analysis.DNATranscriber;

// usage of external libraries.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// RNAViewerPanel is a GUI component that allows users to view the RNA sequence.
// Implementation of StatisticsPanel and ActionListener.
public class RNAViewerPanel extends JPanel implements StatisticsPanel, ActionListener {
    private final JTextArea rnaSequenceTextArea;
    private final JButton showRnaButton;
    private DNAAnalyzer analyzer;

    // Formatting of RNAViewerPanel.
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

    /**
     * Check if analyzer is not null.
     * Gets the DNA sequence from the analyzer.
     * Transcribes the DNA Sequence to RNA using the transcribeToRnaFromStartCodon().
     * Formats the RNA sequence by adding spaces every 3 characters.
     * Sets the text of the 'rnaSequenceTextArea' with the formatted RNA sequence.
     *
     * @param e Called when 'showRnaButton' is clicked.
     */
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

    /**
     * Updating the GUI with DNAAnalyzer instance.
     *
     * @param analyzer providing the instance.
     */
    @Override
    public void updateData(DNAAnalyzer analyzer) {
        this.analyzer = analyzer;
    }
}
