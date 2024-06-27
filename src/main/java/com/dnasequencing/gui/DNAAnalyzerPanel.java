package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.Application;

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
    private Application mainApp;

    public DNAAnalyzerPanel(Application mainApp) {
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
    public void actionPerformed(ActionEvent e)  {
    }
}