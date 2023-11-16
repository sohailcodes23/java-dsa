package array.medium;

import java.util.Arrays;

// Difference between elements should be 1, array can be reordered/sorted
public class LongestSuccessiveElement {

    public static void main(String[] args) {

//        int array[] = {5,8, 3, 2, 4, 1};
        int array[] = {1, 2, 2, 1};

        int i = longestSuccessiveElements(array);

        System.out.println("ANS " + i);
    }

    public static int longestSuccessiveElements(int[] a) {

//        TC=> O(N)
        Arrays.sort(a); // Sort SC=> O(N log N)

        int n = a.length;
        int lastSmallest = Integer.MIN_VALUE; // to compare it should be the smallest
        int count = 0; // count when a smallest number is found and than increment
        int longestSequence = 1; // 1 assuming the longest we can get is 1
        for (int i = 0;i<n;i++) {

            if (a[i] - 1 == lastSmallest) { // a[i] - 1 to check if it's consecutive( the difference is 1 or not)
                count += 1;
                lastSmallest = a[i];
            } else if (lastSmallest != a[i]) {
                count = 1;
                lastSmallest = a[i];
            }

            longestSequence = Math.max(longestSequence, count);
        }

        return longestSequence;
    }
}
