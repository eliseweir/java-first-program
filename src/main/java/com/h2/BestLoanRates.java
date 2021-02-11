package com.h2;

import java.util.Map;
import java.util.Scanner;

public class BestLoanRates {
    public static final Map<Integer, Float> bestRates = Map.of(1, 5.50f, 2, 3.45f, 3, 2.67f);

    public static void main(String[] args) {
        // initialize the scanner API
        Scanner scanner = new Scanner(System.in);

        // read in user name
        System.out.println("Enter your name");
        String name = scanner.nextLine();

        // print out user name
        System.out.println("Hello " + name);

        // find the best interest rate for a given loan term
        System.out.println("Enter the loan term (in years)");
        int loanTermInYears = scanner.nextInt();
        float bestRate = getRates(loanTermInYears);

        // display the best interest rate
        if (Float.compare(bestRate, 0.0f) == 0)
            System.out.println("No available rates for term: " + loanTermInYears + " years");
        else
            System.out.println("Best Available Rate: " + bestRate + "%");

        // clean up scanner
        scanner.close();
    }

    public static float getRates(int loanTermInYears) {
        return bestRates.getOrDefault(loanTermInYears, 0.0f);
    }
}
