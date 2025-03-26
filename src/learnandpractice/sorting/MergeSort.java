package learnandpractice.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=ogjf7ORKfd8
public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 1, 3};
        mergeSort(arr, 0, arr.length - 1);
    }

    static void mergeSort(int arr[], int low, int high) {
        // base case
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        mergeSortedArrays(arr, low, mid, high);

        System.out.println("LOW " + low + " MID " + mid + " HIGH " + high + " ARRAY " + Arrays.toString(arr));
    }

    static int[] mergeSortedArrays(int arr[], int low, int mid, int high) {
        //1 2 3  // 2 4
        int left = low;
        int right = mid + 1;
        List<Integer> tempSorted = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                tempSorted.add(arr[left]);
                left++;
            } else {
                tempSorted.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            tempSorted.add(arr[left]);
            left++;
        }

        while (right <= high) {
            tempSorted.add(arr[right]);
            right++;
        }
        System.out.println("TEMP " + tempSorted);
        // Copy sorted temp array back to original array at correct position
        for (int i = 0; i < tempSorted.size(); i++) {
            arr[low + i] = tempSorted.get(i);// if low is at 3 than we need to update at 3 not at i=0, that's why low+i, it will change based on current low
            // IMP: low+i:
            // EX 1: Sorting arr[3:4]
            //low = 3, high = 4
            //tempSorted = {1, 3}
            //Copy Back:
            //arr[3 + 0] = 1  →  arr[3] = 1
            //arr[3 + 1] = 3  →  arr[4] = 3

            // EX 2: arr[0:2]
            //low = 0, high = 2
            //tempSorted = {2, 3, 4}
            //Copy Back:
            //arr[0 + 0] = 2  →  arr[0] = 2
            //arr[0 + 1] = 3  →  arr[1] = 3
            //arr[0 + 2] = 4  →  arr[2] = 4

            //EX3: low = 0, high = 4)
            //tempSorted = {1, 2, 3, 3, 4}
            //Copy Back:
            //arr[0 + 0] = 1  →  arr[0] = 1
            //arr[0 + 1] = 2  →  arr[1] = 2
            //arr[0 + 2] = 3  →  arr[2] = 3
            //arr[0 + 3] = 3  →  arr[3] = 3
            //arr[0 + 4] = 4  →  arr[4] = 4
        }

        return arr;
    }
}
