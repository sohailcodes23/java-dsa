package learnandpractice.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_One_UnlimitedCombination {

    public static void main(String[] args) {
        int a[] = {2, 3, 6, 7};// working' : T : 7
//        int a[] = {2, 3, 5}; // T: 8

        System.out.println("ANS " + combinationSum(a, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // TC is not O(2^n): bcz here it has unlimited combinations, if the QQ was that 1 index should only be used once this migth be the case
        // TC==> O(2^t * k): t is the no. of times the same index is called to take or not take & k is based on assumption that the average length of the combination sum is k
        // EX: arr={1}, k= 10, this will take 0th index 10 times to get the k sum

        // SC==> O(k * x) , K is average length of space, x = no. of combinations : Cannot predict the SC, it depends on the no. of combinations

        int n = candidates.length;
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> currentSubsequenceList = new ArrayList<>();
        recursiveFunctionToCheckTheSum(0, n, candidates, target, results, currentSubsequenceList);
        return results;
    }

    private static void recursiveFunctionToCheckTheSum(int i, int n, int arr[], int target, List<List<Integer>> results, List<Integer> currentSubsequenceList) {

        if (i >= n) {
            if (target == 0) { //we have met the target, so this is the currentSubsequenceList which has the sum, target = 0, bcz we are deducting the target with current element
                results.add(new ArrayList<>(currentSubsequenceList));
            }
            return;
        }

        // Check the same index, with deduction in target
        if (arr[i] <= target) {// Currently target is greater than curr element which means we can find the sum with this currentSubsequenceList
            currentSubsequenceList.add(arr[i]);

            recursiveFunctionToCheckTheSum(i, n, arr, target - arr[i], results, currentSubsequenceList);// RF1
            // 1. i: Use the same index to check the sum, EX: check index 0th till it finds the sum or till target is < currElement, than move to next element due to RF2
            // 2. target-arr[i]: Deducting curr element value from the target to check the pending value is == curr element
            // 3. There will be a point where if after deduction target is == 0, that means we found all the elements which is == actual target as well
            // 4. so we can use the same element multiple time to check the sum, that why always passing i as the index and updating the target
            // 5. It might happen that due to deduction target is now smaller than the currr element, EX: target = 1, currEle= 3, that means we would never be able to find sum in such conditions

            currentSubsequenceList.remove(currentSubsequenceList.size() - 1);
        }
        // Check the all the indexes, with NO deduction in target, so it would check index 0th + 1st + 2nd... till it finds the sum or till it reaches the last index
        recursiveFunctionToCheckTheSum(i + 1, n, arr, target, results, currentSubsequenceList);//RF2
    }


    // Brute: didn't worked
//    private static void recursiveFunctionToCheckTheSum(int i, int n, int arr[], int k, int sum, List<List<Integer>> results, List<Integer> currentSubsequenceList) {
//
//        if (i >= n) {
//            System.out.println("LL " + currentSubsequenceList);
//            if (sum == k) {
//                results.add(new ArrayList<>(currentSubsequenceList));
//            } else if (sum < k) {// checking the currentSubsequenceList if sum!=taget, but can a repeated element be equal to sum
//                int currSum = 0;
//                for (int j = 0; j < currentSubsequenceList.size(); j++) {
//                    currSum = currSum + currentSubsequenceList.get(j);
//                    if (currSum > k) {
//                        return;// this currentSubsequenceList is != target
//                    }
//                }
//
//                // check if the pending sum can be fetched from the currentSubsequenceList
//                if (currSum < k) {
//                    int pending = k - currSum;
//                    List<Integer> newCurrentSubsequenceList = new ArrayList<>();
//                    boolean found = false;
//                    for (int j = 0; j < currentSubsequenceList.size(); j++) {
//                        newCurrentSubsequenceList.add(currentSubsequenceList.get(j));
//                        if (currentSubsequenceList.get(j) == pending) {
//                            found = true;
//                            newCurrentSubsequenceList.add(pending);
//                        }
//                    }
//                    if (found == true) {
//                        results.add(new ArrayList<>(newCurrentSubsequenceList));
//                    }
//                }
//            }
//            return;
//        }
//
//        currentSubsequenceList.add(arr[i]);
//        sum = sum + arr[i];
//        recursiveFunctionToCheckTheSum(i + 1, n, arr, k, sum, results, currentSubsequenceList);
//
//        currentSubsequenceList.remove(currentSubsequenceList.size() - 1);
//        sum = sum - arr[i];
//
//        recursiveFunctionToCheckTheSum(i + 1, n, arr, k, sum, results, currentSubsequenceList);
//    }

}
