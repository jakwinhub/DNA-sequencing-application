package main.java.com.dnasequencing.gui;

// usage of own classes.

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

// usage of external libraries.

import javax.swing.*;
import java.awt.*;

// ProteinViewerPanel is a GUI component that allows users to view the Protein sequence.
// Implementation of StatisticsPanel and ActionListener.
public class ProteinViewerPanel extends JPanel implements StatisticsPanel {
    private final JTextArea proteinViewerTextArea;

    // Formatting of ProteinViewerPanel.
    public ProteinViewerPanel() {
        proteinViewerTextArea = new JTextArea();
        proteinViewerTextArea.setEditable(false);

        JPanel proteinViewerPanel = new JPanel(new BorderLayout());

        setLayout(new BorderLayout());
        add(proteinViewerPanel, BorderLayout.NORTH);
        add(new JScrollPane(proteinViewerTextArea), BorderLayout.CENTER);
    }

    /**
     * Main function:
     * Updates the GUI with the protein sequence when DNAAnalyzer provides it.
     * <p>
     * Process:
     * Calling translateToProtein() to get the proteinSequence.
     * Set text of proteinViewerTextArea with the protein sequence.
     *
     * @param analyzer instance to perform translation.
     */
    @Override
    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {
            String proteinSequence = analyzer.translateToProtein();
            proteinViewerTextArea.setText("Protein Sequence: \n" + proteinSequence + "\n");
        }
    }
}
