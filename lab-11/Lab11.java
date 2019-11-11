package com.company;

/**
 * @author: Ramzi ElJabali, Date 3/27/19, 10AM -11AM
 * @purpose: To check if words from the words.txt file match the characters and length
 * assigned by the user. If words do match they are printed for the user to see them
 */

import java.io.*;
import java.util.*;

public class Lab11 {
    private static final String ERROR_MESSAGE_WRONG_FORMAT_STRING = "This is not a String \n Try Again";
    private static final String ERROR_MESSAGE_WRONG_FORMAT_INT = "This is not an Integer \n Try Again";
    private static final String ERROR_MESSAGE_OUT_OF_BOUND = "Enter an Integer between 1 and 6 \n Try Again";
    private static final String PATH = "/Users/ramzijabali/Code/Matut/src/com/company/words.txt";

    private static Scanner kb = new Scanner(System.in);
    private static File word = new File(PATH);


    public static String characters;
    public static String substring = "";
    public static int length;
    public static int numOfWords;

    public static void main(String[] args) throws IOException {
        setStringAndsetLength();
    }

    public static void setStringAndsetLength() throws IOException {
        print("Enter the possible letters in your word: ");
        characters = getUserValidInputtedAnswerForString();
        print("Enter the number of letters in your target words: ");
        length = getUserValidInputtedAnswerForInt();
        setSubString();
        displayAnagram();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          DISPLAYS RESULT
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void displayAnagram() {
        print("List of all " + length + "-letter words formed from the letters, \n" + characters + ":");
        print(substring);
        print("End of list: " + numOfWords + " words found");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          INITIALIZES SUBSTRING
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void setSubString() throws IOException {
        substring = getAnagram();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          GETS THE WORDS
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String getAnagram() throws IOException {
        String line;
        Scanner readFileWord = new Scanner(word);

        while (readFileWord.hasNextLine()) {
            String temporary = characters;
            line = readFileWord.nextLine();//aha, aahead
            int lineLength = line.length();
            if (lineLength == length) {//3 != 4 , 6 != 4 ... etc until 4 == 4
                if (hasCharacters(line, temporary)) {
                    numOfWords++;
                    substring += "\t" + numOfWords + " " + line + "\n";
                }
            }
        }
        return substring;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          CHECKS OF THE WORDS ARE VALID
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static Boolean hasCharacters(String line, String temporary) {
        for (int i = 0; i < length; i++) {
            int j = 0;
            while (j < temporary.length()) {
                char letterAtIndex = temporary.charAt(j);
                String letter = letterAtIndex + "";
                if (letterAtIndex != line.charAt(i)) {
                    if (j + 1 == temporary.length()) {
                        return false;
                    }
                    j++;
                } else if (letterAtIndex == line.charAt(i)) {
                    if (characters.length() < length) {
                        j = temporary.length();
                    } else {

                        temporary = temporary.replaceFirst(letter, "");//new
                        j = temporary.length();
                    }
                }
            }
        }
        return true;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          PRINTS
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void print(String x) {
        System.out.println(x);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          VALIDATORS
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static int getUserValidInputtedAnswerForInt() {
        String sUserAnswer = kb.next();
        int i = 0;
        do {
            char cUserAnswer = sUserAnswer.charAt(i);
            if (Character.isDigit(cUserAnswer)) {
                i++;
            } else if (!(Character.isDigit(cUserAnswer))) {
                print(ERROR_MESSAGE_WRONG_FORMAT_INT);
                sUserAnswer = kb.next();
                i = 0;
            }
            if (Integer.parseInt(sUserAnswer) < 0 || Integer.parseInt(sUserAnswer) > 6) {
                print(ERROR_MESSAGE_OUT_OF_BOUND);
                sUserAnswer = kb.next();
                i = 0;
            }
        } while (i < sUserAnswer.length());
        return Integer.parseInt(sUserAnswer);
    }

    public static String getUserValidInputtedAnswerForString() {
        String sUserAnswer = kb.next().toLowerCase();
        int i = 0;
        do {
            char cUserAnswer = sUserAnswer.charAt(i);
            if (Character.isLetter(cUserAnswer)) {
                i++;
            } else if (Character.isDigit(cUserAnswer)) {
                print(ERROR_MESSAGE_WRONG_FORMAT_STRING);
                sUserAnswer = kb.next();
                i = 0;
            }
        } while (i < sUserAnswer.length());

        return sUserAnswer;
    }
}
