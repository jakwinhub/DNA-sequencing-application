package main.java.com.dnasequencing.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import main.java.com.dnasequencing.analysis.*;

/**
 * GUI class for the application.
 */

public class DnaAnalyzerPanel extends JPanel implements ActionListener {

    private JTextArea outputArea;
    private JButton loadFileButton;
    private JFileChooser fileChooser;
    private JButton analyzeButton;
    private DnaAnalyzer analyzer;

    public DnaAnalyzerPanel() {
        this.setLayout(new BorderLayout());

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        analyzeButton = new JButton("Analyse starten");
        analyzeButton.addActionListener(this);
        analyzeButton.setEnabled(false);

        loadFileButton = new JButton("Load File");
        loadFileButton.addActionListener(e -> loadFile());

        fileChooser = new JFileChooser();

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadFileButton);
        buttonPanel.add(analyzeButton);

        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    private void loadFile() {
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                analyzer = DnaAnalyzer.fromFile(selectedFile.getAbsolutePath());
                analyzeButton.setEnabled(true);
                outputArea.setText("File loaded: " + selectedFile.getName());
            } catch (IOException ex) {
                outputArea.setText("Error while loading the file: " + ex.getMessage());
            } catch (IllegalArgumentException ex) {
                outputArea.setText("Invalid DNA-Sequence in file: " + ex.getMessage());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (analyzer != null) {

            double cContent = analyzer.calculateCContent();
            double gContent = analyzer.calculateGContent();
            double aContent = analyzer.calculateAContent();
            double tContent = analyzer.calculateTContent();
            String codonPosition = analyzer.findCodonPosition("ATG");
            String rna = analyzer.transcribeToRna();
            String protein = analyzer.translateToProtein();

            outputArea.setText("CG content: " + cContent + "%\n");
            outputArea.append("CG content: " + gContent + "%\n");
            outputArea.append("CG content: " + aContent + "%\n");
            outputArea.append("AT Content: " + tContent + "%\n");

            outputArea.append("Codon position for 'ATG': " + codonPosition + "\n");

            outputArea.append("RNA sequence: " + rna + "\n");

            outputArea.append("Translated Protein Sequence: " + protein + "\n");

        }
    }
}
