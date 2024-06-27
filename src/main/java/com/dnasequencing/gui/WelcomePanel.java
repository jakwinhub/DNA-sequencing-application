package main.java.com.dnasequencing.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel implements ActionListener {

    public WelcomePanel() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Welcome to my DNA Sequencing Application");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
