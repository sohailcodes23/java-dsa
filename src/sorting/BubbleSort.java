package sorting;

import java.util.Arrays;

// BubbleSort: Select maximum value from array and do adjacent swapping
//adjacent swapping means if index i is at 0 than check elements at 0th and 1st index, if 0th element is greater than 1st, then swap the values.
// Next time check 1st and 2nd element, if 1st element is greater than 2nd, then swap the values.
// THis goes on till the last values of array is highest value. Once highest values is set at the end of array, don't check the last sorted elements

//TS :
// Best : O(N) --> Linear TS
//Worst and Average = O(N^2)
public class BubbleSort {

    public static void main(String[] args) {
//        int[] array = {9, 1, 8, 2, 6, 3};
//        int[] array = {13, 46, 24, 52, 20, 9};
        int[] array = {1, 2, 4, 6, 7, 9};
        System.out.println("ANS " + Arrays.toString(bubbleSortOptimised(array)));
    }

    static int[] bubbleSortOptimised(int[] array) {
        // TS => O(N) // Best Case // check 'bubbleSort()' to know worst and average case
        // SO if the array is already in ascending order, than we will check in the first run is there any swaps, if in the first lop there are no swaps, than we don't need to run other loops
        //  int[] array = {1,2,4,6,7,9};
        int n = array.length;

//        Since every call is from 0th index to n-1, 0 to n-2...... till 1;
        for (int i = n - 1; i >= 1; i--) {

            boolean didSwap = false; // the optimisation
            for (int j = 0; j <= i - 1; j++) { // j=i - 1 bcz if you directly assigning till 'i' it will throw Runtime exception. So to check till end in the loop it is checking 'j+1'
                if (array[j] > array[j + 1]) {
                    swapBasedOnIndex(j, j + 1, array);
                    didSwap = true;
                }
            }
            if (!didSwap) {
                break;
            }
        }


//
//        // Tried but didn't worked properly
//        for (int i = 0; i < n; i++) { // looping whole loop till end
//            System.out.println("I " + i + ":" + array[i]);
//            for (int j = i; j < n - i - 1; j++) { // looping till the value is not sorted
//                System.out.println("J " + j + ":" + array[j]);
//
//                if (array[j] > array[j + 1]) {
//                    swapBasedOnIndex(j, j + 1, array);
//                }
//            }
//        }


        return array;
    }

    static int[] bubbleSort(int[] array) {
        // TS => O(N^2) // Worst or Average Case
        int n = array.length;

//        Since every call is from 0th index to n-1, 0 to n-2...... till 1;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j <= i - 1; j++) { // j=i - 1 bcz if you directly assigning till 'i' it will throw Runtime exception. So to check till end in the loop it is checking 'j+1'

                if (array[j] > array[j + 1]) {
                    swapBasedOnIndex(j, j + 1, array);
                }
            }
        }


//
//        // Tried but didn't worked properly
//        for (int i = 0; i < n; i++) { // looping whole loop till end
//            System.out.println("I " + i + ":" + array[i]);
//            for (int j = i; j < n - i - 1; j++) { // looping till the value is not sorted
//                System.out.println("J " + j + ":" + array[j]);
//
//                if (array[j] > array[j + 1]) {
//                    swapBasedOnIndex(j, j + 1, array);
//                }
//            }
//        }


        return array;
    }

    static void swapBasedOnIndex(int j, int i, int[] array) {

//        System.out.println("BEFORE SWAP " + Arrays.toString(array));
        int tempValue = array[j]; // IMP store the value not the index
        array[j] = array[i];
        array[i] = tempValue;

//        System.out.println("AFTER SWAP " + Arrays.toString(array));
    }


}
