package main.java.com.dnasequencing;

// usage of own classes.

import main.java.com.dnasequencing.analysis.DNAAnalyzer;
import main.java.com.dnasequencing.gui.*;
import main.java.com.dnasequencing.utils.FileLoader;
import main.java.com.dnasequencing.utils.LoggerUtils;

// usage of external libraries.

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

// Application is the main class that starts the program and is responsible for creating and displaying the GUI.
public class Application {
    private static final Logger logger = LoggerUtils.getLogger();
    private DNAAnalyzer analyzer;
    private JTabbedPane tabbedPane;

    /**
     * Entry point of the program.
     *
     * @param args default.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Application().createAndShowGUI());
    }

     // Responsible for the creation and subsequent display of the GUI.
     // All panels created and formatted in external classes are called up in this method.
    private void createAndShowGUI() {
        JFrame frame = new JFrame("DNA Analyzer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();

        // Call up of the individual Pages.
        // Moving the order, would change the appearance of the GUI, but not the function of the Pages.
        tabbedPane.addTab("Main Page", new WelcomePanel());
        tabbedPane.addTab("Analyzer", new DNAAnalyzerPanel(this));
        tabbedPane.addTab("Nucleotide Statistics", new NucleotideStatisticsPanel());
        tabbedPane.addTab("RNA Viewer", new RNAViewerPanel());
        tabbedPane.addTab("Protein Statistics", new ProteinStatisticsPanel());
        tabbedPane.addTab("Protein Viewer", new ProteinViewerPanel());
        tabbedPane.addTab("Codon Finder", new CodonFinderPanel());


        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
        logger.info("GUI started and displayed.");
    }

    // Execute the loadFile method, referring to FileLoader loading data to String, initialising the DNAAnalyzer instance.
    public void loadFile() {
        logger.info("Loading file...");
        FileLoader fileLoader = new FileLoader();
        analyzer = fileLoader.loadFile();
        logger.info("File loaded successfully.");
    }


    // Responsible for updating the statisticsPanel by iterating over the components of JTabbedPane passing the DNAAnalyzer instance.
    public void updateStatisticsPanels() {
        for (Component component : tabbedPane.getComponents()) {
            if (component instanceof StatisticsPanel) {
                ((StatisticsPanel) component).updateData(analyzer);
                logger.info("Statistics panel updated to " + component);
            }
        }
    }
}