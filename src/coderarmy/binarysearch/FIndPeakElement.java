package coderarmy.binarysearch;

// duplicate values are allowed
public class FIndPeakElement {

    public static void main(String[] args) {
//        int array[] = {2, 1};
        int array[] = {3, 4, 3, 2, 1};
        System.out.println("ANS " + findPeakElement(array));
    }

    public static int findPeakElement(int[] nums) {
        // TC=>O(log N)
        // SC=> O(1)
        int n = nums.length;
        // Edge case, if single element and on both side there is -Infinity, so that element is peak
        if (nums.length == 1) {
            return 0;
        }

        // EDGE case, if the array is ASC or DESC sorted than below conditions will handle that
        // ALSO we are using mid-1 and m+1, so if we start from 0 to n-1, it will throw exception. SO we will start from 1 to n-2
        if (nums[0] > nums[1]) {
            return 0;
        } else if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }
        int start = 1;
        int end = n - 2;
        int ans = nums[0];
        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }

        return ans;
    }

}
