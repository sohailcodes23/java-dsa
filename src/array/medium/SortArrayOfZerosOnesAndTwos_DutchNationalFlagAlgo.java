package array.medium;

import util.CommonUtility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


//DutchNationalFlagAlgo :
// 0th index ---> (low-1) : O's (extreme left)
// low ---> mid-1 : 1's
// high+1 ---> n-1 : 1's        (extreme right)

// Here the mid --- high is unsorted part of the array
// the start of the array 0th index will be low and mid pointer and high will be last index (n-1)

// IF we are using mid to sort than :
// if a[mid] == 0 than swap(a[low], a[mid]) and low++, mid++
// if a[mid] == 1 than mid++
// if a[mid] == 2 than swap(a[mid], a[high]) and high--
public class SortArrayOfZerosOnesAndTwos_DutchNationalFlagAlgo {

    public static void main(String[] args) {
        int[] array = {0, 2, 0, 2, 1, 0, 2, 0, 0, 1};

        System.out.println("ANS " + Arrays.toString(sortArrayOfZerosOnesAndTwos_Optimal(array)));
    }

    //DutchNationalFlagAlgo, check description
    static int[] sortArrayOfZerosOnesAndTwos_Optimal(int array[]) {
// TC=> O(N)
// SC=> O(1)
        int low = 0;
        int mid = 0;
        int high = array.length - 1;

        while (mid <= high) {
            if (array[mid] == 0) {
                CommonUtility.swapBasedOnIndex(low, mid, array);
                low++;
                mid++;
            } else if (array[mid] == 1) {
                mid++;
            } else {
                CommonUtility.swapBasedOnIndex(mid, high, array);
                high--;
            }
        }

        return array;
    }

    // OWN
    static int[] sortArrayOfZerosOnesAndTwos_Better2(int array[]) {
        int[] hash = new int[3];

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                hash[0] = hash[0] + 1;
            } else if (array[i] == 1) {
                hash[1] = hash[1] + 1;
            } else if (array[i] == 2) {
                hash[2] = hash[2] + 1;
            }
        }

        int currentFilledIndex = 0;

        for (int i = 0; i < hash.length; i++) {
            for (int j = 0; j < hash[i]; j++) {
                array[currentFilledIndex] = i;
                currentFilledIndex++;
            }
        }
        return array;
    }

    // OWN
    static int[] sortArrayOfZerosOnesAndTwos_Better1(int array[]) {
// TC => O(N + N^2)
        // SC => O(1)
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            hashMap.put(array[i], hashMap.getOrDefault(array[i], 0) + 1);
        }

        int currentFilledIndex = 0;
        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {

            int key = map.getKey();
            int value = map.getValue();

            for (int i = 0; i < value; i++) {
                array[currentFilledIndex] = key;
                currentFilledIndex++;
            }
        }

        return array;
    }

    // OWN
    static int[] sortArrayOfZerosOnesAndTwos_Brutev2(int array[]) {
        Arrays.sort(array);
        return array;
    }

    // OWN
    static int[] sortArrayOfZerosOnesAndTwos_Brute(int array[]) {
// TC => O(N^2)
        // SC => O(N)

        int toBeSortedBy[] = {0, 1, 2};
        int newSortedArray[] = new int[array.length];
        int k = 0;
        for (int i = 0; i < toBeSortedBy.length; i++) {

            for (int j = 0; j < array.length; j++) {
                if (toBeSortedBy[i] == array[j]) {
                    newSortedArray[k] = array[j];
                    k++;
                }
            }
        }
        return newSortedArray;
    }
}
