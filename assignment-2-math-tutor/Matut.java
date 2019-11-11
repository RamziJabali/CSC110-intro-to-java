package javaapplication1;

/**
 * @Author: Ramzi El-Jabali, Date 3/24/19 10AM - 11AM
 * @Purpose: This app is designed to create math problems based
 * on The four basic arithmetic operations(+, - , X, /). This program
 * makes up random questions for all 4 arithmetic operations and takes the user's answers
 * and if they are correct they are logged in the tutorLogCorrect.txt file and if they are wrong
 * they are logged in the tutorLogWrong.txt file. The app also tells you the correct answers after
 * you've answered wrong to a question. This application creates two txt files(tutorLogWrong.txt &
 * tutorLogCorrect.txt) if they did not previously exist and append to them with every question answered.
 * When you run the program the application, if files are available, will prompt you two different modes
 * , review mode and normal mode, review mode goes through your tutorLogWrong.txt and asks you the questions
 * in them again and tell you whether you got the correct or incorrect, but does NOT append to neither files.
 * In normal mode you are asked randomly generated questions which depending on whether you answer correctly
 * or incorrectly will append to the tutorLogWrong.txt file and tutorLogCorrect.txt respectively.
 */

import java.util.*;
import java.io.*;

public class Matut {
    public static final String LOG_WRONG_TXT = "tutorLogWrong.txt";
    public static final String CORRECT_TXT = "tutorLogCorrect.txt";
    public static final String ERROR_MESSAGE_WRONG_FORMAT = "That is not an integer. Please try again.";
    public static final String ERROR_MESSAGE_OUT_OF_RANGE = "Enter an integer between 1 and 5";
    public static final String ERROR_MESSAGE_CHOICE_UNAVAILABLE = "You did not enter (Y/N)";
    public static final String ASK_FOR_REVIEW_MODE = "Want to use previously missed problems? (Y/N) ";
    public static final String ASK_FOR_OPERATION = "Enter your choice (1-5): ";
    public static final String CORRECT_ANSWER = "Congratulations! That's right.\n";
    public static final String INCORRECT_ANSWER = "\nSorry, the correct answer is %d.\n\n";
    public static final String LOGGED_CORRECT_ANSWER = "\nLogged correct problem.\n";
    public static final String LOGGED_INCORRECT_ANSWER = "\nLogged missed problem.";
    public static final String LONG_LINE = "------------------------------------------------------------";
    public static final String MEDIUM_LINE = "------------------------------";
    public static final String SHORT_LINE = "----";

    public static final int ADDITION = 1;
    public static final int SUBTRACTION = 2;
    public static final int MULTIPLICATION = 3;
    public static final int DIVISION = 4;
    public static final int TERMINATE = 5;

    public static final String NORMAL_MENU = "      Matut Menu \n" +
            MEDIUM_LINE + "\n" +
            "1. Addition problem" + "\n" +
            "2. Subtraction problem" + "\n" +
            "3. Multiplication problem" + "\n" +
            "4. Division problem" + "\n" +
            "5. Quit this program" + "\n" +
            MEDIUM_LINE + "\n";

    public static final String INTRO_MENU = LONG_LINE + "\n" +
            "Welcome to Matut app that can help you practice" + "\n" +
            "The four basic arithmetic operations. This app can" + "\n" +
            "make up random problems for the operation you select" + "\n" +
            "or it can quiz you using problems you previously missed." + "\n" +
            "First, you decide if you want to use the previously" + "\n" +
            "missed problems. If not, then you will be asked to" + "\n" +
            "select the operation for a brand new problem to be created." + "\n" +
            LONG_LINE + "\n";
    public static final String TERMINATING_MATUT = "Terminating Matut...\n";
    public static final String YOU_WORKED_ON_INT_PROBLEMS = "You worked on %d problems. \n";
    public static final String ADDITION_PROBLEMS = "%d addition problems \n";
    public static final String SUBTRACTION_PROBLEMS = "%d subtraction problems \n";
    public static final String MULTIPLICATION_PROBLEMS = "%d multiplication problems \n";
    public static final String DIVISION_PROBLEMS = "%d division problems \n";
    public static final String PROBLEMS_CORRECT = "You got %d problems correct! \n";
    public static final String YOUR_PERCENT_CORRECT_IS = "Your percent correct is: %.2f%% \n";
    public static final String THANK_YOU_FOR_USING_MATUT = "\nThank you for using Matut.";
    public static final String SHOW_QUESTION_NON_DIVISION = "%6d\n" + " %s" + "%4d\n" + "  %s" + "\n   ";
    public static final String SHOW_QUESTION_DIVISION = "%d / %d = ";

    public static int additionProblems;
    public static int subtractionProblems;
    public static int multiplicationProblems;
    public static int divisionProblems;
    public static int incorrectProblems;

    public static void main(String[] args) throws IOException {
        startApp();
    }

    public static void print(String text) {
        System.out.println(text);
    }

    public static void startApp() throws IOException {
        print(INTRO_MENU);
        if (hasReviewMaterial()) {
            promptReviewModeOrNormalMode();
        } else {
            promptNormalMode();
        }
    }

    public static boolean hasReviewMaterial() {
        File logWrong = new File(LOG_WRONG_TXT);
        return logWrong.exists();
    }

    public static void promptReviewModeOrNormalMode() throws IOException {
        Scanner kb = new Scanner(System.in);
        char letter;
        do {
            System.out.println(ASK_FOR_REVIEW_MODE);
            String word = kb.next();
            letter = word.toLowerCase().charAt(0);
            if (!(letter == 'n' || letter == 'y')) {
                System.out.println(ERROR_MESSAGE_CHOICE_UNAVAILABLE);
            }
        } while (!(letter == 'n' || letter == 'y'));
        if (letter == 'y') {
            startReviewMode();
        } else {
            promptNormalMode();
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          SHOW NORMAL MODE
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void promptNormalMode() throws IOException {
        print(NORMAL_MENU);

        char option;
        int choice;
        String operation;
        Scanner kb = new Scanner(System.in);
        do {
            print(ASK_FOR_OPERATION);
            operation = kb.next();
            option = operation.charAt(0);
            if (Character.isLetter(operation.charAt(0))) {
                print(ERROR_MESSAGE_WRONG_FORMAT);
            } else if (option < '1' || option > '5') {
                print(ERROR_MESSAGE_OUT_OF_RANGE);
            }
        } while (option < '1' || option > '5');

        choice = Character.getNumericValue(option);
        switch (choice) {
            case ADDITION:
                promptNormalAdditionQuestion();
                break;
            case SUBTRACTION:
                promptNormalSubtractionQuestion();
                break;
            case MULTIPLICATION:
                promptNormalMultiplicationQuestion();
                break;
            case DIVISION:
                promptNormalDivisionQuestion();
                break;
            case TERMINATE:
                showStats();
                break;
        }
    }

    public static void promptNormalAdditionQuestion() throws IOException {
        incrementProblemCounter(ADDITION);
        Random rand = new Random();

        int randOperandOne = rand.nextInt(500) + 1;
        int randOperandTwo = rand.nextInt(500) + 1;

        showQuestion(getOperatorFromInt(ADDITION), randOperandOne, randOperandTwo);

        int inputtedAnswer = getUserValidInputtedAnswer();
        int correctAnswer = getCalculationResult(ADDITION, randOperandOne, randOperandTwo);

        if (correctAnswer == inputtedAnswer) {
            showCorrectAnswer();
            logCorrectAnswer(ADDITION, randOperandOne, randOperandTwo);
        } else {
            incorrectProblems++;
            logIncorrectAnswer(ADDITION, randOperandOne, randOperandTwo);
            showIncorrectAnswer(correctAnswer);
        }
        promptNormalMode();
    }

    public static void promptNormalSubtractionQuestion() throws IOException {
        incrementProblemCounter(SUBTRACTION);
        Random rand = new Random();
        int randOperandOne;
        int randOperandTwo;

        do {
            randOperandOne = rand.nextInt(999) + 1;
            randOperandTwo = rand.nextInt(999) + 1;
        } while (randOperandOne < randOperandTwo);

        showQuestion(getOperatorFromInt(SUBTRACTION), randOperandOne, randOperandTwo);

        int inputtedAnswer = getUserValidInputtedAnswer();
        int correctAnswer = getCalculationResult(SUBTRACTION, randOperandOne, randOperandTwo);

        if (correctAnswer == inputtedAnswer) {
            showCorrectAnswer();
            logCorrectAnswer(SUBTRACTION, randOperandOne, randOperandTwo);
        } else {
            incorrectProblems++;
            logIncorrectAnswer(SUBTRACTION, randOperandOne, randOperandTwo);
            showIncorrectAnswer(correctAnswer);
        }
        promptNormalMode();
    }

    public static void promptNormalMultiplicationQuestion() throws IOException {
        incrementProblemCounter(MULTIPLICATION);
        Random rand = new Random();

        int randOperandOne = rand.nextInt(100) + 1;
        int randOperandTwo = rand.nextInt(9) + 1;

        showQuestion(getOperatorFromInt(MULTIPLICATION), randOperandOne, randOperandTwo);

        int inputtedAnswer = getUserValidInputtedAnswer();
        int correctAnswer = getCalculationResult(MULTIPLICATION, randOperandOne, randOperandTwo);

        if (correctAnswer == inputtedAnswer) {
            logCorrectAnswer(MULTIPLICATION, randOperandOne, randOperandTwo);
            showCorrectAnswer();
        } else {
            incorrectProblems++;
            logIncorrectAnswer(MULTIPLICATION, randOperandOne, randOperandTwo);
            showIncorrectAnswer(correctAnswer);
        }
        promptNormalMode();
    }

    public static void promptNormalDivisionQuestion() throws IOException {
        incrementProblemCounter(DIVISION);
        Random rand = new Random();

        int quotient = rand.nextInt(50) + 1;
        int randOperandTwo = rand.nextInt(9) + 1;
        int randOperandOne = quotient * randOperandTwo;

        showQuestion(getOperatorFromInt(DIVISION), randOperandOne, randOperandTwo);

        int inputtedAnswer = getUserValidInputtedAnswer();
        int correctAnswer = getCalculationResult(DIVISION, randOperandOne, randOperandTwo);

        if (correctAnswer == inputtedAnswer) {
            logCorrectAnswer(DIVISION, randOperandOne, randOperandTwo);
            showCorrectAnswer();
        } else {
            incorrectProblems++;
            logIncorrectAnswer(DIVISION, randOperandOne, randOperandTwo);
            showIncorrectAnswer(correctAnswer);
        }
        promptNormalMode();
    }

    public static int getUserValidInputtedAnswer() {
        Scanner kb = new Scanner(System.in);
        String sUserAnswer = kb.next();
        int i = 0;
        do {
            char cUserAnswer = sUserAnswer.charAt(i);
            if (Character.isDigit(cUserAnswer)) {
                i++;
            } else if (!(Character.isDigit(cUserAnswer))) {
                print(ERROR_MESSAGE_WRONG_FORMAT);
                sUserAnswer = kb.next();
                i = 0;
            }
        } while (i < sUserAnswer.length());

        return Integer.parseInt(sUserAnswer);
    }

    public static void showQuestion(String operation, int operandOne, int operandTwo) {
        if (!"/".equals(operation)) {
            System.out.printf(SHOW_QUESTION_NON_DIVISION, operandOne, operation, operandTwo, SHORT_LINE);
        } else {
            System.out.printf(SHOW_QUESTION_DIVISION, operandOne, operandTwo);
        }
    }

    public static void showCorrectAnswer() {
        print(CORRECT_ANSWER);
    }

    public static void showIncorrectAnswer(int correctAnswer) {
        System.out.printf(INCORRECT_ANSWER, correctAnswer);
    }

    public static void logIncorrectAnswer(int operation, int operandOne, int operandTwo) throws IOException {
        FileWriter fileWriterLogWrong = new FileWriter(LOG_WRONG_TXT, true);
        PrintWriter printWriterLogWrong = new PrintWriter(fileWriterLogWrong);

        printWriterLogWrong.println(operation + " " + operandOne + " " + operandTwo);
        printWriterLogWrong.close();
        print(LOGGED_INCORRECT_ANSWER);
    }

    public static void logCorrectAnswer(int operation, int operandOne, int operandTwo) throws IOException {
        FileWriter fileWriterLogCorrect = new FileWriter(CORRECT_TXT, true);
        PrintWriter printWriterLogCorrect = new PrintWriter(fileWriterLogCorrect);

        printWriterLogCorrect.println(operation + " " + operandOne + " " + operandTwo);
        printWriterLogCorrect.close();
        print(LOGGED_CORRECT_ANSWER);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          SHOW REVIEW MODE
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void showStats() {
        final int totalProblems = additionProblems + subtractionProblems + multiplicationProblems + divisionProblems;
        final int correctProblems = totalProblems - incorrectProblems;
        double correctPercentage = ((double) correctProblems) / ((double) totalProblems) * 100D;

        print(TERMINATING_MATUT);
        System.out.printf(YOU_WORKED_ON_INT_PROBLEMS, totalProblems);
        System.out.printf(ADDITION_PROBLEMS, additionProblems);
        System.out.printf(SUBTRACTION_PROBLEMS, subtractionProblems);
        System.out.printf(MULTIPLICATION_PROBLEMS, multiplicationProblems);
        System.out.printf(DIVISION_PROBLEMS, divisionProblems);
        System.out.printf(PROBLEMS_CORRECT, correctProblems);
        System.out.printf(YOUR_PERCENT_CORRECT_IS, correctPercentage);
        print(THANK_YOU_FOR_USING_MATUT);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          SHOW REVIEW MODE
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void startReviewMode() throws IOException {
        File logWrong = new File(LOG_WRONG_TXT);
        Scanner readLogWrong = new Scanner(logWrong);

        while (readLogWrong.hasNext()) {
            final String line = readLogWrong.nextLine();
            final String operatorAsString = line.charAt(0) + "";
            final int operatorAsInt = Integer.parseInt(operatorAsString);

            final String operandOneAsString = getUntilNonNumber(line, 2);
            final String operandSecondAsString = getUntilNonNumber(line, 1 + operandOneAsString.length());

            final int operandOneAsInt = Integer.parseInt(operandOneAsString);
            final int operandTwoAsInt = Integer.parseInt(operandSecondAsString);

            showQuestion(getOperatorFromInt(operatorAsInt), operandOneAsInt, operandTwoAsInt);
            incrementProblemCounter(operatorAsInt);

            final int inputtedAnswer = getUserValidInputtedAnswer();
            final int correctAnswer = getCalculationResult(operatorAsInt, operandOneAsInt, operandTwoAsInt);
            if (correctAnswer == inputtedAnswer) {
                showCorrectAnswer();
            } else {
                incorrectProblems++;
                showIncorrectAnswer(correctAnswer);
            }
        }
        showStats();
    }

    public static int getCalculationResult(int operation, int operandOne, int operandTwo) {
        switch (operation) {
            case ADDITION:
                return operandOne + operandTwo;
            case SUBTRACTION:
                return operandOne - operandTwo;
            case MULTIPLICATION:
                return operandOne * operandTwo;
            case DIVISION:
                return operandOne / operandTwo;
            default:
                return -1;
        }
    }

    public static void incrementProblemCounter(int operation) {
        switch (operation) {
            case ADDITION:
                additionProblems++;
                break;
            case SUBTRACTION:
                subtractionProblems++;
                break;
            case MULTIPLICATION:
                multiplicationProblems++;
                break;
            case DIVISION:
                divisionProblems++;
                break;
            default:
                break;
        }

    }

    public static String getUntilNonNumber(String sampleInputLine, int i) {
        String result = "";
        char currentChar = sampleInputLine.charAt(i);
        while (Character.isDigit(currentChar)) {
            result += currentChar;
            i++;
            currentChar = sampleInputLine.charAt(i);
        }
        return result;
    }

    public static String getOperatorFromInt(int operator) {
        switch (operator) {
            case ADDITION:
                return "+";
            case SUBTRACTION:
                return "-";
            case MULTIPLICATION:
                return "X";
            case DIVISION:
                return "/";
            default:
                return "";
        }
    }

}

