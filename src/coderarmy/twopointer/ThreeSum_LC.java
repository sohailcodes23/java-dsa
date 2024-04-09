package coderarmy.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//#interview
public class ThreeSum_LC {

    public static void main(String[] args) {

//        int array[] = {-1, 0, 1, 2, -1, -4}; //0
        int array[] = {0, 0, 0, 0}; //0

        System.out.println("ANS " + threeSum_Optimised(array));
    }

    // by making it a 2 sum problem, using pointers
    static List<List<Integer>> threeSum_Optimised(int array[]) {
        // Final TC ==> O(N logN) + O(N^2) ==> O(N^2)

        int target = 0;
        List<List<Integer>> ans = new ArrayList<>();
        // TC ==> O(N logN)
        Arrays.sort(array);// IMP 2 sums work in sorted array
        int n = array.length;

        // TC ==> O(N)
        for (int i = 0; i <= n - 3; i++) { // loop till n-3, bcz start will go till n-2 and end will go till n-1 and we want start<end

            // Skip duplicate elements for i
            if (i > 0 && array[i] == array[i - 1]) {// i>0, so that we can check the next condition 'nums[i] == nums[i - 1]' to avoid duplicates
                continue;
            }

            //array[i] : is the 1st value, rest 2 values will be found by 2 sum
            int pendingTarget = target - array[i];// pendingTarget is the pending sum of 2 values that we need to find using 2 sum
            int start = i + 1;// start of rest of the array
            int end = n - 1;
            // Two sum way of finding if 2 sum exist of pending target
            while (start < end) { // TC ==> O(N)
                int sum = array[start] + array[end];
                if (sum == pendingTarget) {// we found the 2 values, if sum == pendingTarget, that means we have found 3 sum, 1st is outside of while loop and rest 2 is inside the while loop
                    ans.add(Arrays.asList(array[i], array[start], array[end]));

                    // Skip duplicate elements for end
                    while (start < end && array[start] == array[start + 1]) {
                        start++;
                    }

                    // Skip duplicate elements for end
                    while (start < end && array[end] == array[end - 1]) {
                        end--;
                    }

                    // Move the pointers
                    start++;
                    end--;

                } else if (sum > pendingTarget) {// we want to decrease the sum value, so we move left
                    end--;
                } else {// if sum< pendingTarget, we want to decrease the sum value, so we move left
                    start++;
                }
            }
        }

        return ans;
    }
}
