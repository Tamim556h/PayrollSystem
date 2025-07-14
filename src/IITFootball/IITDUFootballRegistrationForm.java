package IITFootball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class IITDUFootballRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("IITDU Football League Registration");
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===== Background Image Panel =====
        JPanel backgroundPanel = new JPanel() {
            ImageIcon background = new ImageIcon(getClass().getResource("background.jpg"));


            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null);

        // Transparent overlay
        JPanel overlay = new JPanel();
        overlay.setBounds(20, 20, 560, 640);
        overlay.setBackground(new Color(255, 255, 255, 153)); // White with 60% opacity
        overlay.setLayout(null);

        // Shared font and color settings
        Font labelFont = new Font("Arial", Font.BOLD, 13);
        Color labelColor = new Color(178, 34, 34); // Firebrick
        Color fieldBg = new Color(245, 245, 245); // Light gray
        Color btnColor = new Color(70, 130, 180); // Steel blue

        // ===== Personal Info =====
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setBounds(30, 20, 100, 25);
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(labelColor);
        JTextField nameField = new JTextField();
        nameField.setBounds(160, 20, 350, 25);
        nameField.setBackground(fieldBg);


        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setBounds(30, 60, 100, 25);
        phoneLabel.setFont(labelFont);
        phoneLabel.setForeground(labelColor);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(160, 60, 350, 25);
        phoneField.setBackground(fieldBg);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 100, 100, 25);
        emailLabel.setFont(labelFont);
        emailLabel.setForeground(labelColor);
        JTextField emailField = new JTextField();
        emailField.setBounds(160, 100, 350, 25);
        emailField.setBackground(fieldBg);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 140, 100, 25);
        addressLabel.setFont(labelFont);
        addressLabel.setForeground(labelColor);
        JTextField addressField = new JTextField();
        addressField.setBounds(160, 140, 350, 25);
        addressField.setBackground(fieldBg);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 180, 100, 25);
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(160, 180, 70, 25);
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(230, 180, 80, 25);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);


        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(30, 220, 100, 25);
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


        JLabel degreeLabel = new JLabel("Latest Degree:");
        degreeLabel.setBounds(30, 260, 100, 25);
        String[] degrees = {"Select", "BSSE", "MSSE", "PhD"};
        JComboBox<String> degreeBox = new JComboBox<>(degrees);
        degreeBox.setBounds(160, 260, 200, 25);


        JLabel photoLabel = new JLabel("Upload Photo:");
        photoLabel.setBounds(30, 300, 100, 25);
        JButton photoBtn = new JButton("Choose File");
        photoBtn.setBounds(160, 300, 120, 25);
        JLabel photoPathLabel = new JLabel();
        photoPathLabel.setBounds(290, 300, 250, 25);
        final String[] selectedPhotoPath = {""};
        photoBtn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                selectedPhotoPath[0] = file.getAbsolutePath();
                photoPathLabel.setText(file.getName());
            }
        });

        JLabel positionLabel = new JLabel("Preferred Position:");
        positionLabel.setBounds(30, 340, 150, 25);
        String[] positions = {"Select", "Goalkeeper", "Defender", "Midfielder", "Forward"};
        JComboBox<String> positionBox = new JComboBox<>(positions);
        positionBox.setBounds(160, 340, 200, 25);

        JLabel interDeptLabel = new JLabel("Played Inter-Dept?:");
        interDeptLabel.setBounds(30, 380, 150, 25);
        JCheckBox interDeptCheck = new JCheckBox("Yes");
        interDeptCheck.setBounds(160, 380, 100, 25);


        JLabel experienceLabel = new JLabel("Football Experience:");
        experienceLabel.setBounds(30, 420, 150, 25);
        JTextArea experienceArea = new JTextArea();
        experienceArea.setBounds(160, 420, 350, 80);
        experienceArea.setLineWrap(true);
        experienceArea.setWrapStyleWord(true);
        experienceArea.setBackground(fieldBg);


        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(230, 530, 120, 35);
        registerBtn.setBackground(btnColor);
        registerBtn.setForeground(Color.WHITE);
        registerBtn.setFont(new Font("Arial", Font.BOLD, 14));
        registerBtn.setFocusPainted(false);

        registerBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                registerBtn.setBackground(new Color(90, 155, 212));
            }
            public void mouseExited(MouseEvent e) {
                registerBtn.setBackground(btnColor);
            }
        });


        registerBtn.addActionListener(e -> {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String address = addressField.getText();
            String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "");
            String dob = dayBox.getSelectedItem() + "-" + monthBox.getSelectedItem() + "-" + yearBox.getSelectedItem();
            String degree = (String) degreeBox.getSelectedItem();
            String photo = selectedPhotoPath[0].isEmpty() ? "" : selectedPhotoPath[0];
            String position = (String) positionBox.getSelectedItem();
            String interDept = interDeptCheck.isSelected() ? "Yes" : "No";
            String experience = experienceArea.getText();

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() ||
                    gender.isEmpty() || degree.equals("Select") || position.equals("Select") ||
                    photo.isEmpty() || experience.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                FileWriter writer = new FileWriter("iitdu_football_registration.txt", true);
                writer.write("Name: " + name + "\n");
                writer.write("Phone: " + phone + "\n");
                writer.write("Email: " + email + "\n");
                writer.write("Address: " + address + "\n");
                writer.write("Gender: " + gender + "\n");
                writer.write("Date of Birth: " + dob + "\n");
                writer.write("Degree: " + degree + "\n");
                writer.write("Photo: " + photo + "\n");
                writer.write("Preferred Position: " + position + "\n");
                writer.write("Played Inter-Dept: " + interDept + "\n");
                writer.write("Experience: " + experience + "\n");
                writer.write("--------------------------------------------------\n");
                writer.close();
                JOptionPane.showMessageDialog(frame, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear form
                nameField.setText(""); phoneField.setText(""); emailField.setText("");
                addressField.setText(""); genderGroup.clearSelection(); degreeBox.setSelectedIndex(0);
                dayBox.setSelectedIndex(0); monthBox.setSelectedIndex(0); yearBox.setSelectedIndex(0);
                positionBox.setSelectedIndex(0); interDeptCheck.setSelected(false); experienceArea.setText("");
                photoPathLabel.setText(""); selectedPhotoPath[0] = "";

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add all components to overlay
        overlay.add(nameLabel); overlay.add(nameField);
        overlay.add(phoneLabel); overlay.add(phoneField);
        overlay.add(emailLabel); overlay.add(emailField);
        overlay.add(addressLabel); overlay.add(addressField);
        overlay.add(genderLabel); overlay.add(male); overlay.add(female);
        overlay.add(dobLabel); overlay.add(dayBox); overlay.add(monthBox); overlay.add(yearBox);
        overlay.add(degreeLabel); overlay.add(degreeBox);
        overlay.add(photoLabel); overlay.add(photoBtn); overlay.add(photoPathLabel);
        overlay.add(positionLabel); overlay.add(positionBox);
        overlay.add(interDeptLabel); overlay.add(interDeptCheck);
        overlay.add(experienceLabel); overlay.add(experienceArea);
        overlay.add(registerBtn);

        // Final layout
        frame.setContentPane(backgroundPanel);
        backgroundPanel.add(overlay);
        frame.setVisible(true);
    }
}