package array.medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int array[] = {2, 6, 5, 8, 11};

        System.out.println(Arrays.toString(GetIndexOfTwoSum_Better(array, 15)));
    }

    static int[] GetIndexOfTwoSum_Better(int array[], int target) {

//        TC=> O(N), since HashMap is unordered map, the TC is O(N), if the map was ordered map than TC is O(N x logN)
//        SC=> O(N)

        // add the array values as keys and index and values
//        check the difference between the current value and target and check if the pensing value exist as key in map
        // if yes than you got the 2 index

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int pendingValue = target - array[i];
            if (!hashMap.containsKey(pendingValue)) {
                hashMap.put(array[i], i);
            } else {
                Integer integer = hashMap.get(pendingValue);
                return new int[]{i, integer};
            }
        }


        return new int[]{-1, -1};
    }

    static int[] GetIndexOfTwoSum_Brute(int array[], int target) {
//TC=> O(N^2)
//SC=> O(1)

        for (int i = 1; i < array.length; i++) {
            int start = array[i];


            for (int j = 0; j < array.length; j++) {
                if (start + array[j] == target) {
                    System.out.println(start + "  " + array[j]);
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }


    // Brute
    static boolean TwoSumExist_Brute(int array[], int target) {


        for (int i = 1; i < array.length; i++) {
            int start = array[i];


            for (int j = 0; j < array.length; j++) {
                if (start + array[j] == target) {
                    System.out.println(start + "  " + array[j]);
                    return true;
                }
            }
        }

        return false;
    }

}
