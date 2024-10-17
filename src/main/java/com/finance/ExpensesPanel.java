package com.finance;

import javax.swing.*;
import java.awt.*;

public class ExpensesPanel extends JPanel {
    private PersonalFinanceManager manager;
    private FinancialData financialData;

    public ExpensesPanel(PersonalFinanceManager manager, FinancialData financialData) {
        this.manager = manager;
        this.financialData = financialData;

        setLayout(new GridBagLayout());

        // UI Components
        JLabel expenseLabel = new JLabel("Enter Expense:");
        JTextField expenseField = new JTextField(10);
        JLabel reasonLabel = new JLabel("Reason:");
        JTextField reasonField = new JTextField(10);
        JButton addButton = new JButton("Add Expense");

        // Add components to layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0; add(expenseLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0; add(expenseField, gbc);
        gbc.gridx = 0; gbc.gridy = 1; add(reasonLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; add(reasonField, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; add(addButton, gbc);

        // Add button action listener
        addButton.addActionListener(e -> {
            try {
                double expense = Double.parseDouble(expenseField.getText());
                String reason = reasonField.getText();
                financialData.addExpense(expense, reason); // Update financial data
                JOptionPane.showMessageDialog(this, "Expense added successfully!");
                manager.switchPanel("Dashboard"); // Switch back to dashboard
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid number for expense.");
            }
        });
    }
}
