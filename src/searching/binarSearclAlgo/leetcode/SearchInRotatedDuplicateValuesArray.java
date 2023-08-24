package searching.binarSearclAlgo.leetcode;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchInRotatedDuplicateValuesArray {

    public static void main(String[] args) {
        int[] sortedArray = {2, 2, 2, 2, 2, 2, 5, 6, 0, 0, 1, 2};
        System.out.println("ANS " + searchInRotatedUniqueSortedArray(sortedArray, 0));
    }


    // Own Code
    // Just follow sorted property of Binary Search
    static boolean searchInRotatedUniqueSortedArray(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middleIndex = start + (end - start) / 2;
            int middleElement = nums[middleIndex];
            int startElement = nums[start];
            int endElement = nums[end];
            if (middleElement == target) {
                return true;
            } else if (middleElement == startElement && middleElement == endElement) {
                start++; // start = start +1
                end--; // end = end-1
                continue; // continue, so the array is shrinked
            }

            if (startElement <= middleElement) { // if this is true than target is on left side of middle
                if (startElement <= target && target <= middleElement) {
                    end = middleIndex - 1;
                } else {
                    start = middleIndex + 1;
                }
            } else {
                if (endElement >= target && middleElement <= target) {  // if this is true than target is on right side of middle
                    start = middleIndex + 1;
                } else {
                    end = middleIndex - 1;
                }
            }

        }

        return false;
    }
}
