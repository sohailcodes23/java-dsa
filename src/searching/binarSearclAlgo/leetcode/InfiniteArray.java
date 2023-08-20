package searching.binarSearclAlgo.leetcode;

// GFG
//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public class InfiniteArray {

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 7, 9, 32, 45, 65, 87, 98};
        System.out.println("ANS " + findAns(sortedArray, 32));
    }

    static int findAns(int[] array, int target) {
        // first find the range
        // first start with a box of size 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range
        while (target > array[end]) {
            int temporaryStart = end + 1;
            // get the size of array to double it later
            // Note adding +1, bcz index starts from 0. So the calculation should be correct so add +1
            int sizeOfArray = end - start + 1;
            // newEnd = end+ (end-start) * 2
            // Optimised newEnd = end+ (sizeOfArray * 2)
            end = end + (sizeOfArray * 2);

            start = temporaryStart;

            // Note add this pr ArrayOutOfBoundException eill be thrown
            if (end >= array.length - 1) {
                end = array.length - 1;
                break;
            }

        }
        return binarySearch(array, target, start, end);
    }

    static int binarySearch(int[] array, int target, int start, int end) {

        while (start <= end) {

            // Optimised way of getting mid
            int middleIndex = start + (end - start) / 2;
            int middleElement = array[middleIndex];
            if (middleElement > target) {
                end = middleIndex - 1;
            } else if (middleElement < target) {
                start = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }
}
