package practice.array;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    public static void main(String[] args) {
//        int nums[] = {2, 7, 11, 15}; //9
        int nums[] = {3, 2, 4}; // 6

        ArrayList<Integer> integers = new ArrayList<>();
        integers.addAll(Arrays.asList(3, 2, 4));

        System.out.println("ANS " + twoSum(integers, 6, nums.length));
    }

    static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            int remaining = target - nums[i];
            if (!map.containsKey(remaining)) {
                map.put(nums[i], i);
            } else {

                Integer contains = map.get(remaining); // fetching value
                return new int[]{contains, i};
            }
        }

        return new int[]{-1, -1};
    }

    // COding ninja
//    https://www.codingninjas.com/studio/problems/two-sum_839653?topList=top-array-coding-interview-questions&leftPanelTabValue=SUBMISSION
    static ArrayList<Pair<Integer, Integer>> twoSum(ArrayList<Integer> arr, int target, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Pair<Integer, Integer>> pairList = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            int remaining = target - arr.get(i);
            if (map.getOrDefault(remaining, -1) != -1) { // if -1 that means the remaining value doesn't exist
                pairList.add(new Pair(remaining, arr.get(i)));
                map.put(arr.get(i), -1); // so that this key and value cannot be used next time
            } else {

                map.put(arr.get(i), i);
            }
        }

        if (pairList.isEmpty()) {
            pairList.add(new Pair<>(-1, -1)); // if not found
        }
        return pairList;
    }

    // Brute
    static int[] twoSum_Brute(int[] nums, int target) {
        // t=6
        // TC=> O(N^2)
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}
