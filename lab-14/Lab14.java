package com.company;

import java.util.*;

public class Lab14 {

    private static Random rand = new Random();
    private int[] array = {1, 2, 3, 4, 5, 8, 9};

    public static void main(String[] args) {
        Lab14 x = new Lab14();
        x.startApp();
    }

    private void startApp() {

        int[] array2 = {1, 4, 2, 5, 5, 1, 8};
        int[] array3 = {1, 2, 4};
        int[] array4 = {2, 3, 6};
        print(extractEvens(array));
        print(compress(array));
        //print(union(array3, array4));
        System.out.println("this is the shuffle method");
        print(shuffle(array));
        isItEqual(shuffle(array));

    }

    private int[] extractEvens(int[] array) {
        int[] array2;
        int k = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                k++;
            }
        }
        print(k);
        array2 = new int[k];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array2[j] = array[i];
                j++;
            }
        }
        return array2;
    }

    private int[] compress(int[] array) {
        int[] array2;
        int k;

        if (array.length % 2 == 0) {
            k = array.length / 2;
        } else {
            k = array.length / 2 + 1;
        }
        array2 = new int[k];
        int j = 0;

        for (int i = 0; i < array.length; i += 2) {
            if (i < array.length - 1) {
                array2[j] = array[i] + array[i + 1];
            } else if (i + 2 > array.length) {
                array2[j] = array[i];
            }
            j++;
        }
        return array2;
    }

    private int[] union(int[] array, int[] array2) {
        int[] newArray;
        int finalArraySize = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array[i] == array2[j]) {
                    finalArraySize++;
                }
            }
        }
        newArray = new int[array.length - finalArraySize];
        int temp = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array[i] == array2[j]) {
                    temp = array[i];
                } else if (array[i] != array[j]) {
                    newArray[i] = array[i];
                }
            }
        }
        return newArray;
    }

    private int[] shuffle(int[] array) {
        int[] newArray = new int[array.length];
        int index = rand.nextInt(array.length - 1);
        print(index);
        int indexTemp = index;

        for (int i = 0; i < newArray.length; i++) {
            int x = array[i];
            newArray[i] = array[index];
            newArray[index] = x;
            print(i);
            do {
                index = rand.nextInt(array.length - 1);
            } while (index == indexTemp && i + 1 < array.length);
            indexTemp = index;
        }

        return newArray;
    }

    private boolean isItEqual(int[] newArray) {

        for (int i = 0; i < array.length; i++) {
            while (array[i] != newArray[i]) {
                int index = rand.nextInt(array.length - 1) + 1;
                int x = array[i];
                newArray[i] = array[index];
                newArray[index] = x;
            }
        }
        print(newArray);
        return true;
    }


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
}