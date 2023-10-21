package util;

public class CommonUtility {

    public static int sumOfNNaturalNumbers(int N) {
        return (N * (N + 1)) / 2;
    }

    public static int sumOfArrayValues(int[] array) {
        int sum = 0;
        for (int j = 0; j < array.length; j++) {
            sum = sum + array[j];
        }
        return sum;
    }

    public static void swapBasedOnIndex(int j, int i, int[] array) {
        int tempValue = array[j]; // IMP store the value not the index
        array[j] = array[i];
        array[i] = tempValue;
    }

    public static void reverseArray(int arr[], int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}
