package javaUI;

import javax.swing.*;
import java.io.*;

public class Student {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Form");
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 20, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 20, 250, 25);
        frame.add(nameLabel);
        frame.add(nameField);

        // Dept
        JLabel deptLevel = new JLabel("Dept :");
        deptLevel.setBounds(30, 60, 100, 25);
        JTextField deptFild = new JTextField();
        deptFild.setBounds(150, 60, 250, 25);
        frame.add(deptLevel);
        frame.add(deptFild);

        // Roll
        JLabel rollLabel = new JLabel("Roll:");
        rollLabel.setBounds(30, 100, 100, 25);
        JTextField rollField = new JTextField();
        rollField.setBounds(150, 100, 250, 25);
        frame.add(rollLabel);
        frame.add(rollField);

        // Session
        JLabel sessionLabel = new JLabel("Session:");
        sessionLabel.setBounds(30, 180, 100, 25);
        String[] session = {"Select", "24-25", "23-24", "22-23", "21-22", "20-21"};
        JComboBox<String> sessionBox = new JComboBox<>(session);
        sessionBox.setBounds(150, 180, 250, 25);
        frame.add(sessionLabel);
        frame.add(sessionBox);


        // Register Button
        JButton registerBtn = new JButton("Submit'. ");
        registerBtn.setBounds(150, 320, 120, 30);
        frame.add(registerBtn);


        registerBtn.addActionListener(e -> {
            String username = nameField.getText();
            String dept = deptFild.getText();
            String roll = rollField.getText();
            String sessionn = sessionBox.getSelectedItem().toString();


            JOptionPane.showMessageDialog(frame,
                    "Name: " + username + "\n" +
                            "Dept: " + dept + "\n"+
                            "Roll: " + roll  + "\n" +
                            "Session: " + sessionn + "\n"
            );


        });



        frame.setVisible(true);
    }
}
