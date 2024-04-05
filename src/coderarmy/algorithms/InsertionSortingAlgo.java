package coderarmy.algorithms;

import java.util.Arrays;

public class InsertionSortingAlgo {

    public static void main(String[] args) {

//        int array[] = {4, 6, 2, 58, 69, 3, 65};
//        int array[] = {7, 4, 8, 5, 3};
        int array[] = {24, 18, 38, 43, 14, 40, 1, 54};
//        int array[] = {5, 3, 4, 2, 1};
//        selectionSortv2(array);
        insertionSortv2(array);

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

    // CHECK ELEMENTS FROM START
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swapBasedOnIndex(j, j - 1, array);
                }

            }
        }
    }

    // LEARN
    // CHECK ELEMENTS FROM Back // Not working as expected :   int array[] = {24, 18, 38, 43, 14, 40, 1, 54};
    public static void insertionSortv2(int[] array) {
        int n = array.length;
        for (int i = n - 2; i >= 0; i--) {
            int currentElement = array[i];
            int j = i + 1;

            // Shift elements greater than the current element to the right
            while (j < n && currentElement > array[j]) {
                array[j - 1] = array[j];
                j++;
            }

            // Place the current element in its correct position
            array[j - 1] = currentElement;
        }
    }

    public static void swapBasedOnIndex(int index1, int index2, int[] array) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
