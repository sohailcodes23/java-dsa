package practice.array;

import java.util.Arrays;

public class KthSmallestElement {

    public static void main(String[] args) {

        int array[] = {1, 2, 5, 4, 7, 3};

        System.out.println("ANS " + kthSmallest(array.length, 2, array));
    }

    public static int kthSmallest(int n, int k, int[] arr) {

        Arrays.sort(arr);

        return arr[k - 1];
    }
}
