package coderarmy.algorithms;

import util.CommonUtility;

import java.util.Arrays;

public class SelectionSortingAlgo {

    public static void main(String[] args) {

//        int array[] = {4, 6, 2, 58, 69, 3, 65};
//        int array[] = {7, 4, 8, 5, 3};
        int array[] = {24, 18, 38, 43, 14, 40, 1, 54};
//        int array[] = {5, 3, 4, 2, 1};
        selectionSort(array);
//        insertionSortv2(array);

//        int largest = 0;
//        for (int j = 0; j < array.length; j++) {
//            if (array[j] > array[largest]) {
//                largest = j;
//            }
//        }
//
//        System.out.println(largest + " ANS " + Arrays.toString(array));
        System.out.println(" ANS " + Arrays.toString(array));
    }

    public static void selectionSort(int[] array) {
        // TC=> O(N^2)
        // SC=> O(1): constant
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

    //swapping largest element at the end
    public static void selectionSortv2(int[] array) {
        // TC=> O(N^2)
        // SC=> O(1): constant
        int n = array.length;
        for (int i = n - 1; i > 0; i--) {
            int largestIndex = i;

            for (int j = 0; j < i; j++) {
                if (array[j] > array[largestIndex]) { // Change the condition to sort in descending order
                    largestIndex = j;
                }
            }

            swapBasedOnIndex(largestIndex, i, array);
        }
    }


    public static void swapBasedOnIndex(int index1, int index2, int[] array) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
