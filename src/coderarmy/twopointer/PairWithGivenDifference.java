package coderarmy.twopointer;

import java.util.Arrays;

public class PairWithGivenDifference {

    public static void main(String[] args) {

//        int arr[] = {1, 2, 6, 3, 4};//0
        int arr[] = {5, 20, 3, 2, 5, 80}; //17
        System.out.println(findPair(arr, arr.length, 17));
    }

    public static boolean findPair(int arr[], int n, int target) {

        //Final TC=> O(N logN) + O(N) == O(N logN) , since the dominant factor is the sorting operation that's why skipped the O(N).

        Arrays.sort(arr);// TC=> O(N logN)
        int start = 0;
        int end = start + 1;
        while (end <= n - 1) {// TC=>O(N)

            int diff = arr[end]
                    - arr[start];
            if (diff == target) {
                return true;
            } else if (diff < target) {// if diff<target, the max no. to get diff is at right
                end++;
            } else {// if diff>target, the min no. to get diff is at right
                start++;
            }

            if (start == end) {//  bcz we don't want to subtract the same element
                end++;
            }
        }

        return false;
    }
}
