
/**
 * Author @Ramzi Jabali, class 10:00AM - 11:00AM
 * this program accepts the coordinates in double for a point on
 * the Cartesian plane and displays a message stating whether it
 * is inside the triangle described. The second part asks the user
 * for three points and it will tel the user whether it is collinear
 */
import java.lang.Math;
import java.util.Scanner;

public class Lab05b {

    public static void main(String[] args) {

        //all constants
        final double XAXIS_1 = 0;//X
        final double YAXIS_1 = 0;//Y
        final double XAXIS_2 = 200;//X
        final double YAXIS_2 = 0;//Y
        final double XAXIS_3 = 0;//X
        final double YAXIS_3 = 100;//Y
        final double TOTAL_AREA = ((XAXIS_1 * (YAXIS_2 - YAXIS_3) + XAXIS_2 * (YAXIS_3 - YAXIS_1)
                + XAXIS_3 * (YAXIS_1 - YAXIS_2)) / 2.0);
        
        //all variables
        double xAxis;
        double yAxis;
        double xAxis2;
        double yAxis2;
        double xAxis3;
        double yAxis3;
        double A1;
        double A2;
        double A3;
        double slope1;
        double slope2;
        double sumOfAreas;

        //object type scanner
        Scanner kb = new Scanner(System.in);

        System.out.println("Part 1: ");

        System.out.println("Enter coordinates of a point and I will tell"
                + "you \n \t whether that point lies in the triangle:"
                + "(0,0), (200,0), (0,100):");

        System.out.println("You x and y coordinates with a space between them: ");
        xAxis = kb.nextDouble();
        yAxis = kb.nextDouble();

        //calculations
        A1 = Math.abs((xAxis * (YAXIS_2 - YAXIS_3) + XAXIS_2 * (YAXIS_3 - yAxis)
                + XAXIS_3 * (yAxis - YAXIS_2)) / 2.0);

        A2 = Math.abs((XAXIS_1 * (yAxis - YAXIS_3) + xAxis * (YAXIS_3 - YAXIS_1)
                + XAXIS_3 * (YAXIS_1 - yAxis)) / 2.0);

        A3 = Math.abs((XAXIS_1 * (YAXIS_2 - yAxis) + XAXIS_2 * (yAxis - YAXIS_1)
                + xAxis * (YAXIS_1 - YAXIS_2)) / 2.0);

        sumOfAreas = (A1 + A2 + A3);

        //checking if expression is true
        if (TOTAL_AREA == sumOfAreas) {
            System.out.println("your point (" + xAxis + " , " + yAxis + ") IS in the triangle\n\n");
        } else {
            System.out.println("your point (" + xAxis + " , " + yAxis + ") IS NOT in the triangle\n\n");
        }

        System.out.println("Part 2:");
        System.out.println("Enter coordinates of 3 points and I will tell"
                + " you \n \t whether those points are collinear: ");

        //Asking for input
        System.out.println("Enter the X and Y coordinates of the first point with a space between them: ");
        xAxis = kb.nextDouble();
        yAxis = kb.nextDouble();

        System.out.println("Enter the X and Y coordinates of the second point with a space between them: ");
        xAxis2 = kb.nextDouble();
        yAxis2 = kb.nextDouble();

        System.out.println("Enter the X and Y coordinates of the third point with a space between them: ");
        xAxis3 = kb.nextDouble();
        yAxis3 = kb.nextDouble();

        //calculating slopes
        slope1 = (yAxis2 - yAxis) / (xAxis2 - xAxis);
        slope2 = (yAxis3 - yAxis2) / (xAxis3 - xAxis2);

        //checking if expressions are true
        if (slope1 == slope2) {
            System.out.println("They are collinear");
        } else {
            System.out.print("They are not Collinear");
        }
    }
}
