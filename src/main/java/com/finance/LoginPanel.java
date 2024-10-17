package com.finance;

import javax.swing.*;
import java.awt.*;

class LoginPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private PersonalFinanceManager manager;

    public LoginPanel(PersonalFinanceManager manager) {
        this.manager = manager;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridwidth = 1; gbc.gridx = 0; gbc.gridy = 1;
        add(usernameLabel, gbc);
        usernameField = new JTextField(20);
        gbc.gridx = 1;
        add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 2;
        add(passwordLabel, gbc);
        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(loginButton, gbc);

        loginButton.addActionListener(e -> {
            // Add validation for username and password here
            manager.switchPanel("Dashboard");
        });
    }
}
