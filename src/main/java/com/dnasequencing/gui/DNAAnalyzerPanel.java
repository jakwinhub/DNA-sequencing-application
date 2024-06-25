package main.java.com.dnasequencing.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI class for the application.
 */

public class DNAAnalyzerPanel extends JPanel implements ActionListener {
    private JTextArea outputArea;
    private JButton loadFileButton;
    private JButton analyzeButton;
    private main.java.com.dnasequencing.Application mainApp;

    public DNAAnalyzerPanel(main.java.com.dnasequencing.Application mainApp) {
        this.mainApp = mainApp;
        this.setLayout(new BorderLayout());

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        analyzeButton = new JButton("Start Analysis");
        analyzeButton.addActionListener(this);
        analyzeButton.setEnabled(false);

        loadFileButton = new JButton("Load File");
        loadFileButton.addActionListener(e -> {
            mainApp.loadFile();
            analyzeButton.setEnabled(true);
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadFileButton);
        buttonPanel.add(analyzeButton);

        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Analysis logic here, but this part is delegated to the Main class now
        // The outputArea can be updated if needed
    }
}