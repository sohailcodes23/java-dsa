package coderarmy.binarysearch;

public class PeakElementInMountainArray {

    public static void main(String[] args) {

        int array[] = {18, 29, 38, 59, 98, 100, 99, 98, 90};
//        int array[] = {2,1};
        System.out.println("ANS "+peakIndexInMountainArray(array));
    }

    public static int peakIndexInMountainArray(int[] arr) {

        // TC=> O(log N)
        // SC=> O(1)
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = end + (start - end) / 2;// special case to use this formula to get mid to solve peak
            if (arr[mid] > arr[mid - 1]
                    && arr[mid] > arr[mid + 1]) {// both the conditions should be true bcz peak is the largest value in the array, so both the sides from the peak should be smaller than peak value
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {// if the left element is smaller than mid, than the peak is at the right side, bcz the array is ASC sorted till peak
                start = mid + 1;
            } else { // if the right element is smaller than mid, than the peak is at the left side, bcz the array is DESC sorted till the peak
                end = mid - 1;
            }
        }

        return -1;
    }
}
