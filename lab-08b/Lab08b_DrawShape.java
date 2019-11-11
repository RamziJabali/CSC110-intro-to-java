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
         
        for(int q = 0; q < size; q++){
            for(int w = 0; w < q; w++){
            System.out.print("*");
            }
            shift -=2;
            for(int e = 0; e < shift; e++){
                System.out.print(" ");
            }
            for(int r= 0; r < q; r++){
                System.out.print("*");
            }
            System.out.println();
            
        }
               
        
        
    }
}
