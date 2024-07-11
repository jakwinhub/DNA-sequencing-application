package main.java.com.dnasequencing.gui;

// usage of own classes.

import main.java.com.dnasequencing.Application;
import main.java.com.dnasequencing.utils.LoggerUtils;

// usage of external Libraries.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;


// DNAAnalyzerPanel is a GUI component that allows users to read a file and analyze the DNA Sequence.
// Implementation of StatisticsPanel and ActionListener.

public class DNAAnalyzerPanel extends JPanel implements ActionListener {
    private static final Logger logger = LoggerUtils.getLogger();
    private final JTextArea outputArea;
    private final JButton loadFileButton;
    private final JButton analyzeButton;
    private final Application mainApp;

    // Formatting of the DNAAnalyzerPanel.

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
            outputArea.setText("File loaded. Ready for analysis.");
            logger.info("File loaded successfully. Ready for analysis.");
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadFileButton);
        buttonPanel.add(analyzeButton);

        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    /**
     * LoadFileButton action:
     * Calling the loadFile method in the mainApp to load a file.
     * Enabling the 'analyzeButton'.
     * Updating the outputArea with a success message.
     * Logging an info message.
     * <p>
     * AnalyzeButton action:
     * Updating the outputArea with a message indicating that the analysis has started.
     * Logging an info.
     * Disabling the 'analyzeButton'.
     * Starting a new thread to perform the process.
     * <p>
     * Analysis Thread:
     * Sleeps for 3 seconds.
     * Calling the updateStatisticsPanels() to update the statistics panels.
     * Updating the outputArea with a message using SwingUtilities.
     * Logging an info Message.
     * <p>
     * Error Handling:
     * InterruptException is logging an error message and updating the outputArea with an error message.
     * NoSuchElementException is logging an error message, showing the error dialog and updating the outputArea with an error message.
     * Exception logs an error message, shows an error dialog and updates the outputArea with an error message.
     *
     * @param e Method is called when the 'findCodonButton' is clicked.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == analyzeButton) {
            outputArea.setText("    File Analysis Started ... \n");
            logger.info("File Analysis Started ... \n");
            analyzeButton.setEnabled(false);
            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                    mainApp.updateStatisticsPanels();
                    SwingUtilities.invokeLater(() -> outputArea.setText("   Analysis Completed. \n"));
                    logger.info("Analysis Completed ... \n");
                } catch (InterruptedException interruptedException) {
                    SwingUtilities.invokeLater(() -> outputArea.setText("   Analysis interrupted. \n"));
                    logger.log(Level.SEVERE, "Analysis interrupted.", interruptedException);
                } catch (NoSuchElementException noSuchElementException) {
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this, "Error during analysis process, due to a missing start codon! ", "No start codon Found", JOptionPane.ERROR_MESSAGE));
                    outputArea.setText("    Analysis aborted. \n Please select a new file or check for Conventions.");
                    logger.log(Level.SEVERE, "Error during analysis process, due to a missing start codon.", noSuchElementException);
                } catch (Exception ex) {
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this, "Error during analysis process.", "Error", JOptionPane.ERROR_MESSAGE));
                    outputArea.setText("    Analysis interrupted.");
                    logger.log(Level.SEVERE, "Error during analysis process.", ex);
                }
            }).start();
        }
    }
}
