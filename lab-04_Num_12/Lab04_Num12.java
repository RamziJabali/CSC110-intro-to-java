//Ramzi Jabali, 10:00 am - 11:00 am, Labo04_num12
//This application takes your input and makes it capital, lowercase, 
//and tells you how many characters there are, and the first character

import java.util.Scanner;

public class Lab04_Num12{
   public static void main(String [] args){
   
   Scanner kb = new Scanner(System.in);
   
   String  city, 
           cityLowerCase,
           cityUpperCase;
           
   int cityLength;
   
   char cityChar;
            
   System.out.println("What's your favorite city?");
   city = kb.next();
   
   cityLowerCase = city.toLowerCase();   
   cityUpperCase = city.toUpperCase();   
   cityLength = city.length();
   cityChar = city.charAt(0);
   
   System.out.println("\tThis is your favorite city in Lower Case " + cityLowerCase);
   System.out.println("\tThis is your favorite city in Upper Case " + cityUpperCase);
   System.out.println("\tThis is your favorite cities character length" + cityLength);
   System.out.println("\tThis is your favorite cities first letter " + cityChar);

   
   
   }
}