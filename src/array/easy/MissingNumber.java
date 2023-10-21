package array.easy;

import util.CommonUtility;

public class MissingNumber {

    public static void main(String[] args) {
        int a[] = {1, 2, 4, 5};
//        int a[] = {1, 3};

        System.out.println("ANS " + findMissingNumber_Optimal1(a));
    }

    //OWN
    static int findMissingNumber(int[] nums) {
        // TC ==> O(N)
        // SC ==> O(1), bcz no extra space is taken
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return nums[i] - 1;
            }
        }

        return -1;
    }

    //Optimal 2, didn't understood
    public static int missingNumber(int[] a, int N) {

        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < N - 1; i++) {
            xor2 = xor2 ^ a[i]; // XOR of array elements
            xor1 = xor1 ^ (i + 1); //XOR up to [1...N-1]
        }
        xor1 = xor1 ^ N; //XOR up to [1...N]

        return (xor1 ^ xor2); // the missing number
    }

    //Optimal 1
    static int findMissingNumber_Optimal1(int[] nums) {

        // TC ==> O(N)
        // SC ==> O(1), bcz no extra space is taken
        int sumOfNNaturalNumbers = CommonUtility.sumOfNNaturalNumbers(nums.length + 1); // adding +1 bcz 1 number is missing and we want N number to calculate sumOfNNaturalNumbers

        int arraySum = CommonUtility.sumOfArrayValues(nums);
        return sumOfNNaturalNumbers - arraySum;
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
