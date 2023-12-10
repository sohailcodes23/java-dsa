package practice.map_sets;

import java.util.HashMap;

public class CountSubArraysHavingSumDivisibleByK {

    public static void main(String[] args) {

        int[] array = {4, 5, 0, -2, -3, 1};
//        int[] array = {5, 0, 2, 3, 1};


        System.out.println("ANS " + subarraysDivByK(array, 5));
    }

    public static int subarraysDivByK(int[] nums, int k) {

        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {

            ans = nums[i] + ans;
            int remainder = ans % k;

            hashMap.put(remainder, hashMap.getOrDefault(remainder, 0) + 1);
            System.out.println(i + " " + remainder + " " + hashMap.get(remainder));
        }

        ans = hashMap.get(0) + 1;


        return ans ;
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
