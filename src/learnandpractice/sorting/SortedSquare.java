package learnandpractice.sorting;

import java.util.Arrays;

public class SortedSquare {

    public static void main(String[] args) {
        int a[] = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(a)));
    }

    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int temp[] = new int[n];
        int t = n - 1;
        while (l <= r && t >= 0) {

            int lSquare = nums[l] * nums[l];

            int rSquare = nums[r] * nums[r];

            if (rSquare > lSquare) {
                temp[t] = rSquare;
                r--;
            } else {
                temp[t] = lSquare;
                l++;
            }
            t--;
        }

        return temp;
    }
}
