package sorting;

//https://takeuforward.org/data-structure/quick-sort-algorithm/
//https://www.youtube.com/watch?v=WIrA4YexLRQ&t=395s

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// learn and try again
// TS => N log N
public class QuickSort {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr = Arrays.asList(new Integer[]{4, 6, 2, 5, 7, 9, 1, 3});
        arr = quickSort(arr);
        System.out.println("After insertion sort: " + arr);
    }

    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) { // i<j so that while j-- it should not cross the i++ values
            while (arr.get(i) <= pivot && i <= high - 1) { // till i value is less than pivot i is incremented
                i++;
            }

            while (arr.get(j) > pivot && j >= low + 1) { // till j value is greater than pivot j is decremented
                j--;
            }
            if (i < j) { // if j value is more than i that means it has already passed the partition(correct position of pivot)
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        //swapping
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
    }

    static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            qs(arr, low, partitionIndex - 1);
            qs(arr, partitionIndex + 1, high);
        }
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here.
        qs(arr, 0, arr.size() - 1);
        return arr;
    }

}
