package com.company;
/**
 * @Author:Ramzi El-Jabali, date 3/26.19, 10AM - 11AM
 *
 * @Purpose: This application does 4 different methods power, sumDigits, substring, and devowel.
 * Method power takes two user integers and returns he value of the first integer raised
 * to the power of the second.
 * Method sumDigit takes one integer and returns an integerthat is the sum of the digits
 * contained in the formal parameter's value.
 * Method substring returns a String containing a substring of the String that begins with
 * the character at Index start and ends at Index stop.
 * Method devowel takes a String value and returns the same String value without vowels.
 */

import java.util.*;

public class Lab10 {
    public static void main(String args[]) {
        Scanner kb = new Scanner(System.in);
        //power method//
        System.out.println("Enter an exponent ");
        int y = kb.nextInt();
        System.out.println("Enter a number you want to be raised to the power of " + y);
        int x = kb.nextInt();
        System.out.printf("%d raised to the power of %d is %d \n", x, y, power(x, y));

        //SUMDIGITS METHOD//
        System.out.println("Enter a number and I'll add every number in it together and give you a total ");
        x = kb.nextInt();
        System.out.printf("Sum of the digits in %d is %d\n", x, sumOfDigits(x));

        //substring method
        System.out.println("Enter a word ");
        String s = kb.next();
        System.out.println("Enter the character location you want to start at and what character location you want to end at, with spaces ex:(1 4))\n" +
                "and I'll give you a word from the range you gave me: ");
        int start = kb.nextInt();
        int stop = kb.nextInt();
        System.out.printf("Substring of <%s> from index %d up to index %d: %s.\n" ,s, start, stop, substring(s, start, stop));

        //devowel method
        System.out.println("Enter a string and I'll remove the vowels for you: ");
        s =kb.next();
        System.out.printf("%s devoweled became: %s.\n", s,deVowel(s));

    }


    public static int power(int x, int y) {
        if (x < 0 || y < 0) {
            return x;
        }
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }

    public static int sumOfDigits(int x) {
        int i = getHighestExponentValue(x);
        int quotient;
        int remainder = x;
        int result = 0;
        for(int j = i; j >= 0; j--){
           quotient = remainder / power(10, j);
           remainder = remainder % (power(10, j) * quotient);
           result += quotient;
        }
        return result;
    }

    public static int getHighestExponentValue(int number) {
        int i = 0;
        while(number!=0){
            number /= 10;
            i++;
        }
        return i -1;
    }

    public static String substring(String s, int start, int stop){
        if(!(start > 0 && start < s.length() - 1 ||stop > 0 && start < s.length())){
            return null;
        }

        String substring = "";
        while (start < stop){
            char letterAt = s.charAt(start);
            substring += letterAt;
            start++;
        }
        return substring;
    }

    private static String deVowel(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i++){
            char letterAt = s.charAt(i);
            if(letterAt == 'a' || letterAt == 'e'|| letterAt == 'i' || letterAt == 'o' || letterAt == 'u' ||letterAt == 'A' || letterAt == 'E'|| letterAt == 'I' || letterAt == 'O' || letterAt == 'U'){
                result +="";
            }else{
                result += letterAt;
            }
        }
        return result;
    }

}


