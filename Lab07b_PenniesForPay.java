
/**
 *@author ramzijabali, 2/26/19 10-11 AM
 * @purpose: calculates the amount a person would earn over
 * a period of time if the person's salary is one penny the first day,
 * then doubles everyday.
 */
import java.util.*;

public class Lab07b_PenniesForPay {

    public static void main(String[] args) {

        final double PENNY = 0.01;

        int control = 1;

        double moneyEarned = PENNY;

        int days;
        
        double sum = 0;

        Scanner kb = new Scanner(System.in);

        System.out.println("For how many days will you work? ");
        days = kb.nextInt();

        while (days < 1) {
            System.out.println("The number of days must be atleast 1 \n"
                    + "Enter the number of days: ");
            days = kb.nextInt();
        }

        System.out.println("Day\tPennies Earned");

        while (control <= days) {

            System.out.printf("%3d" + "\t" + "%13.2f\n", control, moneyEarned);

            control++;
            
            sum += moneyEarned;
            
            moneyEarned *= 2;

        }
        System.out.printf("Total Pay: $" + "%,.2f", sum);
    }
}
