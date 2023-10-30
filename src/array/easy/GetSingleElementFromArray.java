package array.easy;

import java.util.HashMap;
import java.util.Map;

public class GetSingleElementFromArray {

    public static void main(String[] args) {
//        int[] arr = {1, 1, 2, 3, 3, 4, 4, 5, 5};
        int[] arr = {4, 1, 2, 1, 2};

        System.out.println("ANS " + getSingleElement_Better2(arr));
    }

    // Need to read more about xor
    public static int getSingleElement_Optimal(int []arr) {
        //size of the array:
        int n = arr.length;

        // XOR all the elements:
        int xorr = 0;
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ arr[i];
        }
        return xorr;
    }

    public static int getSingleElement_Better2(int[] arr) {
//Time Complexity: O(N*logM) + O(M), where M = size of the map i.e. M = (N/2)+1. N = size of the array.
//Reason: We are inserting N elements in the map data structure and insertion takes logM time(where M = size of the map). So this results in the first term O(N*logM). The second term is to iterate the map and search the single element. In Java, HashMap generally takes O(1) time complexity for insertion and search. In that case, the time complexity will be O(N) + O(M).
//
//Note: The time complexity will be changed depending on which map data structure we are using. If we use unordered_map in C++, the time complexity will be O(N) for the best and average case instead of O(N*logM). But in the worst case(which rarely happens), it will be nearly O(N2).
//
//Space Complexity: O(M) as we are using a map data structure. Here M = size of the map i.e. M = (N/2)+1.
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = hashMap.getOrDefault(arr[i], 0);// to store default value as 0
            hashMap.put(arr[i], value + 1);
        }

        for (Map.Entry<Integer, Integer> entrySet : hashMap.entrySet()) {
            if (entrySet.getValue() == 1) {
                return entrySet.getKey();
            }
        }

        return -1;
    }

    public static int getSingleElement_Better1(int[] arr) {
// TC=> O(N)+O(N)+O(N), where N = size of the array
//Reason: One O(N) is for finding the maximum, the second one is to hash the elements and the third one is to search the single element in the array.
        // SC= >  O(maxNum+1) where maxNum = the maximum element of the array.
        int maxNum = -1;
        for (int i = 0; i < arr.length; i++) {
            maxNum = Math.max(maxNum, arr[i]);
        }

        System.out.println("MAX " + maxNum);

        int hash[] = new int[maxNum + 1]; // IMP to add +1 so that hash[] can store max value as well

        for (int i = 0; i < hash.length; i++) {
            hash[arr[i]] = hash[arr[i]] + 1; // So if the i value s 2 so on the 2nd index the value will be incremented by 1, default value is 0
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[arr[i]] == 1) {
                return arr[i];
            }
        }

        return -1;
    }

    public static int getSingleElement_Brute(int[] arr) {

//        TC=> O(N^2)
// SC=> O(1) as we are not using any extra space.
        // take first element and compare with next element and save the count and if the count is 1 than return

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int count = 0;

            for (int j = 0; j < arr.length; j++) {

                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count == 1) {
                return arr[i];
            }
        }

        return -1;
    }
}
