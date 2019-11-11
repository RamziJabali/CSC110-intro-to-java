public class Ship {
    private static int shipNum;
    private char id;
    private final char A = 'A';
    private int row, column;
    private int size;
    private int hitCount;
    private boolean isVertical;


    public Ship(int row, int column, int size, boolean isVertical) {
        id = (char) (A + shipNum);
        this.row = row;
        this.column = column;
        this.size = size;
        this.isVertical = isVertical;
        shipNum++;
    }

    public Ship() {

    }

    public void incrementHitCount() {
        hitCount++;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean getIsShipVeritical() {
        return isVertical;
    }

    public char getID() {
        return id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Ship ID: " + id + "\nship Coordinate (" + row + "," + column + ")" + "\nShip size " + size + "\nShip isVertical vertical: " + isVertical + "\n";
    }

}

