package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class of the CodonFinderPanel. The panel is formatted and supplied with logic in this class
 */

public class CodonFinderPanel extends JPanel implements StatisticsPanel, ActionListener {
    private final JTextArea CodonFinderTextArea;
    private final JTextField codonInputField;
    private final JButton findCodonButton;
    private DNAAnalyzer analyzer;


    public CodonFinderPanel() {
        CodonFinderTextArea = new JTextArea();
        CodonFinderTextArea.setEditable(false);

        codonInputField = new JTextField(3);
        findCodonButton = new JButton("Find Codon");
        findCodonButton.addActionListener(this);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Codon: "));
        inputPanel.add(codonInputField);
        inputPanel.add(findCodonButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(CodonFinderTextArea), BorderLayout.CENTER);
    }


    /**
     * Updating the data that was previously available and can now be changed by executing the class.
     * @param analyzer
     */
    @Override
    public void updateData(DNAAnalyzer analyzer) {
        this.analyzer = analyzer;
    }


    /**
     * Updating the GUI which can be given a different appearance by executing the methods of this class.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (analyzer != null && !codonInputField.getText().isEmpty()) {
            String codon = codonInputField.getText().toUpperCase();
            String codonPosition = analyzer.findCodonPosition(codon);

            CodonFinderTextArea.setText("Codon Position for: "+ codon +  "\n" + codonPosition);
        }
    }
}
