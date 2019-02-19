<<<<<<< HEAD
/*
*@Author: Ramzi eljabali, date 2/14/19, class 10AM - 11AM
*
*@purpose: grabs the names of three runners and their running 
*time. puts them in order from lowest time to highest time
**/

import java.util.*;

public class Lab06b {

    public static void main(String[] args) {

        String name1,
                name2,
                name3;

        double time1,
                time2,
                time3,
                lowestTime,
                secondLowest,
                highestTime;

        Scanner kb = new Scanner(System.in);

        System.out.println("This program displays the first, second, and third\n"
                + " place runners in a race. No ties, please.\n\n");

        System.out.println("Enter the first runners name name: ");
        name1 = kb.next();
        System.out.println("Enter the time of the first runner: ");
        time1 = kb.nextDouble();

        System.out.println("Enter the second runners name name: ");
        name2 = kb.next();

        System.out.println("Enter the time of the second runner: ");
        time2 = kb.nextDouble();

        System.out.println("Enter the third runners name name: ");
        name3 = kb.next();

        System.out.println("Enter the time of the third runner: ");
        time3 = kb.nextDouble();

        if (time1 < time2 && time1 < time3) {

            if (time2 < time3) {

                System.out.println("1st place: " + name1);
                System.out.println("2nd place: " + name2);
                System.out.println("3rd place: " + name3);

            } else {

                System.out.println("1st place: " + name1);
                System.out.println("2nd place: " + name3);
                System.out.println("3rd place: " + name2);
            }

        } else if (time2 < time1 && time2 < time3) {

            if (time1 < time3) {

                System.out.println("1st place: " + name2);
                System.out.println("2nd place: " + name1);
                System.out.println("3rd place: " + name3);

            } else {

                System.out.println("1st place: " + name2);
                System.out.println("2nd place: " + name3);
                System.out.println("3rd place: " + name1);
            }

        } else if (time3 < time1 && time3 < time2) {

            if (time1 < time2) {

                System.out.println("1st place: " + name3);
                System.out.println("2nd place: " + name1);
                System.out.println("3rd place: " + name2);

            } else {

                System.out.println("1st place: " + name3);
                System.out.println("2nd place: " + name2);
                System.out.println("3rd place: " + name1);

            }
        }
        System.out.print("Done. Thanks for running the race!");

    }
}
