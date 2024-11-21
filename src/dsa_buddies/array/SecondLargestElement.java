package dsa_buddies.array;

public class SecondLargestElement {

    public static void main(String[] args) {
        int arr[] = {12, 35, 1, 10, 34, 1};
//        int arr[] = {10, 10, 9};

        System.out.println(getSecondLargest(arr));
        System.out.println(getSecondLargest_Better(arr));

    }

    public static int getSecondLargest(int[] arr) {
//        TC == > O(N)
        int n = arr.length;

        if (arr.length < 2) {
            return -1;
        }

        int max = 0;
        int secondMax = 0;

        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                secondMax = max;
                max = arr[i];
            } else if (secondMax < arr[i] && arr[i] != max) {
                secondMax = arr[i];
            }
        }

        if (max == secondMax || secondMax == 0) {
            return -1;
        }

        return secondMax;
    }

    public static int getSecondLargest_Better(int[] arr) {

//        TC=> O(2N)
        int max = 0;
        int secondMax = -1;

        // Find the maximum value
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        // Find the second maximum value
        for (int i = 0; i < arr.length; i++) {
            if (secondMax < arr[i] && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }


}
