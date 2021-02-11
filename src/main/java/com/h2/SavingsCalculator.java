package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {
    private float[] credits, debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    public static void main(String[] args) {
        // get lists of credits and debits as strings
        String[] creditsAsString = args[0].split(",");
        String[] debitsAsString = args[1].split(",");

        // convert credits to numeric values
        int creditLength = creditsAsString.length;
        float[] credits = new float[creditLength];
        for (int i = 0; i < creditLength; i++) {
            credits[i] = Utilities.getFloatValue(creditsAsString[i]);
        }

        // convert debits to numeric values
        int debitLength = debitsAsString.length;
        float[] debits = new float[debitLength];
        for (int i = 0; i < debitLength; i++) {
            debits[i] = Utilities.getFloatValue(debitsAsString[i]);
        }

        // run the savings calculator on credits and debits, then display the results
        SavingsCalculator calculator = new SavingsCalculator(credits, debits);
        float netSavings = calculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }

    public float calculate() {
        return sumOfCredits() - sumOfDebits();
    }

    private float sumOfCredits() {
        float sum = 0.0f;

        for (float credit : credits)
            sum += credit;

        return sum;
    }

    private float sumOfDebits() {
        float sum = 0.0f;

        for (float debit : debits)
            sum += debit;

        return sum;
    }

    /**
     * remainingDaysInMonth
     * @param date - current date
     * @return integer number of days remaining in the month
     */
    private static int remainingDaysInMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        return totalDaysInMonth - date.getDayOfMonth();
    }
}
