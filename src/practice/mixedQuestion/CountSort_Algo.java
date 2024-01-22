package practice.mixedQuestion;

import java.util.Arrays;

public class CountSort_Algo {

    public static void main(String[] args) {

//        int[] array = {3, 4, 1, 3, 2, 5, 2, 8};
        int[] array = {-2, 1, 2, -1, 0, 0};

//        sort(array.length, array);

//        System.out.println("AND " + Arrays.toString(sortv2(array.length, array)));
        System.out.println("AND " + Arrays.toString(sort(array.length, array)));
    }

    public static int[] sort(int n, int arr[]) {
        // Write your code here.
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }else if (arr[i] < min) {
                min = arr[i];
            }
        }

        int[] tempArray = new int[max - min + 1]; // to adjust the length we need max - min and min can be a -ve number. + 1 - to store tha values based on normal counting like 1,2,3
        for (int i = 0; i < n; i++) {
            tempArray[arr[i] - min]++; // a[i], very IMP bcz we want to save the count of that value and (arr[i] - min) to make the -ve as positive
        }

        int currentIndex = 0;
        for (int i = 0; i < tempArray.length; i++) {

            while (tempArray[i] > 0) {
                arr[currentIndex] = i + min;// i+min : to get the original values
                currentIndex++;
                tempArray[i] = tempArray[i] - 1;// required bcz we want the time loop to run for the value time, so if at index 2 there is 3 value, the loop should run 3 time, so we decrement
            }
        }

        return arr;
    }

    public static int[] sortv2(int n, int arr[]) {
        // Find the minimum and maximum elements in the array
        int min = arr[0], max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Adjust indices based on the minimum value
        int[] tempArray = new int[max - min + 1];
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                System.out.println(arr[i] + "__" + (arr[i] - min) + " " + min);
            }
            tempArray[arr[i] - min]++;
        }

        // Reconstruct the sorted array
        int currentIndex = 0;
        for (int i = 0; i < tempArray.length; i++) {
            System.out.println(i + " " + tempArray[i]);
            while (tempArray[i] > 0) {
                arr[currentIndex] = i + min; // Adjust back to the original value
                currentIndex++;
                tempArray[i]--;
            }
        }

        return arr;
    }

}
