package IITFootball;


import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class RegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IIT Football League - Player Registration");
        frame.setSize(550, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Name
        JLabel nameLabel = new JLabel("Player Name:");
        nameLabel.setBounds(30, 20, 120, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(160, 20, 300, 25);
        frame.add(nameLabel);
        frame.add(nameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 60, 120, 25);
        JTextField emailField = new JTextField();
        emailField.setBounds(160, 60, 300, 25);
        frame.add(emailLabel);
        frame.add(emailField);

        // Department
        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(30, 100, 120, 25);
        JTextField deptField = new JTextField();
        deptField.setBounds(160, 100, 300, 25);
        frame.add(deptLabel);
        frame.add(deptField);

        // Jersey Number
        JLabel jerseyLabel = new JLabel("Jersey No:");
        jerseyLabel.setBounds(30, 140, 120, 25);
        JTextField jerseyField = new JTextField();
        jerseyField.setBounds(160, 140, 300, 25);
        frame.add(jerseyLabel);
        frame.add(jerseyField);

        // Team Dropdown
        JLabel teamLabel = new JLabel("Team:");
        teamLabel.setBounds(30, 180, 120, 25);
        String[] teams = {"Select", "IIT A", "IIT B", "IIT C", "IIT D"};
        JComboBox<String> teamBox = new JComboBox<>(teams);
        teamBox.setBounds(160, 180, 300, 25);
        frame.add(teamLabel);
        frame.add(teamBox);

        // Date of Birth
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 220, 120, 25);
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] years = new String[40];
        for (int i = 0; i < 40; i++) years[i] = String.valueOf(2025 - i);

        JComboBox<String> dayBox = new JComboBox<>(days);
        dayBox.setBounds(160, 220, 60, 25);
        JComboBox<String> monthBox = new JComboBox<>(months);
        monthBox.setBounds(230, 220, 90, 25);
        JComboBox<String> yearBox = new JComboBox<>(years);
        yearBox.setBounds(330, 220, 80, 25);

        frame.add(dobLabel);
        frame.add(dayBox);
        frame.add(monthBox);
        frame.add(yearBox);

        // Gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 260, 120, 25);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(160, 260, 70, 25);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(240, 260, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        frame.add(genderLabel);
        frame.add(male);
        frame.add(female);

        // Player Photo Upload
        JLabel fileLabel = new JLabel("Player Photo:");
        fileLabel.setBounds(30, 300, 120, 25);
        JButton fileButton = new JButton("Choose File");
        fileButton.setBounds(160, 300, 120, 25);
        JLabel filePathLabel = new JLabel();
        filePathLabel.setBounds(290, 300, 200, 25);
        frame.add(fileLabel);
        frame.add(fileButton);
        frame.add(filePathLabel);

        final String[] selectedFilePath = {""};
        fileButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(frame);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                selectedFilePath[0] = file.getAbsolutePath();
                filePathLabel.setText(file.getName());
            }
        });

        // Terms and Conditions
        JCheckBox agreeCheck = new JCheckBox("I confirm I am physically fit and agree to the rules.");
        agreeCheck.setBounds(30, 340, 450, 30);
        frame.add(agreeCheck);

        // Register Button
        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(200, 400, 120, 35);
        frame.add(registerBtn);

        registerBtn.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String dept = deptField.getText();
            String jersey = jerseyField.getText();
            String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "Not selected");
            String team = (String) teamBox.getSelectedItem();
            String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();

            if (name.isEmpty() || email.isEmpty() || dept.isEmpty() || jersey.isEmpty()
                    || gender.equals("Not selected") || team.equals("Select") || !agreeCheck.isSelected()) {
                JOptionPane.showMessageDialog(frame, "Please complete all fields and agree to the terms.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Player Registered Successfully!\n\n" +
                                "Name: " + name +
                                "\nEmail: " + email +
                                "\nDepartment: " + dept +
                                "\nJersey No: " + jersey +
                                "\nGender: " + gender +
                                "\nDOB: " + dob +
                                "\nTeam: " + team +
                                "\nPhoto: " + (selectedFilePath[0].isEmpty() ? "Not uploaded" : filePathLabel.getText()),
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}
