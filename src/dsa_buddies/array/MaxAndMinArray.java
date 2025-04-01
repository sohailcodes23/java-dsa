package dsa_buddies.array;
//https://www.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1

import javafx.util.Pair;

public class MaxAndMinArray {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 1, 6, 3};

    }

    public static Pair<Long, Long> getMinMax(int[] arr) {
        int n = arr.length;
        int min = arr[0];
        int max = arr[n - 1];

        for (int i = 0; i < n; i++) {

            if (arr[i] < min) {
                min = arr[i];
            }


            if (arr[i] > max) {
                max = arr[i];
            }
        }

        Pair<Long, Long> longLongPair = new Pair<>((long) min, (long) max);

        return longLongPair;
    }
}
