package com.company;

/** @Author: Ramzi Eljabali, Date: 4/08/19, 10am-11am
 *  @purpose: to perform 5 different algorithms using Arrays
 *  1) To return the largest number - smallest number + 1
 *  2) To return a boolean value if the array containing the list of elements is sorted
 *  in order of least to greatest
 *  3) shifts the Array of elements once to the left
 *  4) shifts the Array of elements n positions to the left
 *  5) grabs the element at an existing index of the array
 */

public class Lab13 {

    public static void main(String[] args) {
        Lab13 start = new Lab13();
        start.startApp();
    }

    private void startApp() {
        int[] array = {1, 3, 3, 4, 0, 6, 8, 2};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8};

        print(range(array));
        print(isSorted(array));
        print(isSorted(array2));
        print(shiftLeft(array2));
        print(shiftLeft(array2, 2));
        print(indexOf(array, 4));
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          Range method
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int range(int[] array) {
        int smallest = array[0];
        int largest = array[0];
        for (int i = 0; i < array.length; i++) {
            if (smallest > array[i]) {
                smallest = array[i];
            } else if (largest < array[i]) {
                largest = array[i];
            }
        }
        return (largest - smallest) + 1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          isSorted method
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean isSorted(int[] array) {
        int numberAtI = array[0];
        for (int i = 0; i < array.length; i++) {
            if (numberAtI > array[i]) {
                return false;
            } else {
                numberAtI = array[i];
            }
        }
        return true;
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          shiftLeft method
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int[] shiftLeft(int[] array) {
        int temporary;
        int temporary2 = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (i + 1 == array.length) {
                temporary = array[i];
                temporary2 = temporary;
                array[i] = 0;
            } else if (i + 1 < array.length) {
                temporary = array[i];
                array[i] = temporary2;
                temporary2 = temporary;
            }
        }
        return array;
    }

    private int[] shiftLeft(int[] array, int n) {
        int temporary;
        int temporary2 = 0;

        for (int k = 0; k < n; k++) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (i + 1 == array.length) {
                    temporary = array[i];
                    temporary2 = temporary;
                    array[i] = 0;

                } else if (i + 1 < array.length) {
                    temporary = array[i];
                    array[i] = temporary2;
                    temporary2 = temporary;
                }
            }
        }
        return array;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          shiftLeft method
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int indexOf(int[] array, int n) {
       if(n < 0 || n > array.length - 1){
           return -1;
       }else{
           return array[n];
       }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                          print methods
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void print(int i) {
        System.out.println(i);
    }

    private void print(int[] i) {
        for (int k = 0; k < i.length; k++) {
            if (k + 1 != i.length) {
                System.out.print(" [" + i[k] + "] , ");
            } else {
                System.out.print("[" + i[k] + "]");
            }
        }
        System.out.println();
    }

    private void print(boolean i) {
        System.out.println(i);
    }


}
