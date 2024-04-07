package coderarmy.array;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertElementToDivideEqualSums {

    public static void main(String[] args) {

        int[] array = {20, 4, 15, 10, 14, 19, 11, 8, 5, 19, 13, 8, 18, 13, 3, 12, 8, 16, 19, 11};
        System.out.println("ANS " + Arrays.toString(minDiffSubarray(array)));
        System.out.println("ANS " + EqualSum(array, array.length));
    }

    public static ArrayList<Integer> EqualSum(int a[], int n) {

//        TC=> O(N)

        int prefixSum = 0;
        int totalSum = 0;
        int minDiff = Integer.MAX_VALUE;
        int minDiffIndex = -1;
        int subArrayCount = 1;

        for (int i = 0; i < n; i++) {// O(N)
            totalSum = totalSum + a[i];
        }

        for (int i = 0; i < n; i++) { // O(N)

            prefixSum = prefixSum + a[i];// left sum till that index
            int rightSum = totalSum - prefixSum; // right side after the current index
            int diff = Math.abs(rightSum - prefixSum); // abs value so that all the values are +ve

            if (diff < minDiff) { // Need to update minDiff
                minDiff = diff;
                minDiffIndex = i + 1;// i +1, bcz we want to insert at the next index of current index

                if (rightSum >= prefixSum) { // rightSum >= prefixSum that means only one sub array is created yet
                    subArrayCount = 1;
                } else { // if rightSum < prefixSum that means multiple sub arrays can be created
                    subArrayCount = 2;
                }
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(minDiff);
        arrayList.add(minDiffIndex + 1);// bcz we want to insert at the next index
        arrayList.add(subArrayCount);
        return arrayList;
    }

    public static int[] minDiffSubarray(int[] arr) {
        // Initialize variables
        int minDiff = Integer.MAX_VALUE; // Variable to store minimum difference
        int minDiffIndex = -1; // Index where minimum difference occurs
        int subArray = 1; // Number of subarrays with minimum difference
        int totalSum = 0; // Total sum of elements in the array
        int prefix = 0; // Prefix sum

        // Calculate total sum of elements in the array
        for (int i = 0; i < arr.length; ++i) {
            totalSum += arr[i];
        }

        // Iterate through each element of the array
        for (int i = 0; i < arr.length; ++i) {
            prefix += arr[i]; // Update prefix sum with current element

            // Calculate sum of elements on the right side of the current element
            int rightSum = totalSum - prefix;

            // Calculate absolute difference between rightSum and prefix
            int diff = Math.abs(rightSum - prefix);

            // Update minDiff and minDiffIndex if current difference is smaller
            if (diff < minDiff) {
                minDiff = diff;
                minDiffIndex = i + 1;

                // Determine number of subarrays based on rightSum and prefix
                if (rightSum >= prefix) {
                    subArray = 1;
                } else {
                    subArray = 2;
                }
            }
        }

        // Return an array containing minDiff, minDiffIndex, and subArray
        return new int[]{minDiff, minDiffIndex + 1, subArray};
    }


}
