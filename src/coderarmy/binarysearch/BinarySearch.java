package coderarmy.binarysearch;

public class BinarySearch {


    public static void main(String[] args) {

//        int array[] = {30, 28, 20, 16, 4};
        int array[] = {1, 3, 5, 6};
        System.out.println("ANS " + searchInsert(array, 5));
    }


    // ASC sorted array
    public int search(int[] nums, int target) {

        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int middle = 0;
        while (start <= end) {
            // to handle integer overflow
            middle = start + (end - start) / 2;// you can also write, middle = end + (start- end)/2 : but in some case this will throw error, so use optimal one
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else { // if middle > target
                end = middle - 1;
            }

        }

        return -1;

    }


    // DESC sorted array
    public static int searchv2(int[] nums, int target) {

        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int middle = 0;
        while (start <= end) {
            // to handle integer overflow
            middle = start + (end - start) / 2;// you can also write, middle = end + (start- end)/2 : but in some case this will throw error, so use optimal one
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                end = middle - 1;

            } else { // if middle > target
                start = middle + 1;
            }

        }

        return -1;

    }

    // if found return index else index of where should be the target
    public static int searchInsert(int[] nums, int target) {

        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int middle = 0;
        while (start <= end) {
            // to handle integer overflow
            middle = start + (end - start) / 2;// you can also write, middle = end + (start- end)/2 : but in some case this will throw error, so use optimal one
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else { // if middle > target
                end = middle - 1;
            }

        }

        return start;// bcz if the target element is not present than start is the index where it should have be
    }
}
