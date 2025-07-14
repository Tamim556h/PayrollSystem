package javaUI;

import javax.swing.*;

public class HelloWorldUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World From My First UI");
        frame.setSize(450, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Important: Disable default layout manager

        JLabel nameLabel = new JLabel("Hello Boy's");
        nameLabel.setBounds(30, 20, 100, 25);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 20, 250, 25);

        frame.add(nameLabel);
        frame.add(nameField);

        frame.setVisible(true);
    }
}
