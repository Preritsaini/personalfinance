package com.finance;

public class FinancialData {
    private double totalIncome = 0;
    private double totalExpenses = 0;

    public void addIncome(double income) {
        totalIncome += income;
    }

    public void addExpense(double expense, String reason) {
        totalExpenses += expense;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public double getNetSavings() {
        return totalIncome - totalExpenses;
    }
}
