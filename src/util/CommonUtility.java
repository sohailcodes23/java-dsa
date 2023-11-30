package util;

import java.util.Arrays;

public class CommonUtility {

    public static int sumOfNNaturalNumbers(int N) {
        return (N * (N + 1)) / 2;
    }

    public static int sumOfArrayValues(int[] array) {
        int sum = 0;
        for (int j = 0; j < array.length; j++) {
            sum = sum + array[j];
        }
        return sum;
    }

    public static void swapBasedOnIndex(int j, int i, int[] array) {
        int tempValue = array[j]; // IMP store the value not the index
        array[j] = array[i];
        array[i] = tempValue;
    }

    public static void reverseArray(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static int[] sortArray_Selection(int[] array) {
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

        System.out.println("SORTED ARRAY " + Arrays.toString(array));
        return array;
    }

}
