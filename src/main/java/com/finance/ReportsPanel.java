package com.finance;

import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ReportsPanel extends JPanel {
    private FinancialData financialData;
    private JLabel incomeLabel, expenseLabel, savingsLabel;
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;

    public ReportsPanel(FinancialData financialData, PersonalFinanceManager manager) {
        this.financialData = financialData;
        setLayout(new BorderLayout());

        // Summary Panel (Income, Expense, Net Savings)
        JPanel summaryPanel = new JPanel(new GridLayout(4, 1));
        incomeLabel = new JLabel("Total Income: $0.00");
        expenseLabel = new JLabel("Total Expense: $0.00");
        savingsLabel = new JLabel("Net Savings: $0.00");
        summaryPanel.add(incomeLabel);
        summaryPanel.add(expenseLabel);
        summaryPanel.add(savingsLabel);

        // Back Button
        JButton backButton = new JButton("Back to Dashboard");
        backButton.addActionListener(e -> manager.switchPanel("Dashboard"));
        summaryPanel.add(backButton); // Add button to summary panel

        // Bar Chart (Income vs Expenses)
        dataset = new DefaultCategoryDataset();
        chart = ChartFactory.createBarChart(
                "Income and Expenses",
                "Category",
                "Amount",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );
        ChartPanel chartPanel = new ChartPanel(chart);

        // Add components to layout
        add(summaryPanel, BorderLayout.NORTH);
        add(chartPanel, BorderLayout.CENTER);

        updateReport(); // Initial data update
    }

    // This method will be called whenever income/expenses are updated
    public void updateReport() {
        double totalIncome = financialData.getTotalIncome();
        double totalExpense = financialData.getTotalExpenses();  // Correct method name
        double netSavings = financialData.getNetSavings();

        // Update summary labels
        incomeLabel.setText("Total Income: $" + String.format("%.2f", totalIncome));
        expenseLabel.setText("Total Expense: $" + String.format("%.2f", totalExpense));
        savingsLabel.setText("Net Savings: $" + String.format("%.2f", netSavings));

        // Update chart data
        dataset.clear();
        dataset.addValue(totalIncome, "Amount", "Income");
        dataset.addValue(totalExpense, "Amount", "Expenses");
        dataset.addValue(netSavings, "Amount", "Net Savings");

        chart.fireChartChanged(); // Refresh chart
    }
}
