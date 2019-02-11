//Ramzi El-Jabali , date: 1/31/19 , class time 10:00 -10:50 am  
//This application will compute the volume and the surface area for each of the 4 different 
//solid shapes.

import java.lang.Math;
import java.util.Scanner;

public class Lab05A {

    public static void main(String[] args) {
        
        Scanner kb = new Scanner(System.in);

        //declaring all variables for all solids
        double length,
                width,
                height,
                radius,
                hypotenuse;
        //declaring calculation variables
        double volume,
                surfaceArea;

        String solid;

        char firstLetter;

        System.out.print("Enter A for rectangular solid, B for cylinder, C for Sphere, and D for cone: ");
        solid = kb.next().toUpperCase();
        firstLetter = solid.charAt(0);

        if (firstLetter == 'A') {

            //RECTANGULAR SOLID
            //grabbing input of the user for variables length, width, and height for RECTANGULAR SOLID
            System.out.println("Enter the length of the rectangular solid: ");
            length = kb.nextDouble();

            System.out.println("Enter the width of the rectangular solid: ");
            width = kb.nextDouble();

            System.out.println("Enter the height of the rectangular solid: ");
            height = kb.nextDouble();

            //calculations for RECTANGULAR SOLID
            volume = length * width * height;
            surfaceArea = 2 * (length * width) + 2 * (height * width) + 2 * (length * height);

            //displaying volume followed by surface area
            System.out.println("Rectanglar solid data");
            System.out.printf("\t Volume = %.3f \n ", volume);
            System.out.printf("\t Surface Area = %.3f \n \n", surfaceArea);

        } else if (firstLetter == 'B') {

            //CYLINDER 
            //grabbing input of the user for variables radius and height for CYLINDER
            System.out.println("Enter the radius of the cylinder: ");
            radius = kb.nextDouble();

            System.out.println("Enter the height of the cylinder: ");
            height = kb.nextDouble();

            //calculations for a CYLINDER
            volume = Math.PI * Math.pow(radius, 2) * height;
            surfaceArea = 2 * (Math.PI * radius * height) + 2 * (Math.PI * Math.pow(radius, 2));

            //displaying volume followed by surface area
            System.out.println("Cylinder data");
            System.out.printf("\t Volume = %.3f \n ", volume);
            System.out.printf("\t Surface Area = %.3f \n \n", surfaceArea);
        } else if (firstLetter == 'C') {
            //SPHEREA
            //grabbing input of the user for variable Radius for the SPHERE
            System.out.println("Enter the radius of the sphere: ");
            radius = kb.nextDouble();

            //calculations for a SPHERE
            volume = (Math.PI * Math.pow(radius, 3) * ((double) 4 / 3));//1.33333333333
            surfaceArea = 4 * Math.PI * Math.pow(radius, 2);

            //displaying volume followed by surface area
            System.out.println("Sphere data");
            System.out.printf("\t Volume = %.3f \n ", volume);
            System.out.printf("\t Surface Area = %.3f \n \n", surfaceArea);

        } else if (firstLetter == 'D') {
            //CONE 
            //grabbing input of the user for variables radius and height for CONE
            System.out.println("Enter the height of the cone: ");
            height = kb.nextDouble();

            System.out.println("Enter the radius of the cone: ");
            radius = kb.nextDouble();

            //calculations for a CONE
            volume = ((double) 1 / 3) * (Math.PI * Math.pow(radius, 2)) * height;//0.33333333333
            hypotenuse = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
            surfaceArea = hypotenuse * (Math.PI * radius) + (Math.PI * Math.pow(radius, 2));

            //displaying volume followed by surface area
            System.out.println("Cone data");
            System.out.printf("\t Volume = %.3f \n ", volume);
            System.out.printf("\t Surface Area = %.3f \n ", surfaceArea);

        } else{
            System.out.print("Enter correct letter");
        }
    }
}
