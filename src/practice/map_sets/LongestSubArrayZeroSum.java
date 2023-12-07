package practice.map_sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LongestSubArrayZeroSum {

    public static void main(String[] args) {

        ArrayList<Integer> integers = new ArrayList<>();
//        integers.addAll(Arrays.asList(1, -1, 2, -2));
        integers.addAll(Arrays.asList(1, 3, -1, 4, -4));

        System.out.println("ANS " + LongestSubsetWithZeroSum(integers));
    }


    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
//        TC=> O(N)
//        SC=> O(N)
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = arr.size();
        int maxCount = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum = arr.get(i) + sum; //
            if (sum == 0) {// IMP :  to know the no. of elements when it's zero
                maxCount = i + 1;
            } else { // if it's not zero
                if (hashMap.containsKey(sum)) {
                    int ans = i - hashMap.get(sum); // i is current index - the last time that sum has existed
                    maxCount = Math.max(ans, maxCount);
                } else {
                    hashMap.put(sum, i);
                }
            }
        }

        return maxCount;
    }

    public static int LongestSubsetWithZeroSum_Brute(ArrayList<Integer> arr) {


        int maxCount = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {

            int sum = 0;
            int currentCount = 0;
            for (int j = i; j < n; j++) {

                sum = arr.get(j) + sum;
                currentCount++;
                if (sum == 0) {
                    maxCount = Math.max(currentCount, maxCount);
                }
            }
        }

        return maxCount;
    }
}
