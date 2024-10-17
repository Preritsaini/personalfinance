package com.finance;

import javax.swing.*;
import java.awt.*;

class SettingsPanel extends JPanel {
    private JCheckBox notificationCheckbox;
    private JComboBox<String> accountTypeDropdown;
    private JComboBox<String> themeDropdown;
    private PersonalFinanceManager manager;

    public SettingsPanel(PersonalFinanceManager manager) {
        this.manager = manager;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Settings");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(titleLabel, gbc);

        notificationCheckbox = new JCheckBox("Send Notifications");
        gbc.gridwidth = 2; gbc.gridx = 0; gbc.gridy = 1;
        add(notificationCheckbox, gbc);

        JLabel accountTypeLabel = new JLabel("Account Type:");
        gbc.gridwidth = 1; gbc.gridx = 0; gbc.gridy = 2;
        add(accountTypeLabel, gbc);
        accountTypeDropdown = new JComboBox<>(new String[]{"Normal", "Company"});
        gbc.gridx = 1;
        add(accountTypeDropdown, gbc);

        JLabel themeLabel = new JLabel("Theme:");
        gbc.gridwidth = 1; gbc.gridx = 0; gbc.gridy = 3;
        add(themeLabel, gbc);
        themeDropdown = new JComboBox<>(new String[]{"Light", "Dark"});
        gbc.gridx = 1;
        add(themeDropdown, gbc);

        JButton logoutButton = new JButton("Logout");
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        add(logoutButton, gbc);

        logoutButton.addActionListener(e -> {
            manager.switchPanel("Login");
        });
    }
}
