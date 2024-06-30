package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 * Class of the CodonFinderPanel. The panel is formatted and supplied with logic in this class
 */

public class CodonFinderPanel extends JPanel implements StatisticsPanel, ActionListener {
    private final JTextArea codonFinderTextArea;
    private final JTextField codonInputField;
    private final JButton findCodonButton;
    private DNAAnalyzer analyzer;


    public CodonFinderPanel() {
        codonFinderTextArea = new JTextArea();
        codonFinderTextArea.setEditable(false);

        codonInputField = new JTextField(3);
        findCodonButton = new JButton("Find Codon");
        findCodonButton.addActionListener(this);

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Enter Codon: "));
        inputPanel.add(codonInputField);
        inputPanel.add(findCodonButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(codonFinderTextArea), BorderLayout.CENTER);
    }


    /**
     * Updating the data that was previously available and can now be changed by executing the class.
     * @param analyzer the DNA analyzer with the loaded data
     */
    @Override
    public void updateData(DNAAnalyzer analyzer) {
        this.analyzer = analyzer;
    }


    /**
     * Updating the GUI which can be given a different appearance by executing the methods of this class.
     * @param e the event to be processed.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (analyzer != null) {
            String codon = codonInputField.getText().trim().toUpperCase();
            if (isValidCodon(codon)) {
                String codonPosition = analyzer.findCodonPosition(codon);
                codonFinderTextArea.setText("Codon Position for: " + codon + "\n" + codonPosition);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid codon format. Please enter a codon consisting of exactly three characters from the set {A, T, G, C}.", "Invalid Codon", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    /**
     * Validates the input of the user, if the codon is in the correct format.
     * Otherwise, the User gets a Message from void ActionPerformed.
     * @param codon the codon from the user-input.
     * @return true if codon is valid (matches out pattern), false otherwise.
     */
    private boolean isValidCodon(String codon) {
        Pattern codonPattern = Pattern.compile("^[ATGC]{3}$");
        return codonPattern.matcher(codon).matches();
    }
}
