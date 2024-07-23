package coderarmy.binarysearch;

import java.util.Arrays;

public class FindFirstAndLastOccurrenceOfElement {

    public static void main(String[] args) {

//        int array[] = {5, 7, 7, 8, 8, 10};
        int array[] = {1};

        System.out.println("ANS " + Arrays.toString(searchRange_Optimal(array, 1)));
    }

    public static int[] searchRange_Optimal(int[] nums, int target) {
// FINAL TC=> O(log N) + O(log N)= O(log 2N) ==> O(log N), we remove constant
//       SC=> O(1)
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = n - 1;
        int mid;

        int first = findIndexUsingBinaySearch(nums, target, true);// TC=> O(log N)
        int last = findIndexUsingBinaySearch(nums, target, false);// TC=> O(log N)


        return new int[]{first, last};
    }

    static int findIndexUsingBinaySearch(int nums[], int target, boolean firstIndex) {
        int mid;
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (firstIndex) {
                    index = mid;
                    // we need to check if there are more element with target value
                    // since we are finding first occ. we need to go left
                    end = mid - 1;

                } else {
                    index = mid;
                    // we need to check if there are more element with target value
                    // since we are finding first occ. we need to go left
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return index;
    }

    public static int[] searchRange_Better(int[] nums, int target) {
// FINAL TC=> O(log N) + O(log N)= O(log 2N) ==> O(log N), we remove constant
//       SC=> O(1)
        int n = nums.length;
        if (n == 0) {
            return new int[]{-1, -1};
        }
        int start = 0;
        int end = n - 1;
        int mid;

        int first = -1, last = -1;
        // First Occurrence
        // TC=> O(N)
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                first = mid;
                // we need to check if there are more element with target value
                // since we are finding first occ. we need to go left
                end = mid - 1;

            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        start = 0;
        end = n - 1;

        // Last Occurrence
        // TC=> O(N)
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                last = mid;
                // we need to check if there are more element with target value
                // since we are finding first occ. we need to go left
                start = mid + 1;

            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return new int[]{first, last};

    }
}
