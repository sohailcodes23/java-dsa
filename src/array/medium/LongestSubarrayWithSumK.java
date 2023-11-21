package array.medium;

import java.util.Arrays;

public class LongestSubarrayWithSumK {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 1, 1, 1, 1};
//        int a[] = {1, 2, 1, 0, 1};

        System.out.println("ANS " + longestSubarrayWithSumK(a, 5));
    }

    // Brute
    public static int longestSubarrayWithSumK(int[] a, long k) {


        int sum = 0;
        for (int i = 0; i < a.length; i++) {

            int currentSum = 0;
            int currentCounter = 0;
            for (int j = i; j < a.length; j++) {

                currentSum = currentSum + a[j];
                currentCounter++;
                if (currentSum == k) {
                    sum = Math.max(sum, currentCounter);
                }

            }
        }

        return sum;
    }
}
