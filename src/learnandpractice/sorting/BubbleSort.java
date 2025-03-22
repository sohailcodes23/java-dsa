package learnandpractice.sorting;

import util.CommonUtility;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
//        int a[] = {1, 6, 3, 7, 2};
        int a[] = {1, 2, 3, 4, 5};
        bubbleSort(a);
    }

    static void bubbleSort(int nums[]) {
//        TC=> O(N^2)
// take the biggest element to the last by adjacent swap
        // adjacent swap: if j is at 3rd index and j > j+1 (4th index), we need to swap it at that time , so big j ith index element will be at j+1 index
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {// j should iterate till i
            boolean swapped = false;
            for (int j = 0; j <= i - 1; j++) {// iterate from 0 to jth , i-1 bcz we are checking j>j+1

                if (nums[j] > nums[j + 1]) {
                    swapped = true;
                    CommonUtility.swapBasedOnIndex(j, j + 1, nums);
                }
            }
            if (!swapped) {//if at the first check there was no swap that means the array is already sorted
                break;
            }
        }


        System.out.println(Arrays.toString(nums));
    }
}
