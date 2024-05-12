package coderarmy.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//#Better Another way: Use a HashSet, run 3 loops and take the sum of i,j,k and subtract from target
// pendingSum = target - (sum of all three elements), if the pendingSum is there in hashSet than the 4 sum exist

public class FourSum {

    public static void main(String[] args) {

//        int array[] = {1, 4, 45, 6, 10, 8}; //28


//        int array[] = {1, 0, -1, 0, -2, 2}; //0
//        int array[] = {1, 0, -1, 0, -2, 2}; //0
//        int array[] = {1, 0, -1, 0, -2, 2}; //0
        int array[] = {-3, -2, -1, 0, 0, 1, 2, 3}; //0// special case
//        int array[] = {2, 2, 2, 2, 2}; //8
//        int array[] = {1, 2, 3, 4, 5, 9}; //14

        System.out.println("ANS " + fourSumExist(array, 0));
        System.out.println("ANS " + fourSumv2(array, 0));
        System.out.println("ANS " + fourSum(array, 0));
    }

    //GFG
    public static boolean fourSumExist(int[] nums, int target) {

//        TC=> O(N^3) + O(N logN) ==> O(N^3)

        int n = nums.length;
        Arrays.sort(nums);// Bcz 2 sum works in sorted array // TC=> O(n logn)

        // TC=> O(N^3)
        for (int k = 0; k < n - 3; k++) { // O(N)
            //1,2,3,4,5
            int prePendingSum = target - nums[k];
            //three sum
            for (int i = k + 1; i < n - 2; i++) { // O(N)

                int pendingSum = prePendingSum - nums[i];

                int start = i + 1;
                int end = n - 1;
                while (start < end) { // O(N)

                    int currentSum = nums[start] + nums[end];
                    if (currentSum == pendingSum) {

                        return true;
                    } else if (currentSum > pendingSum) {
                        end--;
                    } else {
                        start++;
                    }

                }

            }
        }
        return false;
    }


    // Partial OWN: didn't worked for :    int array[] = {-3, -2, -1, 0, 0, 1, 2, 3}; //0// special case
    public static List<List<Integer>> fourSumv2(int[] nums, int target) {

//        TC=> O(N^3) + O(N logN) ==> O(N^3)
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);// Bcz 2 sum works in sorted array // TC=> O(n logn)

        // TC=> O(N^3)
        for (int i = 0; i < n - 3; i++) { // O(N)

            if (i > 0 && nums[i] == nums[i - 1]) // i>0, bcz we dont want to check duplicates at the 0th index, so we check when it's i > 0, check by a[i] != a[i-1]
            {
                continue; // skip the rest of the below code
            }

            int prePendingSum = target - nums[i];
            //three sum
            for (int j = i + 1; j < n - 2; j++) { // O(N)

                if (j > (i + 1) && nums[j] == nums[j - 1]) // j> i+1, bcz we don't want to check the j at the first start, once j move to the next elements than we want to check the duplicates
                {
                    continue; // skip the rest of the below code
                }

                int pendingSum = prePendingSum - nums[j];

                int start = j + 1;
                int end = n - 1;
                while (start < end) { // O(N)

                    int currentSum = nums[start] + nums[end];
                    if (currentSum == pendingSum) {

                        List<Integer> currentFourSum = new ArrayList<>();
                        currentFourSum.add(nums[i]);
                        currentFourSum.add(nums[j]);
                        currentFourSum.add(nums[start]);
                        currentFourSum.add(nums[end]);

                        lists.add(currentFourSum);

                        start++;// move to next element, bcz we will be checking duplicates and we need to check current and previous values
                        end--;// move to next element, bcz we will be checking duplicates and we need to check current and previous values

                        while (start < end && nums[start] == nums[start - 1]) {// After moving to next, check duplicates and skip the duplicates and move forward
                            start++;
                        }


                        while (start < end && nums[end] == nums[end + 1]) {// After moving to next, check duplicates and  skip the duplicates and move backward
                            end--;
                        }

                        break;
                    } else if (currentSum > pendingSum) {
                        end--;
                    } else {
                        start++;
                    }

                }

            }
        }
        return lists;
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
//        TC=> O(N^3) + O(N logN) ==> O(N^3)
        List<List<Integer>> lists = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);// Bcz 2 sum works in sorted array // TC=> O(n logn)
//        System.out.println("AA " + Arrays.toString(nums));
        // TC=> O(N^3)
        for (int i = 0; i < n - 3; i++) { // O(N)

            if (i > 0 && nums[i] == nums[i - 1]) // i>0, bcz we dont want to check duplicates at the 0th index, so we check when it's i > 0, check by a[i] != a[i-1]
            {
                continue; // skip the rest of the below code
            }
            //three sum
            for (int j = i + 1; j < n - 2; j++) { // O(N)

                if (j > (i + 1) && nums[j] == nums[j - 1]) // j> i+1, bcz we don't want to check the j at the first k, once j move to the next elements than we want to check the duplicates
                {
                    continue; // skip the rest of the below code
                }

                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = nums[i]; // imp use long
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if (sum == target) {

                        List<Integer> currentFourSum = new ArrayList<>();
                        currentFourSum.add(nums[i]);
                        currentFourSum.add(nums[j]);
                        currentFourSum.add(nums[k]);
                        currentFourSum.add(nums[l]);

                        lists.add(currentFourSum);

                        k++;// move to next element, bcz we will be checking duplicates and we need to check current and previous values
                        l--;// move to next element, bcz we will be checking duplicates and we need to check current and previous values

                        while (k < l && nums[k] == nums[k - 1]) {// After moving to next, check duplicates and skip the duplicates and move forward
                            k++;
                        }


                        while (k < l && nums[l] == nums[l + 1]) {// After moving to next, check duplicates and  skip the duplicates and move backward
                            l--;
                        }
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }

                }
            }
        }
        return lists;
    }
}
