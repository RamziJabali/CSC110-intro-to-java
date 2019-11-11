import java.util.*;

public class ShipSinkingGame {
    private static final char N = 'n';
    private static final String Q = "q";
    private static final char Y = 'y';
    private static final String ENTER_ROW = "Enter a coordinate (0 . . 9) (Row) or Enter 'Q' to quit";
    private static final String ENTER_COLUMN = "Enter a coordinate (0 . . 9) (Column) or Enter 'Q' to quit";
    private static final String USER_LOST_GAME_1 = "Sorry, you have accumulated ";
    private static final String USER_LOST_GAME_2 = " misses out of ";
    private static final String USER_LOST_GAME_3 = " shots: You lost!";
    private static final String USER_QUIT_GAME_1 = "Quitting early! ";
    private static final String USER_QUIT_GAME_2 = " shots were used.";
    private static final String USER_WON_GAME_1 = " Congratulations! All ships destroyed with ";
    private static final String USER_WON_GAME_2 = " shots!";
    private static final int NUMBER_SHIPS = 8;
    private static final int MAX_NUM_OF_MISSES = 12;
    private static final String MODE_N_CHEAT_MODE = "Do you want play mode? (N = cheat mode) (Y = play mode): ";
    public static final String IN_CHEAT_MODE_ENJOY = "OK - We're in CHEAT mode.  Enjoy . . .";
    public static final String PLAYMODE_ENJOY = "OK - We're in PLAY mode. Enjoy...";

    private int totalNumOfShotsTaken;

    private static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        ShipSinkingGame start = new ShipSinkingGame();
        start.startGame();
    }

    private void startGame() {
        String row, column = "";
        String mode;
        do{
            printNewLine(MODE_N_CHEAT_MODE);
            mode = kb.next();
        }while (!mode.equalsIgnoreCase(N+"") && !mode.equalsIgnoreCase(Y+""));
        Sea sea = new Sea(NUMBER_SHIPS, isInCheatMode(mode));

        boolean didUserQuit;
        do {
            do {
                printNewLine(ENTER_ROW);
                row = kb.next();
                didUserQuit = didUserQuit(row);
            } while (!sea.isItOnTheGrid(row) && !didUserQuit);

            if (!didUserQuit) {
                do {
                    printNewLine(ENTER_COLUMN);
                    column = kb.next();
                    didUserQuit = didUserQuit(column);
                } while (!sea.isItOnTheGrid(column) && !didUserQuit);
            }
            if (!didUserQuit) {
                sea.hitLocation(Integer.parseInt(row), Integer.parseInt(column));
                totalNumOfShotsTaken++;
            }
        } while (!didUserQuit && !didUserMissTooMany(sea) && !sea.areAllShipsDestroyed(NUMBER_SHIPS));

        if (didUserQuit) {
            userQuitGame();
        } else if (didUserMissTooMany(sea)) {
            userLostGame(sea);
        } else {
            userWonGame();
        }
    }

    private boolean isInCheatMode(String answer) {
        if (Character.toLowerCase(answer.charAt(0)) == N) {
            printNewLine(IN_CHEAT_MODE_ENJOY);
            return true;
        }
        printNewLine(PLAYMODE_ENJOY);
        return false;
    }

    private boolean didUserQuit(String coordinate) {
        return coordinate.equalsIgnoreCase(Q);
    }

    private void userQuitGame() {
        print(USER_QUIT_GAME_1 + totalNumOfShotsTaken + USER_QUIT_GAME_2);
    }

    private void userLostGame(Sea sea) {
        print(USER_LOST_GAME_1 + sea.getMissCount() + USER_LOST_GAME_2 + totalNumOfShotsTaken + USER_LOST_GAME_3);
    }

    private void userWonGame() {
        print(USER_WON_GAME_1 + totalNumOfShotsTaken + USER_WON_GAME_2);
    }

    private boolean didUserMissTooMany(Sea sea) {
        if (MAX_NUM_OF_MISSES == sea.getMissCount()) {
            return true;
        }
        return false;
    }

    private static void printNewLine(String word) {
        System.out.println(word);
    }

    private static void print(String word) {
        System.out.print(word);
    }
}
