package coderarmy.algorithms;

import util.CommonUtility;

import java.util.Arrays;

public class BubbleSortingAlgo {

    public static void main(String[] args) {

//        int array[] = {4, 6, 2, 58, 69, 3, 65};
//        int array[] = {7, 4, 8, 5, 3};
        int array[] = {24, 18, 38, 43, 14, 40, 1, 54};
//        int array[] = {5, 3, 4, 2, 1};

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

    public static void bubbleSort(int[] array) {

        int n = array.length;
        boolean swapped = false;// to check the best case
        for (int i = n - 2; i >= 0; i--) {// n-1, bcz we need till 2nd last
            for (int j = 0; j <= i; j++) {
                if (array[j] > array[j + 1]) {
                    CommonUtility.swapBasedOnIndex(j, j + 1, array);
                    swapped = true;
                }
            }

            if (swapped == false) {
                break;
            }
        }
    }

    //CHECK ELEMENTS FROM BACK
    public static void bubbleSortV2(int[] array) {

        int n = array.length;
        boolean swapped = false;// to check the best case
//        for (int i = n - 2; i >= 0; i--) {// n-1, bcz we need till 2nd last // this will also work
        for (int i = 0; i < n; i++) { // in reverse : we can use any loop
            for (int j = n - 1; j >= 1; j--) {
                if (array[j] < array[j - 1]) {
                    CommonUtility.swapBasedOnIndex(j, j - 1, array);
                    swapped = true;
                }
            }

            if (swapped == false) {
                break;
            }
        }
    }

    public static void swapBasedOnIndex(int index1, int index2, int[] array) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
