package main.java.com.dnasequencing;

import javax.swing.*;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;
import main.java.com.dnasequencing.gui.*;

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

    private void createAndShowGUI() {
        JFrame frame = new JFrame("DNA Analyzer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();

        DNAAnalyzerPanel analyzerPanel = new DNAAnalyzerPanel(this);
        tabbedPane.addTab("Analyzer", analyzerPanel);
        tabbedPane.addTab("DNA Statistics", new DNAStatisticsPanel());
        tabbedPane.addTab("RNA Statistics", new RNAStatisticsPanel());
        tabbedPane.addTab("Protein Statistics", new ProteinStatisticsPanel());

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void loadFile() {
        FileLoader fileLoader = new FileLoader();
        analyzer = fileLoader.loadFile();
        updateStatisticsPanels();
    }

    private void updateStatisticsPanels() {
        for (Component component : tabbedPane.getComponents()) {
            if (component instanceof StatisticsPanel) {
                ((StatisticsPanel) component).updateData(analyzer);
            }
        }
    }
}