package array.medium;

import java.util.Arrays;

// Difference between elements should be 1, array can be reordered/sorted
public class LongestSuccessiveElement {

    public static void main(String[] args) {

//        int array[] = {5,8, 3, 2, 4, 1};
        int array[] = {1, 2, 2, 1};

        int i = longestSuccessiveElements(array);

        System.out.println("ANS " + i);
    }

    public static int longestSuccessiveElements(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
//        TC=> O(N)
        Arrays.sort(nums); // Sort SC=> O(N log N)

        int n = nums.length;
        int lastSmallest = Integer.MIN_VALUE; // to compare it should be the smallest
        int count = 0; // count when nums smallest number is found and than increment
        int longestSequence = 1; // 1 assuming the longest we can get is 1
        for (int i = 0; i < n; i++) {

            if (nums[i] - 1 == lastSmallest) { // nums[i] - 1 to check if it's consecutive( the difference is 1 or not)
                count += 1;
                lastSmallest = nums[i];
            } else if (lastSmallest != nums[i]) {
                count = 1;
                lastSmallest = nums[i];
            }

            longestSequence = Math.max(longestSequence, count);
        }

        return longestSequence;
    }
}
