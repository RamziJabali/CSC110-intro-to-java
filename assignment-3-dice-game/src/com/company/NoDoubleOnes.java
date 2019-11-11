package com.company;

import java.util.*;

public class NoDoubleOnes {
    private PairOfDice pairOfDice = new PairOfDice();

    private static final int MAX_ROLLS_PER_TURN = 5;
    private static final int POINTS_TO_WIN = 150;
    private static final int BOT_MAX_POINTS_PER_ROUND = 20;

    private static final String PRESS_ENTER = "press ENTER to continue";
    private static final String COMPUTERS_TURN = "Computer's turn:";
    private static final String HUMANS_TURN = "'s turn:";
    private static final String ROLL_AGAIN = "Roll again? (y/n) ";
    private static final String CURRENT_SCORE = "\tCurrent score for this turn: ";
    private static final String END_OF_TURN = "CURRENT GAME SCORE: Computer: ";
    private static final String ROLLED_SNAKE_EYES = "\tRolled snake eyes! All turn points will be doubled.";
    private static final String BOX_CARS = "\tRolled box cars! All points are gone now!";
    private static final String DOUBLES = "\tRolled double. . . lose all turn points.";

    private int totalPointsHuman;
    private int totalTurnsHuman;
    private int currentTurnPointsHuman;

    private int totalPointsBot;
    private int totalTurnsBot;
    private int currentTurnPointsBot;

    private int snakeEyesCounter;

    private String humanName;

    private static Scanner rd = new Scanner(System.in);


    public void init(String name) {
        humanName = name;
    }


    public void playGame() {
        do {
            botTurn();
            printCurrentGameScore();
            enterToContinueToNextTurn();
            humanTurn();
            printCurrentGameScore();
            enterToContinueToNextTurn();
        } while (!didPlayerWinGame(true) && !didPlayerWinGame(false));
        boolean isHumanVictor = didPlayerWinGame(true);
        endGame(isHumanVictor);
    }

    /*****************
     *
     *   BOT CODE
     *
     *****************/

    private void botTurn() {
        int currentNumberOfRollsInTurn = 0;
        snakeEyesCounter = 0;
        currentTurnPointsBot = 0;
        totalTurnsBot++;
        print(COMPUTERS_TURN);
        do {
            pairOfDice.rollPairOfDice();
            currentNumberOfRollsInTurn++;
            addPointsForRoll(false);
            if (isEndOfTurnForBot(currentNumberOfRollsInTurn)) {
                addPointsForTurn(false);
            }
            boolean botWon = didPlayerWinGame(false);
            if (botWon) {
                endGame(false);
                return;
            }
        } while (!isEndOfTurnForBot(currentNumberOfRollsInTurn));
    }


    private boolean isEndOfTurnForBot(int botRolls) {
        if (pairOfDice.isBoxCars() || pairOfDice.isDoubles()) {
            return true;
        }
        return botRolls == MAX_ROLLS_PER_TURN || currentTurnPointsBot >= BOT_MAX_POINTS_PER_ROUND;
    }

    /******************
     *
     *   HUMAN CODE
     *
     *****************/

    private void humanTurn() {
        int currentNumberOfRollsInTurn = 0;
        snakeEyesCounter = 0;
        currentTurnPointsHuman = 0;
        totalTurnsHuman++;
        boolean isEndOfTurn;
        print(humanName + HUMANS_TURN);
        do {
            pairOfDice.rollPairOfDice();
            currentNumberOfRollsInTurn++;
            addPointsForRoll(true);
            isEndOfTurn = endOfTurnHuman(currentNumberOfRollsInTurn);
            if (isEndOfTurn) {
                addPointsForTurn(true);
            }
            boolean humanWon = didPlayerWinGame(true);
            if (humanWon) {
                endGame(true);
                return;
            }
        } while (!isEndOfTurn);
    }


    private boolean endOfTurnHuman(int humanRolls) {
        if (humanRolls == MAX_ROLLS_PER_TURN) {
            return true;
        }
        if (pairOfDice.isBoxCars() || pairOfDice.isDoubles()) {
            return true;
        }
        String userChoice;
        do {
            print(ROLL_AGAIN);
            userChoice = rd.next();
        } while (!(userChoice.equalsIgnoreCase("y") || userChoice.equalsIgnoreCase("n")));
        return userChoice.equalsIgnoreCase("n");
    }

    /******************
     *
     *   MISC
     *
     *****************/

    private void enterToContinueToNextTurn() {
        print(PRESS_ENTER);
        rd.nextLine();
    }

    private void addPointsForRoll(boolean isHuman) {
        if (pairOfDice.isBoxCars()) {
            snakeEyesCounter = 0;
            if (isHuman) {
                currentTurnPointsHuman = 0;
                totalPointsHuman = 0;
            } else {
                currentTurnPointsBot = 0;
                totalPointsBot = 0;
            }
            print(BOX_CARS);
            return;
        }
        if (pairOfDice.isDoubles()) {
            snakeEyesCounter = 0;
            if (isHuman) {
                currentTurnPointsHuman = 0;
            } else {
                currentTurnPointsBot = 0;
            }
            print(DOUBLES);
            return;
        }
        if (pairOfDice.isSnakeEyes()) {
            print(ROLLED_SNAKE_EYES);
            snakeEyesCounter++;
        }
        if (isHuman) {
            currentTurnPointsHuman += pairOfDice.getValuesOfRolls();
            if (pairOfDice.isRegularPair()) {
                print(CURRENT_SCORE + currentTurnPointsHuman);
            }
        } else {
            currentTurnPointsBot += pairOfDice.getValuesOfRolls();
            if (pairOfDice.isRegularPair()) {
                print(CURRENT_SCORE + currentTurnPointsBot);
            }
        }
    }

    private void addPointsForTurn(boolean isHuman) {
        if (snakeEyesCounter == 0) {
            if (isHuman) {
                totalPointsHuman += currentTurnPointsHuman;
            } else {
                totalPointsBot += currentTurnPointsBot;
            }
            return;
        }
        if (isHuman) {
            totalPointsHuman += (int) (Math.pow(2, snakeEyesCounter) * (currentTurnPointsHuman));
        } else {
            totalPointsBot += (int) (Math.pow(2, snakeEyesCounter) * (currentTurnPointsBot));
        }
    }

    private boolean didPlayerWinGame(boolean isHumanVictor) {
        if (isHumanVictor) {
            return totalTurnsHuman <= totalPointsBot && totalPointsHuman > totalPointsBot && totalPointsHuman >= POINTS_TO_WIN;
        }
        return totalTurnsBot <= totalTurnsHuman && totalPointsBot > totalPointsHuman && totalPointsBot >= POINTS_TO_WIN;
    }

    private void endGame(boolean isHumanVictor) {
        if (isHumanVictor) {
            print(humanName + ", Congratulations! You beat the computer!");
        } else {
            print("Sorry, " + humanName + " you got beat by the computer!");
        }
    }

    private void printCurrentGameScore() {
        print(END_OF_TURN + totalPointsBot + "\t" + humanName + ": " + totalPointsHuman);
    }

    private void print(String text) {
        System.out.println(text);
    }

}
