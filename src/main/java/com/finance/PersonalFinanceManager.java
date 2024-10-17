package com.finance;

import javax.swing.*;
import java.awt.*;

public class PersonalFinanceManager {
    private JFrame frame;
    private CardLayout cardLayout;
    private FinancialData financialData;
    private ReportsPanel reportsPanel;

    public PersonalFinanceManager() {
        frame = new JFrame("Personal Finance Manager");
        cardLayout = new CardLayout();
        frame.setLayout(cardLayout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        financialData = new FinancialData(); // Centralized data model

        // Initialize panels and pass financialData and this manager instance
        LoginPanel loginPanel = new LoginPanel(this);
        DashboardPanel dashboardPanel = new DashboardPanel(this);
        reportsPanel = new ReportsPanel(financialData, this); // <-- Pass 'this' as the second argument
        IncomePanel incomePanel = new IncomePanel(this, financialData);
        ExpensesPanel expensesPanel = new ExpensesPanel(this, financialData);

        SettingsPanel settingsPanel = new SettingsPanel(this);
        frame.add(settingsPanel, "Settings");


        // Add panels to the CardLayout
        frame.add(loginPanel, "Login");
        frame.add(dashboardPanel, "Dashboard");
        frame.add(reportsPanel, "Reports");
        frame.add(incomePanel, "Income");
        frame.add(expensesPanel, "Expenses");

        frame.setVisible(true);
        switchPanel("Login"); // Show the login panel initially
    }

    public void switchPanel(String panelName) {
        cardLayout.show(frame.getContentPane(), panelName);
    }

    public ReportsPanel getReportsPanel() {
        return reportsPanel;
    }

    public FinancialData getFinancialData() {
        return financialData; // Method to access financial data from other panels
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PersonalFinanceManager::new);
    }
}
