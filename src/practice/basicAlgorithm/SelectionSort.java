package practice.basicAlgorithm;


import util.CommonUtility;

import java.util.Arrays;

// take the start element and check the rest of the array, find the smallest element and sort with the first start element,
// Now move the start to next index
//TC=> O(N^2)
public class SelectionSort {
    public static void main(String[] args) {
        int array[] = {65, 25, 12, 22, 11};

        selectionSort_Optimised(array, array.length);
        System.out.printf("ANS " + Arrays.toString(array));
    }


    public static void selectionSort_Optimised(int arr[], int n) {
        //TC=> O(N^2)
        for (int i = 0; i <= n - 2; i++) { // no need to loop till last element, loop till second last rest will be handled in second loop. the loop element will be by default sorted
            int smallestIndex = i;

            for (int j = i; j <= n - 1; j++) { // this loop is just for fetching the smallest element

                if (arr[j] < arr[smallestIndex]) {

                    smallestIndex = j;
                }
            }

            swapBasedOnIndex(smallestIndex, i, arr);// i is the current element and smallestindex is smallest number
        }
    }

    public static void swapBasedOnIndex(int j, int i, int[] array) {
        int tempValue = array[j]; // IMP store the value not the index
        array[j] = array[i];
        array[i] = tempValue;
    }

    public static void selectionSort(int arr[], int n) {

        for (int i = 0; i < n; i++) {
            int smallestIndex = i;

            for (int j = i; j < n; j++) {

                if (arr[j] < arr[smallestIndex]) {

                    smallestIndex = j;
                }
            }

            CommonUtility.swapBasedOnIndex(smallestIndex, i, arr);
        }
    }
}
