package array.easy;

import java.util.Arrays;

public class MissingNumber {

    public static void main(String[] args) {
        int a[] = {1, 2, 4, 5};
//        int a[] = {1, 3};

        System.out.println("ANS " + missingNumber_Better(a, a.length));
    }

    //OWN
    static int findMissingNumber(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return nums[i] - 1;
            }
        }

        return -1;
    }

    // Better
    public static int missingNumber_Better(int[] a, int N) {

        int hash[] = new int[N + 1]; //hash array, bcz there is a missing value, so to add in has we are taking an extra size

        // storing the frequencies:
        for (int i = 0; i < N - 1; i++) {
//            hash[a[i]]++;
            hash[a[i]] = hash[a[i]] + 1; // assigning values based on the index value, so the missing number will be by default 0
        }
        //checking the freqencies for numbers 1 to N:
        for (int i = 1; i <= N; i++) { // starting from 1 bcz 0th index value will be zero and we don't want to check that
            if (hash[i] == 0) {     // if 0 that means that element is missing
                return i;
            }
        }

        // The following line will never execute.
        // It is just to avoid warnings.
        return -1;
    }

    //Brute
    static int findMissingNumber_Brute(int[] nums) {

        for (int i = 1; i <= nums.length; i++) {

            boolean iValueIdPresent = false;

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) { // checking array index value with the normal value like 1,2,3,4 that's y i start from i
                    iValueIdPresent = true;
                    break;
                }
            }

            if (!iValueIdPresent) {
                return i;
            }
        }
        return -1;
    }

}
