package main.java.com.dnasequencing;

import javax.swing.JFrame;

import main.java.com.dnasequencing.gui.DnaAnalyzerPanel;

/**
 *  The main class that starts the program.
 *  Contains settings for panel (size and close-Operation).
 */

public class Application {
    public static void main(String[] args) {
        JFrame frame = new JFrame("DNA Sequencing Application");
        DnaAnalyzerPanel panel = new DnaAnalyzerPanel();

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
