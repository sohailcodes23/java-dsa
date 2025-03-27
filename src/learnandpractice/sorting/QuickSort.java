package learnandpractice.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
//        int arr[] = {3, 2, 4, 1, 3};
//        int arr[] = {5, 2, 3, 1};
        int arr[] = {110, 100, 0};
        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    static int[] quickSort(int a[], int low, int high) {

        if (low < high) {
            int partitionIndex = movePivotIndexToCorrectPlace(a, low, high);
            quickSort(a, low, partitionIndex - 1);//this will handle the (left side) smaller elements compare to pivot element
            quickSort(a, partitionIndex + 1, high);//this will handle the (right side) bigger elements compare to pivot element
        }

        return a;
    }

    static int movePivotIndexToCorrectPlace(int a[], int low, int high) {
        int i = low;
        int j = high;
        int pivot = a[low];

        // compare left and right side
        while (i < j) {

            // find the 1st bigger element from left
            while (a[i] <= pivot && i < high) {// so if we find any no. < pivot we are ignoring it and taking index to the 1st bigger element
                i++;
            }
            // find the 1st smaller element from right
            while (a[j] > pivot && j > low) {// so if we find any no. > pivot we are ignoring it and taking index to the 1st smaller element
                j--;
            }
            // found both the first smaller and bigger element
            if (i < j) {// EVen after moving i to the right, i is at the left side of the pivot and vice versa for j, we need to swap
                swap(a, i, j);
            }
        }
        // SWAP at j>i with pivot to correct position
        swap(a, low, j);//Out of loop bcz j has come to left side, i and j have crossed the path, no need to check further, just put the pivot (low index) to the correct position which is j th index

        return j;// j bcz j is the partition index
    }

    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
