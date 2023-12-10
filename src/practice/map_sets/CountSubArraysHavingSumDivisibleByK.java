package practice.map_sets;

import java.util.ArrayList;
import java.util.HashMap;

//https://www.youtube.com/watch?v=QM0klnvTQzk
public class CountSubArraysHavingSumDivisibleByK {

    public static void main(String[] args) {

//        int[] array = {4, 5, 0, -2, -3, 1}; // k=5  OP:7
//        int[] array = {5, 0, 2, 3, 1}; // k=5 OP:6
//        int[] array = {2, 3, 5, 4, 5, 3, 4}; // k=7 OP:4
        int[] array = {-1, 2, 9}; // k=2 OP:2

        System.out.println("ANS " + subarraysDivByK(array, 2));
    }

    // leetcode
    public static int subarraysDivByK(int[] nums, int k) {

        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(0, 1);//{remainder, occurence} // required to calculate
        int maxSubArrayCount = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum = nums[i] + sum;

            int remainder = sum % k;

            if (remainder < 0) { // Special case, if remainder is -ve than we need to update add it with k, for explanation check above youtube link, basically if we add +k and -k in the equation than we will get a new remainder
                remainder = k + remainder;
            }
            if (hashMap.containsKey(remainder)) {
                maxSubArrayCount = hashMap.get(remainder) + maxSubArrayCount;
            }
            hashMap.put(remainder, hashMap.getOrDefault(remainder, 0) + 1); // we always want to increment the remainder


        }


        return maxSubArrayCount;
    }

    //codestudio
    public static int subArrayCount(ArrayList<Integer> nums, int k) {

        int n = nums.size();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(0, 1);//{remainder, occurence} // required to calculate
        int maxSubArrayCount = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum = nums.get(i) + sum;

            int remainder = sum % k;

            if (remainder < 0) { // Special case, if remainder is -ve than we need to update add it with k, for explanation check above youtube link, basically if we add +k and -k in the equation than we will get a new remainder
                remainder = k + remainder;
            }
            if (hashMap.containsKey(remainder)) {
                maxSubArrayCount = hashMap.get(remainder) + maxSubArrayCount;
            }
            hashMap.put(remainder, hashMap.getOrDefault(remainder, 0) + 1); // we always want to increment the remainder


        }


        return maxSubArrayCount;
    }

    public static int subarraysDivByK_Brute(int[] nums, int k) {

        // k=5
        int n = nums.length;
        int maxElement = 0;
        for (int i = 0; i < n; i++) {

            int ans = 0;
            for (int j = i; j < n; j++) {

                ans = nums[j] + ans;

                if (ans % k == 0) {
                    maxElement++;
                }

            }
        }

        return maxElement;
    }
}
