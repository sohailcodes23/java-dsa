package searching.binarSearclAlgo.leetcode;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindRotationCountInRotatedSortedArray {

    public static void main(String[] args) {
//        int[] sortedArray = {3, 4, 5, 6, 7, 0, 1, 2};
        int[] sortedArray = {7, 0, 1, 2};
        System.out.println("ANS " + searchInRotatedUniqueSortedArray(sortedArray));
    }


    // Own Code
    // Just follow sorted property of Binary Search
    static int searchInRotatedUniqueSortedArray(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int minimumNumber = Integer.MAX_VALUE;
        int noOfRotation = -1;
        while (start <= end) {
            int middleIndex = start + (end - start) / 2;
            int middleElement = nums[middleIndex];
            int startElement = nums[start];
            int endElement = nums[end];

            // Optimised logic
            if (startElement <= endElement) {
                if (startElement < minimumNumber) {
                    minimumNumber = startElement;
                    noOfRotation = start;
                }
                break;
            }

            if (startElement <= middleElement) { // Right
                if (startElement < minimumNumber) {
                    minimumNumber = startElement;
                    noOfRotation = start;
                }
                start = middleIndex + 1;
            } else { // left
                if (middleElement < minimumNumber) {
                    minimumNumber = middleElement;
                    noOfRotation = middleIndex;
                }
                end = middleIndex - 1; // NOTE eliminate the right half
            }
        }

        return noOfRotation;
    }
}
