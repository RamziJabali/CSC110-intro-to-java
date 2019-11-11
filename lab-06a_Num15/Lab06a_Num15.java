/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ramzijabali
 */
import java.util.*;

public class Lab06a_Num15 {

    public static void main(String[] args) {

        final String passCode = "GreatBanking";
        final double RATE_CHECKS_20 = .1;
        final double RATE_CHECKS_40 = .06;
        final double RATE_CHECKS_60 = .04;
        final double FLAT_RATE = 10;
        String passWord;

        int checksWritten;

        double totalAmount;

        Scanner kb = new Scanner(System.in);

        System.out.println("This app will determine your check fees \n"
                + "To proceed, first enter your banking password: ");
        passWord = kb.next();


        if (passWord.equals(passCode)) {

            System.out.println("Enter the number of cheeks written this month: ");
            checksWritten = kb.nextInt();

            if (checksWritten >= 20 && checksWritten < 40) {

                totalAmount = (checksWritten * RATE_CHECKS_20) + FLAT_RATE;

                System.out.print("The total fees are $" + totalAmount);

            } else if (checksWritten >= 40 && checksWritten < 60) {

                totalAmount = (checksWritten * RATE_CHECKS_40) + FLAT_RATE;

                System.out.print("The total fees are $" + totalAmount);

            } else if (checksWritten >= 60) {

                totalAmount = (checksWritten * RATE_CHECKS_60) + FLAT_RATE;

                System.out.print("The total fees are $" + totalAmount);
            } else {
                System.out.println("you can't have negative checks sorry!");
            }

        } else {

            System.out.println("sorry, wrong password. Try Again Later");

        }
    }
}
