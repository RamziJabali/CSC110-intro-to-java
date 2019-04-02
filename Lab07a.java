package csc110.intro.to.java;

/**
 *
 * @author ramzijabali, date 2/14/19, class 10AM - 11AM
 * @purpose: Asks the user for the maximum value to be used, then 
 * asks he user for the interval between the number to be added into the sum.
 */
import java.util.*;

public class Lab07a {
    public static void main (String [] args){
        
        int maxNum,
            intervalToAdd,
            increments;
        
        int sum = 0,                     
            controlVariable = 0;
        
        Scanner kb = new Scanner(System.in);
        
        System.out.println("Enter the maximum number to be used: ");
            maxNum = Math.abs(kb.nextInt());
        
        System.out.println("Enter interval between numbers to add: ");
            intervalToAdd = Math.abs(kb.nextInt());
        
        increments = intervalToAdd;
        
        while(controlVariable < maxNum){
                
                System.out.println("Adding " + intervalToAdd);
               
                sum += intervalToAdd;
                intervalToAdd += increments;
                
                controlVariable += increments;
        }
        System.out.print("The sum of the number from 1 - " + maxNum +
                         " at interval, " + increments+ ", is " + sum);
    }
}
