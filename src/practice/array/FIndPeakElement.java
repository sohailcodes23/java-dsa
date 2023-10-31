package practice.array;

// GFG : https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
public class FIndPeakElement {
    public static void main(String[] args) {
//        int array[] = {1, 2, 3, 44, 4, 8, 5, 9, 4};
//        int array[] = {200, 10, 20, 15, 2, 23, 90, 67, 101};
        int array[] = {10, 20, 15, 2, 23, 90, 67, 101};
//        int array[] = { 10, 20, 15, 2, 23, 90, 67};


        System.out.println("ANS " + findIndexOfPeakElement(array));
        System.out.println("ANS " + findPeak(array, array.length));
        System.out.println("ANS " + findPeakElement(array));
    }

    // GFG
    static int findPeak(int arr[], int n) {
        // First or last element is peak element
        if (n == 1)
            return 0;
        if (arr[0] >= arr[1])
            return 0;
        if (arr[n - 1] >= arr[n - 2])
            return n - 1;
        // Check for every other element
        for (int i = 1; i < n - 1; i++) {
            // Check if the neighbors are smaller
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
                return i;
        }
        return 0;
    }

    // OWN
    // linear approach
    public static int findIndexOfPeakElement(int array[]) {
//        TC=> O(N)
//        SC=> O(1)
        int n = array.length;
        int peakElement = Integer.MIN_VALUE;
        int peakElementIndex = -1;

        for (int i = 1; i < n - 1; i++) {

            int previousElement = array[i - 1];
            int nextElement = array[i + 1];
            if (previousElement > peakElement && peakElement < array[i]) { // to check first element of the array
                peakElement = previousElement;
                peakElementIndex = i - 1;
            } else if (array[i] > previousElement && array[i] > nextElement && peakElement < array[i]) { // to check all elements of the array
                peakElement = array[i];
                peakElementIndex = i;
            } else if (nextElement > peakElement) { // to check last element of the array
                peakElement = nextElement;
                peakElementIndex = i + 1;
            }
        }

        return peakElementIndex;
    }

    //OWN
    public static int findPeakElement(int array[]) {
        int n = array.length;
        int peakElement = Integer.MIN_VALUE;

        for (int i = 1; i < n - 1; i++) {

            int previousElement = array[i - 1];
            int nextElement = array[i + 1];
            if (previousElement > peakElement && peakElement < array[i]) {
                peakElement = previousElement;
            } else if (array[i] > previousElement && array[i] > nextElement && peakElement < array[i]) {
                peakElement = array[i];
            } else if (nextElement > peakElement) {
                peakElement = nextElement;
            }
        }

        return peakElement;
    }

}
