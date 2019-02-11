//Ramzi Jabali, 10:00 am - 11:00 am, Labo04_num18
//This application makes a story after asking the user questions

import java.util.Scanner;

public class Lab04_Num18{
   public static void main (String [] args){
   Scanner kb = new Scanner(System.in);
        
   String name,
          city,
          college,
          profession,
          animal,
          petName;
   
   int age;
  
   System.out.println("Enter your Name");
   name = kb.next();
   
   System.out.println("Enter a name of a city");
   city = kb.next();
   
   System.out.println("Enter your age");
   age = kb.nextInt(); 
   
   System.out.println("Enter the name of a college");
   kb.nextLine();
   college = kb.nextLine();
   
   System.out.println("Enter the name of a profession");
   profession = kb.nextLine();
   
   System.out.println("Enter a type of animal");
   animal = kb.next();
   
   System.out.println("Enter a petname");
   kb.nextLine();
   petName = kb.nextLine(); 
   
   System.out.println("There once was a person named " + name + " who lived in " +
                      city + ". At the age of " + age + ", " + name + " graduated and "
                      + "went to work as a " + profession + ".\n Then, "
                      + name + " adopted a(n) " + animal + " named "
                      + petName + ". They both lived happily ever after!");
   
   }  
}