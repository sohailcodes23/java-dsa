package sorting;

import java.util.Arrays;

// SelectionSort: Select minimum value from array and swap with the starting index of sorting
//TS => O(n^2) (n square) // Best, Worst, Average
// TS explanation => Loop ran: (n-1) + (n-2) + (n-3) + ..... + 1 = n(n -1)/ 2 // Here + 1 bcz in the last pass, there's only one comparison left to be made between the last two elements of the array

// #Generated : Let's break down the expression step by step:
//Start with n(n-1)/2.
//Multiply n by (n-1), which gives you n^2 - n.
//Divide the result by 2.
//So, we have: n(n-1)/2 = (n^2 - n)/2 =  (n^2)/2 - (n)/2
//
//Now, let's analyze this expression as 'n' approaches infinity:
//
//The dominant term here is n^2 because it grows much faster than the '-n' term as 'n' becomes very large.
//The constant factor 1/2 does not affect the overall growth rate; it remains the same.
//Therefore, as 'n' approaches infinity, the dominant term n^2 dominates the expression, and we can ignore the constant factor. In big O notation, we express this as: O(n^2)

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {9, 1, 8, 2, 6, 3};
//        int[] array = {13, 46, 24, 52, 20, 9};

        System.out.println("ANS " + Arrays.toString(selectionSorted(array)));
    }

    static int[] selectionSorted(int[] array) {
        int n = array.length;
        // n-2 bcz we don't need to sort the array till last element bcz of the inner loop and swap the last element at the end of sorting will be sorted
        for (int i = 0; i <= n - 2; i++) {
            int minimumValueIndex = i;
            // j=i , bcz we need to update the starting point of the sorting, if 0th index is sorted than the next loop should start from 1st index
            // n-1, bcz we want to check till the last element of the array
            for (int j = i; j <= n - 1; j++) {
                if (array[j] < array[minimumValueIndex]) {
                    minimumValueIndex = j; // IMP to update this
                }
            }

            swapBasedOnIndex(minimumValueIndex, i, array);
        }

        return array;
    }

    static void swapBasedOnIndex(int minimumValueIndex, int i, int[] array) {
        int tempValue = array[minimumValueIndex]; // IMP store the value not the index
        array[minimumValueIndex] = array[i];
        array[i] = tempValue;
    }


}
