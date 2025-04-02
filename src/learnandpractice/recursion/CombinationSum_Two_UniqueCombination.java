package learnandpractice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_Two_UniqueCombination {

    public static void main(String[] args) {
        int a[] = {2, 5, 2, 1, 2};// working' : T : 5
//        int a[] = {2, 3, 5}; // T: 8

        System.out.println("ANS " + combinationSum(a, 5));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // TC==> O(2^N * k) ==> O(2^N): k is based on assumption that the average length of the combination sum is k, Each index divide

        // SC==> O(k * x) + O(n) (recursion stack space) , K is average length of space, x = no. of combinations : Cannot predict the SC, it depends on the no. of combinations

        int n = candidates.length;
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> currentSubsequenceList = new ArrayList<>();
        Arrays.sort(candidates);// IMP: need this so that once RF1 check is completed for the 1st time, and next time we skip the used/duplicate elements for sum
        System.out.println("NEW " + Arrays.toString(candidates));
        recursiveFunctionToCheckTheSum_Optimised(0, n, candidates, target, results, currentSubsequenceList);
        return results;
    }


    private static void recursiveFunctionToCheckTheSum_Optimised(int i, int n, int arr[], int target, List<List<Integer>> results, List<Integer> currentSubsequenceList) {
        if (target == 0) { //we have met the target, so this is the currentSubsequenceList which has the sum, target = 0, bcz we are deducting the target with current element
            results.add(new ArrayList<>(currentSubsequenceList));
            return;
        }

        for (int j = i; j < n; j++) {
            // j> i, if arr={1,1,1,4,5}, Here when i = 0th, we need to skip 1,2 index value
            // But when i=1, we need to allow i=1, so that we can check and skip 2nd index value
            // if this is not added, it will skip 1 at all the loop levels
            // Skip duplicates
            if (j > i // Skip duplicate ONLY in the same loop
                    && arr[j] == arr[j - 1]) {
                continue;
            }

            // If current element is greater than the remaining target, no need to proceed further
            if (arr[j] > target) {
                break;
            }

            // Include current element in the subset
            currentSubsequenceList.add(arr[j]);
            // Recursive call to find remaining sum, moving to the next index
            recursiveFunctionToCheckTheSum_Optimised(j + 1, n, arr, target - arr[j], results, currentSubsequenceList);// RF1
            // 1. j+1: Use all the index to check the sum
            // 2. target-arr[j]: Deducting curr element value from the target to check the pending value is == curr element
            // 3. There will be a point where if after deduction target is == 0, that means we found all the elements which is == actual target as well
            // 4. It might happen that due to deduction target is now smaller than the currr element, EX: target = 1, currEle= 3, that means we would never be able to find sum in such conditions

            // Backtrack to explore other possibilities
            currentSubsequenceList.remove(currentSubsequenceList.size() - 1);
        }
    }


    // Better: Using multiple RF
    private static void recursiveFunctionToCheckTheSum_Better(int i, int n, int arr[], int target, List<List<Integer>> results, List<Integer> currentSubsequenceList) {

        if (i >= n) {
            if (target == 0) { //we have met the target, so this is the currentSubsequenceList which has the sum, target = 0, bcz we are deducting the target with current element
                results.add(new ArrayList<>(currentSubsequenceList));
                return;
            }
            return;
        }

        // Check the same index, with deduction in target
        if (arr[i] <= target) {// Currently target is greater than curr element which means we can find the sum with this currentSubsequenceList
            currentSubsequenceList.add(arr[i]);

            recursiveFunctionToCheckTheSum_Better(i + 1, n, arr, target - arr[i], results, currentSubsequenceList);// RF1
            // 1. i+1: Use all the index to check the sum
            // 2. target-arr[i]: Deducting curr element value from the target to check the pending value is == curr element
            // 3. There will be a point where if after deduction target is == 0, that means we found all the elements which is == actual target as well
            // 4. It might happen that due to deduction target is now smaller than the currr element, EX: target = 1, currEle= 3, that means we would never be able to find sum in such conditions

            currentSubsequenceList.remove(currentSubsequenceList.size() - 1);
        }

        // **RF2:** Skip all duplicate elements: the reason we have added this after RF1, bcz at first we want to use all the element, but during next RF call, we want to skip the duplicates
        // so when RF1 is completed it will come back and the index will be the same which was used in RF1, so we want to check if the current index value is duplicate in rest of the elements, if yes we want to skip it
        //EX: RF1: index :1st index: '2', now we want to check if rest of the elements are not '2', if yes skip it and move to index which is not '2', This is the reason we need the array to be sorted
        int nextIndex = i + 1;
        while (nextIndex < arr.length && arr[nextIndex] == arr[i]) {
            nextIndex++;
        }

        // Check the all the indexes, with NO deduction in target, so it would check index 0th + 1st + 2nd... till it finds the sum or till it reaches the last index
        recursiveFunctionToCheckTheSum_Better(nextIndex, n, arr, target, results, currentSubsequenceList);//RF2
    }
}
