package practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.youtube.com/watch?v=6KHW7ZQwtCA
// Can be done using hashing but SC will be O(N)
// Can be done by sum of n natural numbers
// Optimal : https://leetcode.com/problems/first-missing-positive/solutions/3765193/cycle-sort-o-n-o-1-easy-java-solution-detailed-explanation-beats-100/
// https://www.youtube.com/watch?v=-lfHWWMmXXM
// Cyclic sort : https://emre.me/coding-patterns/cyclic-sort/
public class FirstMissingPositive {

    public static void main(String[] args) {

//        int array[] = {3, 4, -1, 1};
//        int array[] = {2,1};
//        int array[] = {7,8,9,11,12};
//        int array[] = {1, 2, 0}; // E = 3
        int array[] = {0, 2, 2, 1, 1}; // E = 3
        System.out.println("ANS " + firstMissingPositive_Optimal(array));
    }


    // using Cyclic sort
    public static int firstMissingPositive_Optimal(int[] nums) {

//        TC => O()
        int n = nums.length;

        for (int i = 0; i < n; i++) {  // TC => O(N)

            int correctPositionOfElement = nums[i] - 1; // correct postion bcz loop started from 0, so the values will be n-1
            // Keep swapping elements until the current element is at its correct position
            while (
                    nums[i] > 0   // so that only positive elements are swapped
                            && nums[i] <= n // bcz the elements can be only till n+1 value and we are writing <= n
                            && nums[correctPositionOfElement] != nums[i] // to check if the elements are not on the correct positiion, only than we will swap
            ) {
                int temp = nums[i];
                nums[i] = nums[correctPositionOfElement];
                nums[correctPositionOfElement] = temp;

                correctPositionOfElement = nums[i] - 1; // update the correct position // IMP
            }

        }

        // Find the first missing positive integer
        for (int i = 0; i < n; i++) {
            if (nums[i] != (i + 1)) { // i+1 is the index value, so after the cyclic sort all the elements should be on the index +1 postions, like 3 value should be on the 3rd postion in array which is (i+1) bcz array starts from 0
                return i + 1;
            }
        }


        // If all positive integers from 1 to n are present, return n + 1
        return n + 1;
    }


    public static int firstMissingPositive_Brute(int[] nums) {
//        TC=> O(N log N) + O(N)
//        SC=> O(1)
        Arrays.sort(nums);
        int n = nums.length;
        int toCheckValue = 1;
        for (int i = 0; i < n; i++) {

            if (nums[i] > 0) {
                if (nums[i] == toCheckValue) { // fixed
                    toCheckValue++;
                }
            }
        }

        return toCheckValue;
    }
}
