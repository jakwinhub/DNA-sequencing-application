package main.java.com.dnasequencing.gui;

// usage of own classes.

import main.java.com.dnasequencing.analysis.DNAAnalyzer;
import main.java.com.dnasequencing.analysis.RNATranslator;

// usage of external libraries.

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

// ProteinStatisticsPanel is a GUI component that allows users to view the Protein Statistics displayed as a Bar chart.
// Implementation of StatisticsPanel and ActionListener.
public class ProteinStatisticsPanel extends JPanel implements StatisticsPanel {
    private final DefaultCategoryDataset proteinDataset;
    private final JFreeChart chart;
    private final ChartPanel chartPanel;

    // Formatting of ProteinStatisticsPanel.
    public ProteinStatisticsPanel() {
        setLayout(new BorderLayout());
        proteinDataset = new DefaultCategoryDataset();
        chart = createChart(proteinDataset);
        chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
    }

    /**
     * Creating a bar chart by using the CharFactory and configuration of it.
     * Set the char-title, x-axis label and y-axis label.
     * Creating a CategoryPlot and set the render to a BarRenderer.
     * Configures the renderer to have a maximum bar width of 0.1.
     * Rotates the category labels (protein-names) to 90 degrees.
     *
     * @param proteinDataset accumulation of all Protein counts.
     * @return bar chart displaying the proportions.
     */
    private JFreeChart createChart(DefaultCategoryDataset proteinDataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Protein Distribution",
                "Protein",
                "Proportion",
                proteinDataset
        );

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setMaximumBarWidth(0.1);

        // Rotate the category labels to 90 degrees
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_90);

        return chart;
    }

    /**
     * Main function:
     * Updating the GUI with the protein statistics when the DNAAnalyzer provides it.
     * Process:
     * Transcribes DNA into RNA using transcribetoRNAFromStartCodon().
     * Translates RNA into Protein sequence using translateToProtein().
     * Initialises Map to count the occurrences of the protein in the sequence.
     * Clears the dataset and adds the proportions of each protein to it.
     * Updates the Char with new Data.
     *
     * @param analyzer used to perform the biosynthesis.
     */
    @Override
    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {
            String rna = analyzer.transcribeToRnaFromStartCodon();
            String proteinSequence = RNATranslator.translateToProtein(rna);

            Map<String, Integer> counts = new HashMap<>();
            for (String protein : RNATranslator.getCodonMap().values()) {
                if (!protein.equals("Stop")) {
                    counts.put(protein, 0);
                }
            }

            String[] proteins = proteinSequence.split(" ");
            for (String protein : proteins) {
                counts.put(protein, counts.getOrDefault(protein, 0) + 1);
            }

            proteinDataset.clear();
            for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                double count = (double) entry.getValue();
                proteinDataset.addValue(count, "Proteins", entry.getKey());
            }
        }
    }
}
