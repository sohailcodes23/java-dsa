package searching.binarSearclAlgo.leetcode;

//https://leetcode.com/problems/peak-index-in-a-mountain-array/
//https://leetcode.com/problems/find-peak-element/
//Bitonic Array = PeekIndexInMountain
//        PeekIndexInMountain= Largest number in the array // provided there wn't be dublicate values
public class OptimisedPeekIndexInMountain {

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 8, 4, 3, 2};
        System.out.println("ANS " + peakIndexInMountainArray(sortedArray));
    }


    //https://leetcode.com/problems/peak-index-in-a-mountain-array/
    // Own Code
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // you are in dec part of array
                // this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            } else {
                // you are in asc part of array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        // in the end, start == end and pointing to the largest number because of the 2 checks above
        // start and end are always trying to find max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        // more elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible ans
        return start; // or return end as both are =
    }

    //https://leetcode.com/problems/find-peak-element/
    static int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middleIndex = start + (end - start) / 2;
            int middleElement = nums[middleIndex];
            // Note very imp
            int nextToMiddleElement = 0;
            // adding this check to handle ArrayOutOfBoundException
            if ((middleIndex + 1) >= nums.length) {
                nextToMiddleElement = nums[middleIndex];
            } else {
                nextToMiddleElement = nums[middleIndex + 1];
            }
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
}
