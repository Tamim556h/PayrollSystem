package javaUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Welcome {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Welcome");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Welcome label
        JLabel welcomeLabel = new JLabel("Welcome to My Application", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        frame.add(welcomeLabel, BorderLayout.NORTH);

        // Optional: Image icon (if available)
        // ImageIcon icon = new ImageIcon("logo.png"); // your image path here
        // JLabel imageLabel = new JLabel(icon, SwingConstants.CENTER);
        // frame.add(imageLabel, BorderLayout.CENTER);

        // Start button
        JButton startButton = new JButton("Start");
        startButton.setFont(new Font("Arial", Font.PLAIN, 14));
        startButton.setPreferredSize(new Dimension(100, 40));

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Action on button click
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close welcome screen
                openMainApp();   // Call your main app screen
            }
        });

        // Show the frame
        frame.setVisible(true);
    }

    public static void openMainApp() {
        // Replace this with your actual main app UI
        JFrame mainFrame = new JFrame("Main Application");
        mainFrame.setSize(400, 200);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(new JLabel("This is the main application screen", SwingConstants.CENTER));
        mainFrame.setVisible(true);
    }
}
