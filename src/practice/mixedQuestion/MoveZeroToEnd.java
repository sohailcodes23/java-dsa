package practice.mixedQuestion;

import util.CommonUtility;

import java.util.ArrayList;
import java.util.Arrays;

public class MoveZeroToEnd {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.addAll(Arrays.asList(2, 0, 4, 1, 3, 0, 28));

        pushZerosAtEnd_Betterv2(integers);
    }


    public static void pushZerosAtEnd_Betterv2(ArrayList<Integer> arr) {
        int n = arr.size();
        int nonZeroIndex = 0;

        // Traverse the array and move non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != 0) {
                // Swap non-zero element with the element at nonZeroIndex
                CommonUtility.swapBasedOnIndexArrayList(i, nonZeroIndex, arr);
                nonZeroIndex++;
            }
        }
//        int n = arr.size();
//
//        for (int i = 1; i <= n - 1; i++) {
//            System.out.println(arr.get(i - 1) + " UU " + arr.get(i));
//            if (arr.get(i - 1) == 0 && arr.get(i)!=0) {
//                System.out.println("INN");
//                CommonUtility.swapBasedOnIndexArrayList(i - 1, i, arr);
////                i++;
//            } else if (arr.get(i) != 0) {
//                System.out.println("EE " + arr.get(i));
//
//                CommonUtility.swapBasedOnIndexArrayList(i - 1, i, arr);
////                i++;
//            }
//        }
//
        System.out.println("TT " + arr);

    }

    //Better: Working but not as expected
    // Our O/p: [2, 28, 4, 1, 3, 0, 0] , Expected: 2 4 1 3 28 0 0
    public static void pushZerosAtEnd_Better(ArrayList<Integer> arr) {
        int n = arr.size();
        int left = 0, right = n - 1;

        while (left < right) {
            if (arr.get(right) == 0) {
                right--;
            } else if (arr.get(left) == 0) {
                CommonUtility.swapBasedOnIndexArrayList(left, right, arr);
                left++;
                right--;
            } else if (arr.get(left) != 0) {

                left++;
            } else {
                right--;
            }
        }

        System.out.println("TT " + arr);

    }

    public static void pushZerosAtEnd_Brute(ArrayList<Integer> arr) {
//TC=>O(N^2)
        int n = arr.size();

        ArrayList<Integer> tempArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr.get(i) != 0) {
                tempArr.add(arr.get(i));
            }
        }

        if (tempArr.size() != arr.size()) {
//            int pendingElementCount = arr.size() - tempArr.size();

            for (int i = tempArr.size(); i < arr.size(); i++) {
                tempArr.add(0);
            }
        }

        System.out.println("TT " + tempArr);
        // Reassigning the value in original array

        for (int i = 0; i < tempArr.size(); i++) {
            arr.set(i, tempArr.get(i));
        }

        System.out.println("TT " + arr);

    }
}
