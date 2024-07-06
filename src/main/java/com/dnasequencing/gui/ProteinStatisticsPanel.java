package main.java.com.dnasequencing.gui;

import main.java.com.dnasequencing.analysis.DNAAnalyzer;
import main.java.com.dnasequencing.analysis.RNATranslator;
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

public class ProteinStatisticsPanel extends JPanel implements StatisticsPanel {
    private DefaultCategoryDataset proteinDataset;
    private JFreeChart chart;
    private ChartPanel chartPanel;

    public ProteinStatisticsPanel() {
        setLayout(new BorderLayout());
        proteinDataset = new DefaultCategoryDataset();
        chart = createChart(proteinDataset);
        chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
    }

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

    @Override
    public void updateData(DNAAnalyzer analyzer) {
        if (analyzer != null) {
            String rna = analyzer.transcribeToRna();
            String proteinSequence = RNATranslator.translateToProtein(rna);

            // Initialize counts for each protein
            Map<String, Integer> counts = new HashMap<>();
            for (String protein : RNATranslator.getCodonMap().values()) {
                if (!protein.equals("Stop")) {
                    counts.put(protein, 0);
                }
            }

            // Count occurrences of each protein
            String[] proteins = proteinSequence.split(" ");
            for (String protein : proteins) {
                counts.put(protein, counts.getOrDefault(protein, 0) + 1);
            }

            // Clear the dataset and add the proportions
            proteinDataset.clear();
            int total = proteins.length;
            for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                double count = (double) entry.getValue();
                proteinDataset.addValue(count, "Proteins", entry.getKey());
            }
        }
    }
}
