package array.easy;

import java.util.Arrays;

public class Common {

    public static void main(String[] args) {
        int a[] = {2, 5, 8, 1, 4, 6};
//        int a[] = {2, 5, 8,8,1, 1, 4, 6};

        System.out.println("ANS " + Arrays.toString(getSecondOrderElements(a.length, a)));
    }

    public static int[] getSecondOrderElements(int n, int[] a) {
// FOr finding 2nd Largest, if we add 2nd smallest the TS will be more
        // #Brute : 1. Sort the array.
        //          2. Since the array is sort we know the last element (n-1) is the largest element, we can run the array from (n-2) and check if the value is larger than a(n-1), if it's same value than ignore the update.
        //          3. Here TS => N Log N (For sorting) and N (For loop)
        //          4. Final TS=> O(NLogN + N)
        // #Better :1. Run the loop and compare each element and get largest.
        //          2. Run the loop and compare each element and get sLargest and it shpuld be less than largest.
        //          3. Here TS => N (For first loop) and N (For 2nd loop)
        //          3. Final TS => O(N + N) = O(2N)

//        #Optimal Solution
        int sLargestElement = secondLargest(a); // TS => O(N), single pass of of data and single loop
        int sSmallestElement = secondSmallest(a); // TS => O(N)

        return new int[]{sLargestElement, sSmallestElement};
    }

    private static int secondSmallest(int[] a) {
        int smallest = a[0];
        int sSmallest = Integer.MAX_VALUE;

        for (int value : a) {
            if (value < smallest) {
                sSmallest = smallest;
                smallest = value;
            } else if (value > smallest && value < sSmallest) { // if the value is same like smallest = 7 and next value is 7 it will skip it. If next value is 5 than we have to update the sSmallest
                sSmallest = value;
            }
        }

        return sSmallest;
    }

    private static int secondLargest(int[] a) {
        int largest = a[0];
        int slargest = Integer.MIN_VALUE;

        for (int value : a) {
            if (value > largest) {
                slargest = largest;
                largest = value;
            } else if (value < largest && value > slargest) { // if the value is same like largest = 7 and next value is 7 it will skip it. If next value is 5 than we have to update the slargest
                slargest = value;
            }
        }

        return slargest;
    }

    static int largestElement(int[] arr, int n) {
        // Write your code here.
        int largest = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    static void swapBasedOnIndex(int minimumValueIndex, int i, int[] array) {
        int tempValue = array[minimumValueIndex]; // IMP store the value not the index
        array[minimumValueIndex] = array[i];
        array[i] = tempValue;
    }
}
