package coderarmy.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//#interview
public class ThreeSum {

    public static void main(String[] args) {

        int array[] = {1, 4, 45, 6, 10, 8};

        System.out.println("ANS " + threeSum_Optimised(array, 20));
    }

    // by making it a 2 sum problem, using pointers
    static List<Integer> threeSum_Optimised_LC(int array[], int target) {
        // Final TC ==> O(N logN) + O(N^2) ==> O(N^2)
        List<Integer> integers = new ArrayList<>();
        // TC ==> O(N logN)
        Arrays.sort(array);// IMP 2 sums work in sorted array
        int n = array.length;

        // TC ==> O(N)
        for (int i = 0; i <= n - 3; i++) { // loop till n-3, bcz start will go till n-2 and end will go till n-1 and we want start<end
            //array[i] : is the 1st value, rest 2 values will be found by 2 sum
            int pendingTarget = target - array[i];// pendingTarget is the pending sum of 2 values that we need to find using 2 sum
            int start = i + 1;// start of rest of the array
            int end = n - 1;
            // Two sum way of finding if 2 sum exist of pending target
            while (start < end) { // TC ==> O(N)
                int sum = array[start] + array[end];
                if (sum == pendingTarget) {// we found the 2 values, if sum == pendingTarget, that means we have found 3 sum, 1st is outside of while loop and rest 2 is inside the while loop
                    integers.add(array[i]);
                    integers.add(array[sum]);
                    integers.add(array[end]);
                    return integers;
                } else if (sum > pendingTarget) {// we want to decrease the sum value, so we move left
                    end--;
                } else {// if sum< pendingTarget, we want to decrease the sum value, so we move left
                    start++;
                }
            }
        }

        return integers;
    }

    static boolean threeSum_Optimised(int array[], int target) {
        // Final TC ==> O(N logN) + O(N^2) ==> O(N^2)

        // TC ==> O(N logN)
        Arrays.sort(array);// IMP 2 sums work in sorted array
        int n = array.length;

        // TC ==> O(N)
        for (int i = 0; i <= n - 3; i++) { // loop till n-3, bcz start will go till n-2 and end will go till n-1 and we want start<end
            //array[i] : is the 1st value, rest 2 values will be found by 2 sum
            int pendingTarget = target - array[i];// pendingTarget is the pending sum of 2 values that we need to find using 2 sum
            int start = i + 1;// start of rest of the array
            int end = n - 1;
            // Two sum way of finding if 2 sum exist of pending target
            while (start < end) { // TC ==> O(N)
                int sum = array[start] + array[end];
                if (sum == pendingTarget) {// we found the 2 values, if sum == pendingTarget, that means we have found 3 sum, 1st is outside of while loop and rest 2 is inside the while loop
                    return true;
                } else if (sum > pendingTarget) {// we want to decrease the sum value, so we move left
                    end--;
                } else {// if sum< pendingTarget, we want to decrease the sum value, so we move left
                    start++;
                }
            }
        }

        return false;
    }

    // Using 2 pointer and BS

    static boolean threeSum_Better(int array[], int target) {

        // Final TC=> O(N log N) + O(N^2 * log N) ==> O(N^2 log N)
        int n = array.length;
        Arrays.sort(array); // TC=O(N log N)

        int p1 = 0, p2 = p1 + 1;

        // TC=> O(N^2) // bcz the loop iterates over all possible pair of elements
        while (p1 <= n - 2) {// n-2 bcz we have p2, which will be +1 ahead of p1

            int sum = array[p1]
                    + array[p2];
            int pending = target - sum;

            // find in rest of the array if that pending value exist
            if (binearySearchToFindANo(array, pending)) {// TC=O(N log N), Since binary search has a time complexity of O(log N), and it's executed for each element of the array, the overall time complexity of this part becomes O(N log N).
                return true;
            } else { // p2++ bcz we want to traverse the whole array
                p2++;
            }

            if (p2 == n - 1) { // if p2 has reached at end we need to increment p1
                p1++;
                p2 = p1 + 1;
            }
        }


        return false;
    }

    private static boolean binearySearchToFindANo(int array[], int target) {
        // TC=O(log N)
        int n = array.length;
        int start = 0, end = n - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return true;
            } else if (mid > target) {
                end = mid - 1;
            } else {
                start++;
            }
        }

        return false;
    }

    static boolean threeSum_brute(int array[], int target) {

//        TC=O(N^3)
        int n = array.length;

        for (int i = 0; i <= n - 3; i++) { // loop till 3rd last element
            for (int j = 0; j <= n - 2; j++) { // loop till 2nd last element

                for (int k = 0; k <= n - 1; k++) {// loop till last element

                    int sum = array[i] + array[j] + array[k];

                    if (sum == target) {
                        return true;
                    }
                }
            }
        }


        return false;
    }
}
