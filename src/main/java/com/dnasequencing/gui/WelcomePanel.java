package main.java.com.dnasequencing.gui;

// usage of external libraries.

import javax.swing.*;
import java.awt.*;

// WelcomePanel is a GUI component that displays a welcome message and instruction for using the Application.
public class WelcomePanel extends JPanel{
    private final JTextArea welcomeTextArea;

    // Initializing the GUI components.
    public WelcomePanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel(" Jakob's DNA-Analyse Tool ");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        welcomeTextArea = new JTextArea("""
                
                   Um dieses Tool zu benutzen bitte ich folgendes zu beachten:
                   - Das Eingabeformat welches akzeptiert wird ist nur auf .txt Dateien beschränkt.
                   - Die Konventionen, welche die DNA-Sequenz innerhalb der Datei erfüllen muss: [ATGC]
                   - Leerzeichen und Zeilenumbrüche innerhalb der Sequenz sind erlaubt und werden durch das Tool ignoriert.\s
                   - Das Laden von mehreren Dateien zur selbigen Zeit ist aktuell nicht möglich.
                   - Die einzelnen Tabs ermöglichen es verschiedene Daten zu visualisieren. \s
                     # Das "Analyzer"-Tab ist für das Laden und die Anschließende Ausführung der Analyse zuständig.\s
                     # Das "Nucleotide-Statistics"-panel ist für die Prozentuale Darstellung der einzelnen Basen verantwortlich. Eine Graphische Darstellung ist aktuell nicht integriert.
                     # Das "RNA-Viewer"-panel ermöglicht die komplementäre RNA-Sequenz auszugeben. Dieser Prozess wird nur angestoßen, wenn der Knopf "View RNA" gedrückt wird.
                     # Das "Protein-Statistic"-panel visualisiert die Anzahl der einzelnen codierten Proteine in einem Balkendiagramm. Hierbei beschreibt die x-Achse die einzelnen Proteine und die y-Achse die Anzahl.
                     # Das "Protein-Viewer"-panel ermöglicht, wie auch im RNA-Viewer, die auf Knopfdruck gewünschte Darstellung der Protein Sequenz.\s
                     # Zu beachten ist, dass die Proteinbiosynthese erst ab einem Start-Codon erfolgt und mit einem Stop-Codon endet.
                     # Das "Codon-Finder"-panel ermöglicht die Suche nach einem Gewünschten Triplet. Zu beachten ist, dass die ausgegebene Position, die Position des ersten Nukleotids im String ausgibt.


                   To be considered:
                   - Der Prozess der Proteinbiosynthese ist stark verenifacht.
                   - Das Herausschneiden der Introns (nicht codierdener Teil) wurde übergangen um die Komplexität etwas geringer zu halten.
               
                """);
        welcomeTextArea.setEditable(false);
        welcomeTextArea.setLineWrap(true);

        add(label, BorderLayout.NORTH);
        add(welcomeTextArea, BorderLayout.CENTER);
    }
}
