//Ramzi Jabali, CSC110 10:00 - 10:50, Lab02, 
//This applicatin calculates the users county and state tax and add it to their total amount

import java.util.Scanner;

public class Lab02{
   public static void main (String [] args){
      Scanner kb = new Scanner(System.in);
      
      double stateTax, countyTax, totalTax, totalCost, purchaseAmt;
      
      //constants
      final double COUNTY_TAX = .02; 
      final double STATE_TAX = .04;
      
      //asks user for input
      System.out.println("Enter the purchase amount: ");
      purchaseAmt = kb.nextDouble();  
      
      //displays purchase Amount
      System.out.println("Purchase Amount: " + purchaseAmt);
      
      //calculates state tax and displays it
      stateTax = purchaseAmt * STATE_TAX;
      System.out.println("State tax: " + stateTax);
      
      //calculates county tax and displays it
      countyTax = purchaseAmt * COUNTY_TAX;
      System.out.println("County tax: " + countyTax);
      
      //calulates total tax by adding both tax categories
      totalTax = countyTax + stateTax;     
      System.out.println("Total tax: " + totalTax);
      
      //calculates total cost by adding total tax with purchase amount 
      totalCost = totalTax + purchaseAmt;
      System.out.println("Total cost: "  + totalCost);
   }
}