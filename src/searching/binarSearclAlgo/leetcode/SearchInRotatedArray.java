package searching.binarSearclAlgo.leetcode;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
//https://leetcode.com/problems/find-peak-element/
//Bitonic Array = PeekIndexInMountain
//        PeekIndexInMountain= Largest number in the array // provided there wn't be dublicate values
public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] sortedArray = {3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println("ANS " + searchInRotatedUniqueArray(sortedArray, 4));
    }


    // Own Code
    // Just follow sorted property of Binary Search
    static int searchInRotatedUniqueArray(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middleIndex = start + (end - start) / 2;
            int middleElement = arr[middleIndex];
            int startElement = arr[start];
            int endElement = arr[end];
            if (middleElement == target) {
                return middleIndex;
            } else if (startElement <= middleElement) { // if this is true than target is on left side of middle
                System.out.println("LEFT");
                if (startElement <= target && target <= middleElement) {
                    end = middleIndex - 1;
                } else {
                    start = middleIndex + 1;
                }
            } else {
                System.out.println("RR");
                if (endElement >= target && middleElement <= target) {  // if this is true than target is on right side of middle
                    start = middleIndex + 1;
                } else {
                    end = middleIndex - 1;
                }
            }

        }

        return -1;
    }
}
