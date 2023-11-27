package practice.array;

import java.util.Arrays;

public class SecondLargestElement {

    public static void main(String[] args) {


//        int array[] = {-10, -40, -25, -12, -25, -10};
//        int array[] = {10, 25, -12, -6, 20, 20};
        int array[] = {1, 3, 2, 5, 4};

        System.out.println("ANS " + secondLargestElement(array));

    }

    static int secondLargestElement(int array[]) {

        //TC => O(NlogN)
        // SC =O(1)
        Arrays.sort(array); // TC => O(NlogN)
        System.out.println("SS " + Arrays.toString(array));
        int n = array.length;
        if (n == 1 || n == 0) {
            return -1;
        }


        for (int i = n - 2; i >= 0; i--) { // to check the duplicate value, if the highest value is duplicated than we need to check it

            if (array[i] != array[n - 1]) {
                return array[i];
            }
        }
        return -1;
    }


    // Without sort
    public static int findSecondLargest(int n, int[] arr) {

        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;

        // Find the largest element.
        for (int i = 0; i < n; i++) {
            largest = Math.max(largest, arr[i]);
        }

        for (int i = 0; i < n; i++) {

            // If the element is not equal to first largest element.
            if (arr[i] != largest) {
                secondLargest = Math.max(secondLargest, arr[i]);
            }
        }

        if (secondLargest != Integer.MIN_VALUE) {
            return secondLargest;
        } else {
            return -1;
        }
    }


}
