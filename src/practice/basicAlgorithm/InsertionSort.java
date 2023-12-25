package practice.basicAlgorithm;

import java.util.Arrays;

// check the current element with the next element, if not sorted swap them
// TC=> O(N^2)
public class InsertionSort {

    public static void main(String[] args) {
//        int array[] = {3, 1, 2, 2};
        int array[] = {12, 11, 13, 5, 6};
//        int array[] = {11, 12, 13, 5, 6};

        insertionSortv2(array.length, array);
        System.out.printf("ANS " + Arrays.toString(array));
    }

    // more optimised
    public static void insertionSortv2(int n, int[] arr) {
        // TC=> O(N^2)
        for (int i = 1; i < n; i++) {
            int j = i;

            while (j > 0  // to avoid exception
                    && arr[j - 1] > arr[j])// if the array is not sorted only than go inside
            {
                swapBasedOnIndex(j - 1, j, arr);
                j--; // imp so that it can check with the previous elements as well
            }

        }
    }

    //OWN
    public static void insertionSort(int n, int[] arr) {
        // TC=> O(N^2)

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) { // here it goes in the loop even if the 2 pointer values are sorted, but in above method it checks in the while loop if it's sorted than it doesn't go inside
                if (arr[i] > arr[j]) {
                    swapBasedOnIndex(i, j, arr);
                }
            }
        }
    }


    static void swapBasedOnIndex(int i, int j, int array[]) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
