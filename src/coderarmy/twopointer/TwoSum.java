package coderarmy.twopointer;

import java.util.Arrays;

//https://www.youtube.com/watch?v=KKPjlsLSs5w&list=PLQEaRBV9gAFu4ovJ41PywklqI7IyXwr01&index=29
public class TwoSum {

    public static void main(String[] args) {

        int arr[] = {2, 7, 11, 15,25};

        System.out.println(Arrays.toString(twoSum(arr, 22)));

    }

    // Using Binary Search
    public static int[] twoSum(int[] numbers, int target) {

        // TC=> O(N)
        // SC=> O(1)
        int n = numbers.length;

        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start, end};
            } else if (sum > target) {// bcz if sum>target that means the required value is at left side
                end--;
            } else {// if sum< target than we need to move right
                start++;
            }

        }


        return new int[]{-1, -1};
    }

    public static int[] twoSum_BS(int[] numbers, int target) {

        // TC=> O(N logN) : N bcz of for loop and since we used Binary Search it's TC is logN
        // SC=> O(1)
        int n = numbers.length;

        int ansIndex = -1;
        for (int i = 0; i <= n - 1; i++) {

            int x = target - numbers[i];

            int start = i + 1;// bcz we want to check from the next number till the end if we can find the  X in rest of the array
            int end = n - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (numbers[mid] == x) {
                    ansIndex = mid;
                    break;
                } else if (numbers[mid]
                        > x) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (ansIndex != -1) {
                return new int[]{i, ansIndex};
            }
        }


        return new int[]{-1, -1};
    }


}
