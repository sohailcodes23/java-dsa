package coderarmy.array;

import util.CommonUtility;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {

        int array[] = {4, 6, 2, 58, 3, 65};
        selectionSort(array);

        System.out.println(" ANS " + Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {

        int n = array.length;

        for (int i = 0; i < n; i++) {
            int smallestIndex = i;// using this, bcz we can't update i directly, that is required for iteration
            for (int j = i + 1; j < n; j++) {

                if (array[j] < array[smallestIndex]) { // < for ASC, > for DESC
                    smallestIndex = j;
                }
            }

            CommonUtility.swapBasedOnIndex(smallestIndex, i, array);
        }
    }

}
