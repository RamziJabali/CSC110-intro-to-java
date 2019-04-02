package javaapplication1;

/**
 * @author: ramzijabali Date: 3/3/2019 10AM - 11AM
 * @purpose:Calculator of final balance on investment given
 */
import java.util.*;

public class Lab08a {

    public static void main(String[] args) {

        double startingBalance = 0;
        double endingBalance = 0;
        double initialValue = 0;
        double interest = 0;
        double accumInterest;
        double annualInterestRate;

        int numberOfYears = 0;

        boolean hasInputError = false;

        Scanner kb = new Scanner(System.in);

        
        System.out.println("Calculator of final balance on investment given:\n"
                + "\tyears, intital balance, and annual interest rate... ");
        
        System.out.println("Enter number of years: ");
        numberOfYears = kb.nextInt();

        do {

            if (numberOfYears <= 0) {
                hasInputError = true;

                if (hasInputError) {
                    System.out.println("Input Error: Number of years have to be 1 or more");
                    System.out.println("Enter number of years: ");
                    numberOfYears = kb.nextInt();

                    if (numberOfYears > 0) {
                        hasInputError = false;
                    }
                }
            }
            if (!hasInputError) {
                System.out.println("Enter initial balance: ");
                startingBalance = kb.nextDouble();
                initialValue = startingBalance;

                if (startingBalance <= 0) {
                    hasInputError = true;
                    System.out.println("Input Error: Intial Balance has to be greater than zero");

                    System.out.println("Enter initial balance: ");
                    startingBalance = kb.nextDouble();
                    initialValue = startingBalance;

                    if (initialValue > 0) {
                        hasInputError = false;
                    }
                }
            }

            if (!hasInputError) {
                System.out.println("Enter interest rate: ");
                interest = kb.nextDouble();

                if (interest < 0 || interest > 1) {
                    hasInputError = true;
                    System.out.println("Input Error: Interest Rate has to be 0 or 1 inclusive");
                    System.out.println("Enter interest rate: ");
                    interest = kb.nextDouble();

                    if (interest >= 0 && interest <= 1) {
                        hasInputError = false;
                    }
                }
            }

        } while (hasInputError);

        System.out.println("Year   Starting Bal    Ending Bal    Accum. Interest");

        for (int i = 1; i <= numberOfYears; i++) {

            annualInterestRate = startingBalance * interest;

            endingBalance = annualInterestRate + startingBalance;

            accumInterest = endingBalance - initialValue;

            System.out.printf("%2d" + "%15.2f" + "%14.2f" + "%14.2f" + "\n", i, startingBalance, endingBalance, accumInterest);

            startingBalance += annualInterestRate;
        }
    }
}
