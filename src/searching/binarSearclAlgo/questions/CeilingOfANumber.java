package searching.binarSearclAlgo.questions;

public class CeilingOfANumber {
    // Ceiling means the nearest greater number to the target or the target itself
    // int[] arr={1, 2, 3, 4, 5, 7, 9, 32, 45, 65, 87, 98};
    // here if target is 32, than the ceiling is 32
    // here if target is 6, than the ceiling is 7


    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 7, 9, 32, 45, 65, 87, 98};
        System.out.println("ANS " + binarySearch(sortedArray, 86));
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

        int ceilingIndex = middleIndex + 1;
        if (ceilingIndex >= array.length) {
            return -1;
        }
        return array[ceilingIndex];
    }
}
