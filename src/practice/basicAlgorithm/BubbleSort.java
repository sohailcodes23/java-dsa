package practice.basicAlgorithm;

import util.CommonUtility;

import java.util.Arrays;

// move the highest element at the last
// check the current and adjacent(next) elements, if current > adjacent, swap
public class BubbleSort {

    public static void main(String[] args) {

        int array[] = {6, 2, 8, 4, 10};
        bubbleSort_MoreOptimised(array, array.length);
        System.out.printf("ANS " + Arrays.toString(array));
    }


    public static void bubbleSort_MoreOptimised(int[] arr, int n) {

        for (int i = 1; i <= n - 1; i++) { // this loop is just so that all the elements are checked in the nested loop
            int j = i;
            // using while loop bcz it checks the condition before entering the loop
            while (j > 0 && arr[j - 1] > arr[j]) { // j>0 bcz we are checking j-1
                CommonUtility.swapBasedOnIndex(j - 1, j, arr);
                j--; //  IMP : so that it checks the previous values as well
            }
        }

    }

    public static void bubbleSort(int[] arr, int n) {
//TC=> O(N^2)
        for (int i = 0; i <= n - 1; i++) { // this loop is just so that all the elements are checked in the nested loop

            for (int j = 0; j <= n - i - 2; j++) { // n- i - 2=> -i is very IMP think of it when the first pass the biggest element is send at the last of the array so we don't need to check that
// -2 bcz we are checking j+1, so to avoid exception
                if (arr[j] > arr[j + 1]) {
                    CommonUtility.swapBasedOnIndex(j, j + 1, arr);
                }
            }
        }

    }

}
