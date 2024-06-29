package main.java.com.dnasequencing;

import javax.swing.*;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;
import main.java.com.dnasequencing.gui.*;
import main.java.com.dnasequencing.utils.FileLoader;

import java.awt.*;

/**
 *  The main class that starts the program.
 *  Contains settings for panel (size and close-Operation).
 */

public class Application {
    private DNAAnalyzer analyzer;
    private JTabbedPane tabbedPane;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Application().createAndShowGUI());
    }

    /**
     *  Method, which is responsible for the creation and subsequent display of the GUI.
     *  All panels created and formatted in external classes are called up in this method.
     */
    private void createAndShowGUI() {
        JFrame frame = new JFrame("DNA Analyzer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();

        /**
         * Call up of the individual Pages.
         * Moving the order, would change the appearance of the GUI, but not the function of the Pages.
         */
        tabbedPane.addTab("Welcome", new WelcomePanel());
        tabbedPane.addTab("Analyzer", new DNAAnalyzerPanel(this));
        tabbedPane.addTab("DNA Statistics", new DNAStatisticsPanel());
        tabbedPane.addTab("RNA Statistics", new RNAStatisticsPanel());
        tabbedPane.addTab("Protein Statistics", new ProteinStatisticsPanel());
        tabbedPane.addTab("Codon Finder", new CodonFinderPanel());
        tabbedPane.addTab("RNA Viewer", new RNAViewerPanel());
        tabbedPane.addTab("Protein Viewer", new ProteinViewerPanel());



        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }


    /**
     * Execute the loadFile method, which references FileLoader and loads the data into a string.
     */
    public void loadFile() {
        FileLoader fileLoader = new FileLoader();
        analyzer = fileLoader.loadFile();
        updateStatisticsPanels();
    }

    /**
     * Method which is responsible for updating the statisticsPanel
     */
    private void updateStatisticsPanels() {
        for (Component component : tabbedPane.getComponents()) {
            if (component instanceof StatisticsPanel) {
                ((StatisticsPanel) component).updateData(analyzer);
            }
        }
    }
}