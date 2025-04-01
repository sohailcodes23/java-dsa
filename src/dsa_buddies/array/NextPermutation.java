package dsa_buddies.array;

import java.util.Arrays;

public class NextPermutation {


    public static void main(String[] args) {
//        int[] arr = {2, 4, 1, 7, 5, 0};//2, 4, 5, 0, 1, 7
//        int[] arr = {1, 2, 3, 6, 5, 4};//1 2 4 3 5 6
        int[] arr = {1, 3, 4, 2, 5};//1 2 4 3 5 6

        nextPermutation(arr);
    }


    static void nextPermutation(int[] arr) {
        // TC=O(3N)
        int n = arr.length;

        //1. find the lowest element index from back
        int breakPointIndex = -1;
        for (int i = n - 2; i >= 0; i--) {// TC=O(N)
            if (arr[i] < arr[i + 1]) {
                breakPointIndex = i;
                break;
            }
        }

        // loop from back and find the element grater than the index value and swap

        if (breakPointIndex == -1) {
            reverseArray(0, n - 1, arr);
        } else {

            for (int i = n - 1; i >= breakPointIndex; i--) {// TC=O(N)
                if (arr[i] > arr[breakPointIndex]) {
                    swapBasedOnIndex(i, breakPointIndex, arr);
                    reverseArray(breakPointIndex + 1, n - 1, arr);// TC=O(N)
                    break;
                }
            }

        }

        System.out.println(Arrays.toString(arr));
        // reverse the array from the index

    }


    // reverse the array from the index


    static void reverseArray(int i, int j, int[] arr) {
        while (i <= j) {// while loop so we can swap all the elements
            swapBasedOnIndex(i, j, arr);
            i++;
            j--;
        }
    }

    public static void swapBasedOnIndex(int j, int i, int[] array) {
        int tempValue = array[j]; // IMP store the value not the index
        array[j] = array[i];
        array[i] = tempValue;
    }

}