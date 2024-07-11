package main.java.com.dnasequencing.gui;

// usage of own class.

import main.java.com.dnasequencing.analysis.DNAAnalyzer;

// Interface StatisticsPanel is used to update the GUI components with the DNAAnalyzer
public interface StatisticsPanel {
    /**
     * Updates the GUI components with the instance.
     * @param analyzer instance.
     */
    void updateData(DNAAnalyzer analyzer);
}
