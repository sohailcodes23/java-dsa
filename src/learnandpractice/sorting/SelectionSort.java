package learnandpractice.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int a[] = {1, 6, 3, 7, 2};
//        selectionSort(a);
        selectionSortV2(a);

        // Not a major change between selectionSort & selectionSortV2
    }

    static void selectionSortV2(int nums[]) {
//        [Instead of taking smallestElement and comparing it we can directly compare with the ith index, bcz we have to swap ith index with the smallest element that is smaller than ith index element]

        // TC=> O(N^2)
        // We will select the smallest element and swap with 0th index
        // Since from 0 to 0 is sorted we will check from 1st index to n-1, and get the smallest element and swap it with the 1st index
        // Since from 0 to 1 is sorted we will check from 2nd index to n-1, and get the smallest element and swap it with the 2nd index
        // this will go on till we are at the 2nd last element bcz if all the element from 0 to 2nd last element are sorted that means the last element is at correct place
        int n = nums.length;
        for (int i = 0; i <= n - 2; i++) {// n-2 , bcz we only need to check till 2nd last element
            int smallestElementIndex = i;
            for (int j = i; j < n; j++) {
                if (nums[j] < nums[smallestElementIndex]) {// nums[j] < nums[smallestElementIndex]: here considering ith index as the smallest element and comparing to rest of the elements bcz we have to swap i th index with the element that is smaller than ith index element]
                    smallestElementIndex = j;
                }
            }
            if (i != smallestElementIndex) {
                int temp = nums[i];
                nums[i] = nums[smallestElementIndex];
                nums[smallestElementIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    static void selectionSort(int nums[]) {
        // TC=> O(N^2)
        // We will select the smallest element and swap with 0th index
        // Since from 0 to 0 is sorted we will check from 1st index to n-1, and get the smallest element and swap it with the 1st index
        // Since from 0 to 1 is sorted we will check from 2nd index to n-1, and get the smallest element and swap it with the 2nd index
        // this will go on till we are at the 2nd last element bcz if all the element from 0 to 2nd last element are sorted that means the last element is at correct place
        int n = nums.length;
        for (int i = 0; i <= n - 2; i++) {// n-2 , bcz we only need to check till 2nd last element
            int smallestElementIndex = 0;
            int smallestElement = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (nums[j] < smallestElement) {
                    smallestElement = nums[j];
                    smallestElementIndex = j;
                }
            }
            if (i != smallestElementIndex) {
                int temp = nums[i];
                nums[i] = nums[smallestElementIndex];
                nums[smallestElementIndex] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
