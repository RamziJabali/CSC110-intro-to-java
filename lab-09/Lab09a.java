package com.company;

/**
 * @author ramzijabali, date: 03/17/19, time: 10AM - 11AM
 * @purpose Java application that reads the text file,input.txt, and creates
 * output file named, output.txt. The text found in output.txt has all uppercase
 * letters in input.txt as lowercase, and all lowercase letters as uppercase.
 * All numerals have been translated to words with '-' placed accordingly.
 */
import java.io.*;
import java.util.*;

public class Lab09a {
    private static final String PATH = "";//UPDATE PATH
    private static final String FILE_NAME = "output.txt";
    public static void main(String[] args) throws IOException {

        PrintWriter outputFile = new PrintWriter(FILE_NAME);
        Scanner inputFile = new Scanner(new File(PATH));
        while (inputFile.hasNext()) {
            String line = inputFile.nextLine();
            int length = line.length();
            outputFile.println(getOutputData(line, length));
        }
        inputFile.close();
        outputFile.close();
    }

    public static String getOutputData(String line, int length) {

        int i = 0;
        String output = "";
        while (i < length) {

            if (line.charAt(i) >= 48 && line.charAt(i) <= 57) {
                switch (line.charAt(i)) {
                    case '0':
                        output += "zero";
                        break;
                    case '1':
                        output += "one";
                        break;
                    case '2':
                        output += "two";
                        break;
                    case '3':
                        output += "three";
                        break;
                    case '4':
                        output += "four";
                        break;
                    case '5':
                        output += "five";
                        break;
                    case '6':
                        output += "six";
                        break;
                    case '7':
                        output += "seven";
                        break;
                    case '8':
                        output += "eight";
                        break;
                    case '9':
                        output += "nine";
                        break;
                }

            } else if (line.charAt(i) == 32) {
                output += " ";
            } else if (line.charAt(i) >= 33 && line.charAt(i) <= 47) {
                output += line.charAt(i);
            } else if (line.charAt(i) >= 65 && line.charAt(i) <= 90) {
                output += line.toLowerCase().charAt(i);
            } else if (line.charAt(i) >= 97 && line.charAt(i) <= 122) {
                output += line.toUpperCase().charAt(i);
            }


//
            if (i + 1 >= 0 && i + 1 < length) {
                if (line.charAt(i + 1) >= 48 && line.charAt(i + 1) <= 57 && line.charAt(i) >= 48 && line.charAt(i) <= 57) {
                    output += "-";
                }
            }
            i++;
        }
        return output;
    }

}
