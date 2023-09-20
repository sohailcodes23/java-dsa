package sorting;

import java.util.Arrays;

// Select minimum value from array and swap with the starting index of sorting
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
