package searching.binarSearclAlgo.questions;

public class FloorOfANumber {
    // Floor is opposite of ceiling
    // Floor means the nearest smallest number to the target or the target itself
    // int[] arr={1, 2, 3, 4, 7, 9, 32, 45, 65, 87, 98};
    // here if target is 32, than the floor is 32
    // here if target is 6, than the floor is 4


    public static void main(String[] args) {

        int[] sortedArray = {1, 2, 3, 4, 5, 7, 9, 32, 45, 65, 86, 87, 98};
//        int[] sortedArray = {1, 2, 3, 4, 5, 7,8, 9,10, 32, 45, 65, 86, 87,90,92,94, 98};
        System.out.println("ANS " + binarySearch(sortedArray, 6));
    }

    /// OWN CODE
    static int binarySearch(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;
        int middleIndex = 0;
        while (start <= end) {

            middleIndex = start + (end - start) / 2;
            int middleElement = array[middleIndex];

            if (middleElement > target) {
                end = middleIndex - 1;
            } else if (middleElement < target) {
                start = middleIndex + 1;
            } else {
                return array[middleIndex];
            }
        }

        // since the start is greater than the end, the while loop is broken, and start= end + 1
        // when next big number is not found, the floor is = end

// here we are returning the end index element, bcz this covers the edge case if there are multiple numbers smaller than target and the middle is before a smaller number
//        int[] sortedArray = {1, 2, 3, 4, 5, 7, 9, 32, 45, 65,86, 87, 98};
//        By returning 'end' index it gives proper floor and covers the edge case as well
        return array[end];
    }
}
