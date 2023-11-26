package practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumZero {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
//        list.addAll(Arrays.asList(13, 14, 3, 8, 2));
//        list.addAll(Arrays.asList(1, 3, -1, 4, -4)); // -4 4
//        list.addAll(Arrays.asList(1, -1, 2, -2)); // -4 4
//        list.addAll(Arrays.asList(2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4)); // -4 4

        System.out.println("ANS " + LongestSubsetWithZeroSumv2(list));
    }

    public static int LongestSubsetWithZeroSumv2(ArrayList<Integer> arr) {

        int n = arr.size();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {

            sum = arr.get(i) + sum;
            if (sum == 0) {
                maxLen = i + 1;//  adding this so that if the sum is 0 that means till that index all the elements total sum is 0
            } else {
                if (!hashMap.containsKey(sum)) { // checking if sum doesn't exist, so that you can add
                    hashMap.put(sum, i);
                } else { // if sum exist that check the index length difference between the 2 elements
                    int oldSumKeyIndex = hashMap.get(sum);

                    int length = i - oldSumKeyIndex;
                    maxLen = Math.max(length, maxLen); // take the max length
                }
            }
        }
        return maxLen;

    }

}