package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class FruitIntoBasket {

    public static void main(String[] args) {
        Integer arr[] = {3, 1, 2, 2, 2, 2};

        System.out.printf("ANS " + totalFruits_Brute(arr));
    }

    public static int totalFruits_Brute(Integer[] arr) {
//        TC=> O(N^2)
//        SC=>O(log N) == O(log 3) ==> 1, constant
        int n = arr.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> integers = new HashSet<>();

            for (int j = i; j < n; j++) {
                integers.add(arr[j]);
                if (integers.size() <= 2) {
                    maxLen = Math.max(j - i + 1, maxLen);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }
}
