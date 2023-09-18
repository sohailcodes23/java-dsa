package recursion.basic;

import java.util.Arrays;
//https://www.youtube.com/watch?v=twuC1F6gLI8
public class ReverseAnArray {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr = {1, 3, 5, 7, 9};
        System.out.println("ARR " + Arrays.toString(reverseAnArrayOptimised(arr, 0)));
    }


    // with single variables like i and (n-i-1)
    static int[] reverseAnArrayOptimised(int[] originalArray, int i) {
        int n = originalArray.length;
//        if (i >= (n - i - 1)) {
        if (i >= (n / 2)) { // bcz during swapping the functions complete st the middle of the array
            return originalArray;
        }

        swapNo(originalArray, i, (n - i - 1));
        reverseAnArrayOptimised(originalArray, i + 1);

        return originalArray;
    }


    // with multiple variables like l and r
    static int[] reverseAnArray(int[] originalArray, int l, int r) {

        if (l >= r) {
            return originalArray;
        }

        swapNo(originalArray, l, r);
        reverseAnArray(originalArray, l + 1, r - 1);

        return originalArray;
    }

    static void swapNo(int[] originalArray, int l, int r) {
        int tempValue = originalArray[l];
        originalArray[l] = originalArray[r];
        originalArray[r] = tempValue;
    }

}
