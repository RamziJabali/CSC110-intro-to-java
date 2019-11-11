
package javaapplication1;

/**
 *@author ramzijabali, 2/26/19 10-11 AM
 * @purpose to turn an integer into a binary number
 */
import java.util.*;

public class Lab07b_DecToBinConverter {

    public static void main(String[] args) {
        
        String num = "";
        String reversedNum = "";
        int value = 0, adjustedNum = 0, ogNumber = 0;
        
        Scanner kb = new Scanner(System.in);
            
        System.out.println("Enter a value you want in Binary");
            value = kb.nextInt();
            ogNumber = value;
            
        while (value != 0) {
            
            adjustedNum = value % 2;
            
            value /= 2;
                      
            num += Integer.toString(adjustedNum);
         
        }
         
        for (int i = num.length() - 1; i >= 0; i--) {
            reversedNum += num.charAt(i);
        }
        System.out.print(ogNumber + " decimal is "+ reversedNum +" binary");
    }
}
