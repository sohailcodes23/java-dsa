package coderarmy.twopointer;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductPair {

    public static void main(String[] args) {
        int arr[] = {10, 1, 2, 7, 12, 20, 9, 40};
        System.out.println("ANS " + isProduct(arr, arr.length, 24));
    }

    // Better TC With Space
    static boolean isProduct(int[] arr, int n, long x) {

//        TC=> O(N)
//        SC=> O(N)
        ArrayList<Long> integers = new ArrayList<>();

        for (int i : arr) {
            integers.add((long) i);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) { // bcz the mul ans will always be 0
                continue;
            }
            long divi = x % arr[i];
            if (divi == 0) {
                long mul = x / arr[i];
                if (integers.contains(mul)) {// x % arr[i], bcz if the dividend is 0, than it makes sense to check if it contains
                    //x / arr[i], bcz if 24/2 = 12, if the list contains 12, than true
                    return true;
                }
            }

        }
        return false;
    }

    //Better
    static boolean isProduct_TwoPointer(int[] arr, int n, long x) {
        //Final TC=> O(N logN) + O(N) == O(N logN) , since the dominant factor is the sorting operation that's why skipped the O(N).
        //SC=> O(1)
        Arrays.sort(arr);// TC=> O(N logN)
        System.out.println("SOR " + Arrays.toString(arr));
        int start = 0;
        int end = n - 1;

        while (start < end) {//O(N)
            int mul = arr[start] * arr[end];

            if (mul == x) {
                return true;
            } else if (mul > x) {
                end--;
            } else {
                start++;
            }
        }

        return false;
    }
}
