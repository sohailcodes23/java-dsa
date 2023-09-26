package sorting;

import java.util.Arrays;

public class BubbleSortRecursive {

    public static void main(String[] args) {
        int[] array = {9, 1, 8, 2, 6, 3};
//        int[] array = {13, 46, 24, 52, 20, 9};
//        int[] array = {1, 2, 4, 6, 7, 9};
        BubbleSortRecursive(array, array.length - 1);
        System.out.println("ANS " + Arrays.toString(array));
    }

    static void BubbleSortRecursive(int[] array, int n) {
        if (n == 1) {
            return;
        }
//        int n = array.length;
        // for (int i = n - 1; i >= 1; i--) { // Reference to send the nth input as parameter
        for (int j = 0; j <= n - 1; j++) { // j=n - 1 bcz if you directly assigning till 'i' it will throw Runtime exception. So to check till end in the loop it is checking 'j+1'

            if (array[j] > array[j + 1]) {
                swapBasedOnIndex(j, j + 1, array);
            }
        }

        BubbleSortRecursive(array, n - 1);
    }

    static void swapBasedOnIndex(int j, int i, int[] array) {
//        System.out.println("INPUT " + array[j] + " " + array[i]);
//        System.out.println("BEFORE SWAP " + Arrays.toString(array));
        int tempValue = array[j]; // IMP store the value not the index
        array[j] = array[i];
        array[i] = tempValue;

//        System.out.println("AFTER SWAP " + Arrays.toString(array));
    }

}
