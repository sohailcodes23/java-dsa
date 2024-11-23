package dsa_buddies.array;

import java.util.Arrays;

public class RotateLeftArrayByK {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5}; // 4 5 1 2 3
//        int arr[] = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};

        rotateArr(arr, 2);
    }

    static void rotateArr(int arr[], int d) {
        // TC=> d + N + N ==> O(2N) ==> O(N)
        int n = arr.length;
        d = d % n;
        reverseArray(0, d - 1, arr); // Reverse from 0 to d // TC=> O(d)
        reverseArray(d, n - 1, arr);// Reverse from d to end // TC=> O(N)
        reverseArray(0, n - 1, arr);// Reverse from 0 to end  // TC=> O(N)
    }

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

    static void rotateArr_Brute(int arr[], int d) {
        // add your code here
        int n = arr.length;
        int[] temp = new int[n];
        int j = 0;
        // Move all the elemenst to left
        for (int i = d; i < n; i++) {
            temp[j] = arr[i];
            j++;
        }

        //Mpove d starting elements to end
        int a = 0;
        for (int i = j; i < n; i++) {
            temp[i] = arr[a];
            a++;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
        System.out.println("TT " + Arrays.toString(arr));
    }
}
