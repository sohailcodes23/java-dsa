package practice.basicAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class MooreVotingAlgorithm {
    public static void main(String[] args) {

        int array[] = {2, 2, 1, 1, 1, 2, 2, 1, 1, 1, 1};
//        int array[] = {0, 0};

        System.out.printf("ANS " + majorityElement_Optimal(array));
    }


    public static int majorityElement_Optimal(int[] nums) {


        // TC => O(2N)
        // SC=> O(N)
        int n = nums.length;
        int check = n / 2;
        int element = nums[0];
        int count1 = 0;


        for (int i = 0; i < n; i++) {
            if (count1 == 0) {
                element = nums[i];
                count1 = 1;
            } else if (element == nums[i]) {
                count1++;
            } else {
                count1--;
            }

        }

        // if problem says that this array might have majority element only than add below loop
        // count1 doesn't matter
        int count2 = 0;
        for (int i = 0; i < n; i++) { // this loop is for checking only, since at the end the element can be ans but the count1 can be less, so we need to check the element in the whole array
            if (element == nums[i]) {
                count2++;
            }
        }


        if (count2 > check) {
            return element;
        }

        return -1;
    }

    public static int majorityElement_Better(int[] nums) {

//        TC=> O(2N)
        // SC=> O(N)
        int check = nums.length / 2;
        int result = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int n : nums) {
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
        }

        int currentMaxValue = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {
            if (integerIntegerEntry.getValue() > check) {
                if (integerIntegerEntry.getValue() > currentMaxValue) {
                    result = integerIntegerEntry.getKey();
                }
            }
            currentMaxValue = Math.max(currentMaxValue, integerIntegerEntry.getValue());
        }


        return result;
    }

}
