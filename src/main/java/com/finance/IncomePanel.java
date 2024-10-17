package com.finance;

import javax.swing.*;
import java.awt.*;

public class IncomePanel extends JPanel {
    private PersonalFinanceManager manager;
    private FinancialData financialData;

    public IncomePanel(PersonalFinanceManager manager, FinancialData financialData) {
        this.manager = manager;
        this.financialData = financialData;

        setLayout(new GridBagLayout());

        // UI Components
        JLabel incomeLabel = new JLabel("Enter Income:");
        JTextField incomeField = new JTextField(10);
        JButton addButton = new JButton("Add Income");

        // Add components to layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0; add(incomeLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; add(incomeField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; add(addButton, gbc);

        // Add button action listener
        // Add button action listener
        addButton.addActionListener(e -> {
            try {
                double income = Double.parseDouble(incomeField.getText());
                financialData.addIncome(income); // Update financial data
                JOptionPane.showMessageDialog(this, "Income added successfully!");
                manager.getReportsPanel().updateReport(); // Update report panel
                manager.switchPanel("Dashboard"); // Switch back to dashboard
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for income.");
            }
        });

    }
}
