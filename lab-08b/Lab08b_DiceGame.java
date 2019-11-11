
/**
 * @author ramzijabali, date 03/04/19, 10 AM - 11AM
 * 
 * @purpose: This program generates a random number from 1-6 inclusive
 * and keeps repeating until the sum of the random numbers is 7
 * this is done 4 times and the biggest sum is saved and displayed
 * at the end
 */
import java.util.*;

public class Lab08b_DiceGame {

    public static void main(String[] args) {

        final int ROUNDS = 4;
        int roll1;
        int roll2;
        int sum = 0;
        int maxSum = 0;
        int controlVariable = 0;
        
        boolean isNotSeven = false;

        Scanner kb = new Scanner(System.in);
        Random rand = new Random();

        for (int i = 0; i < ROUNDS; i++) {

            do {
                roll1 = rand.nextInt(6) + 1;
                roll2 = rand.nextInt(6) + 1;

                System.out.println("Rolled " + roll1 + " and " + roll2);

                if (roll1 + roll2 != 7) {

                    sum += roll1 + roll2;

                } else {

                    isNotSeven = true;

                }

            } while (!isNotSeven);

            isNotSeven = false;

            System.out.println("Sum of rolls before rolling out " + sum);

            if (sum > maxSum) {
                maxSum = sum;
            }

            sum = 0;
        }
        System.out.println("Best round had a dice sum of " + maxSum);
    }
}
