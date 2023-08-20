package searching.binarSearclAlgo.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// WE can use brute force by linear search, to search the array in ascending to get first element index and search in descending to get last element
public class FirstAndLastPositionOfElement {
    public static void main(String[] args) {

        int[] sortedArray = {5, 7, 7, 7, 7, 8, 8, 9, 10};
        System.out.println("ANS " + Arrays.toString(searchRange(sortedArray, 6)));
//        System.out.println("ANS " + binarySearch(sortedArray, 8));
    }

    public static int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, -1};
        int firstIndex = binarySearch(nums, target, true);
        int lastIndex = binarySearch(nums, target, false);
        ans[0] = firstIndex;
        if (ans[0] != -1) {
            ans[1] = lastIndex;
        }
        return ans;
    }

    static int binarySearch(int[] array, int target, boolean findFirstIndex) {
        int start = 0;
        int end = array.length - 1;

        int ans = -1;
        while (start <= end) {

            int middleIndex = start + (end - start) / 2;
            // Note don't forget this
            int middleElement = array[middleIndex];
            if (target > middleElement) {
                start = middleIndex + 1;
            } else if (target < middleElement) {
                end = middleIndex - 1;
            } else {
                ans = middleIndex;
                // Note no need of new loop, since exiting loop will run, bcz we have not added any return on middle
                // here the findFirstIndex is check so that we can check the left side of the array
                if (findFirstIndex) {
                    end = middleIndex - 1;
                } else {
                    start = middleIndex + 1;
                }
            }
        }

        return ans;
    }
}
