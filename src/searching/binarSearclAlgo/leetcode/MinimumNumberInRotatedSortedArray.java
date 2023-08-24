package searching.binarSearclAlgo.leetcode;


//S
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinimumNumberInRotatedSortedArray {

    public static void main(String[] args) {
        int[] sortedArray = {3, 4, 5, 6, 7, -1, -2, -3, 0, 1, 2};
        System.out.println("ANS " + searchInRotatedUniqueSortedArray(sortedArray));
    }


    // Own Code
    // Just follow sorted property of Binary Search
    static int searchInRotatedUniqueSortedArray(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while (start <= end) {
            int middleIndex = start + (end - start) / 2;
            int middleElement = nums[middleIndex];
            int startElement = nums[start];
            int endElement = nums[end];

            // Optimised logic
            if (startElement <= endElement) {
                if (startElement < ans) {
                    ans = startElement;
                }
                break;
            }

            if (startElement <= middleElement) { // Right
                if (startElement < ans) {
                    ans = startElement;
                }
                start = middleIndex + 1;
            } else { // left
                if (middleElement < ans) {
                    ans = middleElement;
                }
                end = middleIndex - 1; // NOTE eliminate the right half
            }

        }

        return ans;
    }
}
