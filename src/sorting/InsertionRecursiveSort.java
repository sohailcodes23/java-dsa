package sorting;

import java.util.Arrays;

//Time Complexity: O(N2), (where N = size of the array), for the worst, and average cases.
// TC => Best case : O(N), where array is already sorted
//Reason: If we carefully observe, we can notice that the recursion call will occur for n times, and for each i, inside the recursive function, the loop j runs from i to 1 i.e. i times. For, i = 1, the loop runs 1 time, for i = 2, the loop runs 2 times, and so on. So, the total steps will be approximately the following: 1 + 2 + 3 +……+ (n-2) + (n-1). The summation is approximately the sum of the first n natural numbers i.e. (n*(n+1))/2. The precise time complexity will be O(n2/2 + n/2). Previously, we have learned that we can ignore the lower values as well as the constant coefficients. So, the time complexity is O(n2). Here the value of n is N i.e. the size of the array.
//
//Space Complexity: O(N) auxiliary stack space.
public class InsertionRecursiveSort {

    public static void main(String[] args) {
        int[] array = {9, 1, 8, 2, 6, 3};
//        int[] array = {13, 46, 24, 52, 20, 9};
//        int[] array = {1, 2, 4, 6, 7, 9};
        InsertionRecursiveSort(array, 0);
        System.out.println("ANS " + Arrays.toString(array));
    }

    static void InsertionRecursiveSort(int[] array, int start) {
        if (start == array.length) {
            return;
        }

        int j = start;
        // j>0 bcz when checking the 'j-1' element is checked so it will throw exception when the element is at 0, 0-1 = -1 (This will cause exception)
//            array[j-1] > array[j] bcz only than you need to swap
        while (j > 0 && array[j - 1] > array[j]) {

            swapBasedOnIndex(j - 1, j, array);
            j--; // bcz we have to check from the j till 0, for example if j is at 5th index, in the loop it should check the 4th, than 3rd and so on elements till 0th
        }
        InsertionRecursiveSort(array, start + 1);
    }

    static void swapBasedOnIndex(int j, int i, int[] array) {

//        System.out.println("BEFORE SWAP " + Arrays.toString(array));
        int tempValue = array[j]; // IMP store the value not the index
        array[j] = array[i];
        array[i] = tempValue;

//        System.out.println("AFTER SWAP " + Arrays.toString(array));
    }

}
