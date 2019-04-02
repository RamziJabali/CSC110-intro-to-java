/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 * @author ramzijabali, date 03/04/19, 10 AM - 11AM
 * 
 * @purpose: to take positive user integer and 
 * create two triangles based on the input
 */
import java.util.*;

public class Lab08b_DrawShape {

    public static void main(String[] args) {

        int size = 0;

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter the size: ");
        size = kb.nextInt();

        int shift = size * 2;
        
        for (int r = 1; r <= size; r++) {
            for (int c = 0; c < r; c++) {
                System.out.print("*");
            }
            shift -= 2;
            for (int k = 0; k < shift; k++) {
                System.out.print(" ");
            }

            for (int j = 0; j < r; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
