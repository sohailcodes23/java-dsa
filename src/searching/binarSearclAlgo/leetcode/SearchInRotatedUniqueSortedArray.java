package searching.binarSearclAlgo.leetcode;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedUniqueSortedArray {

    public static void main(String[] args) {
        int[] sortedArray = {3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println("ANS " + searchInRotatedUniqueSortedArray(sortedArray, 4));
    }


    // Own Code
    // Just follow sorted property of Binary Search
    static int searchInRotatedUniqueSortedArray(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middleIndex = start + (end - start) / 2;
            int middleElement = nums[middleIndex];
            int startElement = nums[start];
            int endElement = nums[end];
            if (middleElement == target) {
                return middleIndex;
            }

            if (startElement <= middleElement) { // if this is true than target is on left side of middle
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
