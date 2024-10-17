package com.finance;

import javax.swing.*;
import java.awt.*;

class DashboardPanel extends JPanel {
    private JLabel welcomeLabel;

    public DashboardPanel(PersonalFinanceManager manager) {
        setLayout(new BorderLayout());

        // Welcome message
        welcomeLabel = new JLabel("Welcome, User!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(welcomeLabel, BorderLayout.NORTH);

        // Grid Panel for buttons
        JPanel gridPanel = new JPanel(new GridLayout(2, 2));
        JButton incomeButton = new JButton("Income");
        JButton expensesButton = new JButton("Expenses");
        JButton reportsButton = new JButton("Reports");
        JButton settingsButton = new JButton("Settings");

        gridPanel.add(incomeButton);
        gridPanel.add(expensesButton);
        gridPanel.add(reportsButton);
        gridPanel.add(settingsButton);

        add(gridPanel, BorderLayout.CENTER);

        // Set action listeners for buttons to switch panels
        incomeButton.addActionListener(e -> manager.switchPanel("Income"));
        expensesButton.addActionListener(e -> manager.switchPanel("Expenses"));
        reportsButton.addActionListener(e -> manager.switchPanel("Reports"));
        settingsButton.addActionListener(e -> manager.switchPanel("Settings"));
    }

    // Method to update welcome message
    public void updateWelcomeMessage(String username) {
        welcomeLabel.setText("Welcome, " + username + "!");
    }
}
