package searching.binarSearclAlgo.leetcode;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
//Bitonic Array = PeekIndexInMountain
//        PeekIndexInMountain= Largest number in the array // provided there wn't be dublicate values
public class PeekIndexInMountain {

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 4, 3, 2};
        System.out.println("ANS " + peakIndexInMountainArray(sortedArray));
    }

    // Own Code
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
            }else if (middleElement < nextToMiddleElement) {
                start = middleIndex + 1;
            } else if (middleElement > nextToMiddleElement) {
                end = middleIndex;
            }
        }

        return -1;
    }
}
