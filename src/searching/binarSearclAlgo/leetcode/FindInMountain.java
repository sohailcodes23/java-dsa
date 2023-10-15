package searching.binarSearclAlgo.leetcode;

//https://leetcode.com/problems/find-in-mountain-array/description/O
public class FindInMountain {
    public static void main(String[] args) {

//        int[] sortedArray = {1, 2, 3, 4, 5, 3, 1};
        int[] sortedArray = {0, 1, 2, 4, 2, 1};
        System.out.println("ANS " + findTheIndex(sortedArray, 3));
    }

    static int findTheIndex(int[] array, int target) {
        int peakNumber = peakIndexInMountainArray(array);
        int indexInFirstHalfOfArray = orderAgnosticArrayBinarySearch(array, target, 0, peakNumber);
        if (indexInFirstHalfOfArray != -1) {
            return indexInFirstHalfOfArray;
        }


        int indexInSecondHalfOfArray = orderAgnosticArrayBinarySearch(array, target, peakNumber + 1, array.length - 1);
        return indexInSecondHalfOfArray;
    }

    static int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middleIndex = start + (end - start) / 2;
            int middleElement = arr[middleIndex];
            // Note very imp
            int nextToMiddleElement = arr[middleIndex + 1];
            // Note check this before other conditions or else, it will go to continous loop of '(middleElement < nextToMiddleElement) {' condition
            if (start == end) {
                return start;
            } else if (middleElement < nextToMiddleElement) {
                start = middleIndex + 1;
            } else if (middleElement > nextToMiddleElement) {
                end = middleIndex;
            }
        }

        return -1;
    }

    // added start and end by parameters
    static int orderAgnosticArrayBinarySearch(int[] array, int target, int start, int end) {

        int ans = -1;
        // this means whole array has the same value
        if (array[start] == array[end]) {
            return -1;
        }
        boolean isAscOrder = array[start] < array[end];

        while (start <= end) {

            int middleIndex = start + (end - start) / 2;
            int middleElement = array[middleIndex];
            System.out.println("MIDDLE " + middleIndex + " " + middleElement);

            if (middleElement == target) {
                return middleIndex;
            }

            // if ASC array
            if (isAscOrder) {
                if (middleElement > target) {
                    end = middleIndex - 1;
                } else {
                    start = middleIndex + 1;
                }
            } else {
                // if DESC array
                if (middleElement < target) {
                    end = middleIndex - 1;
                } else {
                    start = middleIndex + 1;
                }
            }
        }

        return ans;
    }

}
