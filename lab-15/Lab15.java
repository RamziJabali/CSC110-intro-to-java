
import java.util.*;

public class Lab15 {
    private static Random r = new Random();

    public static void main(String[] args) {
        Lab15 startApp = new Lab15();
        startApp.getStarted();
    }

    private void getStarted() {
        int[][] array1 = {
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };
        int[][] array2 = generateTable();
        print(array1);
        print(unique3x3(array1));
        print(array2);
        findUnique3x3(array2);
    }

    private boolean unique3x3(int array[][]) {
        int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0;

        for (int rows = 0; rows < array.length; rows++) {
            for (int cols = 0; cols < array[rows].length; cols++) {
                switch (array[rows][cols]) {
                    case 1:
                        one++;
                        break;
                    case 2:
                         two++;
                        break;
                    case 3:
                        three++;
                        break;
                    case 4:
                        four++;
                        break;
                    case 5:
                        five++;
                        break;
                    case 6:
                        six++;
                        break;
                    case 7:
                        seven++;
                        break;
                    case 8:
                        eight++;
                        break;
                    case 9:
                        nine++;
                        break;
                    default:
                        return false;
                }
            }
        }
        if (one == 1 && two == 1 && three == 1 && four == 1 && five == 1 && six == 1 && seven == 1 && eight == 1 && nine == 1) {
            return true;
        }
        return false;
    }

    private int[][] generateTable() {
        int[][] array = new int[9][9];

        for (int rows = 0; rows < array.length; rows++) {
            for (int cols = 0; cols < array[rows].length; cols++) {
                array[rows][cols] = r.nextInt(9) + 1;
            }
        }
        return array;
    }

    private void findUnique3x3(int[][] array) {
        int[][] array2 = new int[3][3];
        int uniqueGrids = 0, x = 441, k = 0;
        int rows = 0, y = 0;

        do {
            for (int i = 0; rows < array2.length; rows++, i++) {
                for (int j = 0, cols = 0; cols< array2[i].length; cols++, j++) {
                    array2[i][j] = array[rows][cols + y];
                }
            }
            print(array2);
            print(unique3x3(array2));

            if (unique3x3(array2)) {
                uniqueGrids++;
            }
            print(y+"");
            if(y == 6) {
                y = 0;
                rows+=1;
            }
            k++; y++;
        } while (k < x);
    }

    private void print(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("[" + array[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void print(int x, int y, int arraySizeX, int arraySizeY) {

        for (int a = x ; x < arraySizeX; x++) {
            for (int z = y; y < arraySizeY; y++) {
                print("Unique 3x3 at " + "[" + x +"," + y +"]");
            }
        }
    }

    private void print(boolean i) {
        System.out.println(i);
    }

    private void print(String x) {
        System.out.println(x);
    }

}
