package javaapplication1;

/**
 *@author ramzijabali, 2/26/19 10-11 AM
 * *purpose this program checks if a word is a palindrome
 */
import java.util.*;

public class Lab07b_PalindromeTester {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.println("Enter a word");
        String word = kb.next();

        String reverse = "";
                
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }

        if (reverse.equalsIgnoreCase(word)) {
            System.out.println("The input Sring, " + word + ", is a palindrome");
        } else {
            System.out.println("The input Sring, " + word + ", is NOT a palindrome");
        }
    }
}
