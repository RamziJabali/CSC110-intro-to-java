import java.util.Random;

public class Sea {

    private static final int SEA_SIZE = 10;
    private static final int MAX_SIZE = 4;
    private static final int MIN_SIZE = 2;
    private static final String UNHIT_POSITION = ".";
    private static final String HIT_POSITION = "*";
    private static final String MISSED_HIT_POSITION = "X";
    private static final String YOU_HIT_A_SHIP = "Good job! A ship was hit";
    private static final String YOU_DESTROYED_A_SHIP = "Congrats! A ship was destroyed";
    private static final String YOU_HIT_SHIP_1 = "Ship ";
    private static final String YOU_HIT_SHIP_2 = " hit ";
    private static final String YOU_HIT_SHIP_3 = " times";
    private static final String YOU_MISSED = "No ships were hit";
    private static final String DIVIDER_LINE = "----------------------------------------------------------------------";
    private final boolean IS_IN_CHEAT_MODE;

    private String[][] displayGrid = new String[SEA_SIZE][SEA_SIZE];
    private Ship[][] shipGrid = new Ship[SEA_SIZE][SEA_SIZE];
    private int missCount;
    private int numOfDestroyedShips;


    private static Random rand = new Random();

    public Sea(int numberOfShips, boolean isInCheatMode) {
        this.IS_IN_CHEAT_MODE = isInCheatMode;
        populateSeaWithShips(numberOfShips);
        populateDisplayGrid();
        printSea();
    }
//TODO: copy and put this in the model;
    private void populateDisplayGrid() {
        for (int rows = 0; rows < SEA_SIZE; rows++) {
            for (int columns = 0; columns < SEA_SIZE; columns++) {
                Ship currentShip = shipGrid[rows][columns];
                if (IS_IN_CHEAT_MODE) {
                    if (currentShip == null) {
                        displayGrid[rows][columns] = UNHIT_POSITION;
                    } else {
                        displayGrid[rows][columns] = currentShip.getID() + "";
                    }
                } else {
                    displayGrid[rows][columns] = UNHIT_POSITION;
                }
            }
        }
    }

    private void populateSeaWithShips(int numberOfShipsRemainingToAdd) {
        Ship randomShip;
        boolean doesShipFit;
        while (numberOfShipsRemainingToAdd > 0) {
            do {
                randomShip = getRandomShip();
                doesShipFit = doesShipFitSea(randomShip);
            } while (!doesShipFit);
            addShip(randomShip);
            numberOfShipsRemainingToAdd--;
        }
    }

    private boolean doesShipFitSea(Ship randomShip) {
        if (randomShip.getIsShipVeritical()) {
            for (int i = 0; i < randomShip.getSize(); i++) {
                if (randomShip.getRow() + i >= SEA_SIZE) {
                    return false;
                }
                if (shipGrid[randomShip.getRow() + i][randomShip.getColumn()] != null) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 0; i < randomShip.getSize(); i++) {
            if (randomShip.getColumn() + i >= SEA_SIZE) {
                return false;
            }
            if (shipGrid[randomShip.getRow()][randomShip.getColumn() + i] != null) {
                return false;
            }
        }
        return true;
    }

    private Ship getRandomShip() {
        boolean isVertical = getRandomBoolean();
        int row = rand.nextInt(SEA_SIZE);
        int column = rand.nextInt(SEA_SIZE);
        int size = rand.nextInt((MAX_SIZE - MIN_SIZE) + 1) + MIN_SIZE;
        return new Ship(row, column, size, isVertical);
    }

    public boolean areAllShipsDestroyed(int numberOfShips) {
        return numOfDestroyedShips == numberOfShips;
    }

    private boolean getRandomBoolean() {
        return Math.random() < 0.5;
    }

    private void addShip(Ship ship) {
        if (ship.getIsShipVeritical()) {
            for (int i = 0; i < ship.getSize(); i++) {
                shipGrid[ship.getRow() + i][ship.getColumn()] = ship;
            }
        } else {
            for (int i = 0; i < ship.getSize(); i++) {
                shipGrid[ship.getRow()][ship.getColumn() + i] = ship;
            }
        }
    }

    public void hitLocation(int row, int column) {
        if (isShipLocatedHere(row, column)) {
            hitShipAtLocation(row, column);
            return;
        }
        missAtLocation(row, column);
    }

    private boolean isShipLocatedHere(int row, int column) {
        if (IS_IN_CHEAT_MODE) {
            return shipGrid[row][column] != null && !displayGrid[row][column].equalsIgnoreCase(HIT_POSITION);
        }
        return shipGrid[row][column] != null && displayGrid[row][column].equals(UNHIT_POSITION);
    }

    private void hitShipAtLocation(int row, int column) {
        shipGrid[row][column].incrementHitCount();
        displayGrid[row][column] = HIT_POSITION;
        printSea();
        if (isShipDestroyed(row, column)) {
            printNewLine(YOU_HIT_SHIP_1 + shipGrid[row][column].getID() + YOU_HIT_SHIP_2 + shipGrid[row][column].getHitCount() + YOU_HIT_SHIP_3);
            printNewLine(YOU_DESTROYED_A_SHIP);
            printNewLine(DIVIDER_LINE);
            return;
        }
        printNewLine(YOU_HIT_A_SHIP);
        printNewLine(YOU_HIT_SHIP_1 + shipGrid[row][column].getID() + YOU_HIT_SHIP_2 + shipGrid[row][column].getHitCount() + YOU_HIT_SHIP_3);
        printNewLine(DIVIDER_LINE);
    }

    private void missAtLocation(int row, int column) {
        missCount++;
        displayGrid[row][column] = MISSED_HIT_POSITION;
        printSea();
        printNewLine(YOU_MISSED);
        printNewLine(DIVIDER_LINE);
    }

    private boolean isShipDestroyed(int row, int column) {
        if (shipGrid[row][column].getSize() == shipGrid[row][column].getHitCount()) {
            numOfDestroyedShips++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String result = " 0123456789" + "\n";
        for (int row = 0; row < SEA_SIZE; row++) {
            result += row + "";
            for (int column = 0; column < SEA_SIZE; column++) {
                result += displayGrid[row][column];
            }
            result += "\n";
        }
        return result;
    }

    public boolean isItOnTheGrid(String coordinate) {
        for (int i = 0; i < coordinate.length(); i++) {
            if (!(Character.isDigit(coordinate.charAt(i)))) {
                return false;
            }
        }
        if (Integer.parseInt(coordinate) < 0 || Integer.parseInt(coordinate) >= SEA_SIZE) {
            return false;
        } else {
            return true;
        }
    }

    public int getMissCount() {
        return missCount;
    }

    private void printSea() {
        printNewLine(this.toString());
    }

    private void print(String word) {
        System.out.print(word);
    }

    private void printNewLine(String word) {
        System.out.println(word);
    }
}
