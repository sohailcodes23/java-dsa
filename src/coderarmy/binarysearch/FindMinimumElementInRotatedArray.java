package coderarmy.binarysearch;

public class FindMinimumElementInRotatedArray {
    public static void main(String[] args) {

    }

    public static int findMin(int[] nums) {
// TC=>O(log N)
        // SC=> O(1)
        int start = 0;
        int end = nums.length - 1;
        int ans = nums[0];
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // check with first element, if mid > first, than left part is sorted
            if (nums[mid] >= nums[0]) {//if mid == 0, that means we need to check at right, so update start
                start = mid + 1;

            } else {// that means right part is sorted
                // } else if (nums[mid] < nums[0]) {// that means right part is sorted
                ans = nums[mid];// checking in this condition bcz if the mid < a[0], than the elements at the left can be potential answer
                end = mid - 1;
            }

        }

        return ans;
    }
}
