package searching.binarSearclAlgo.leetcode;

public class FirstAndLastPositionOfElement {
    public static void main(String[] args) {

        int[] sortedArray = {1, 2, 3, 4, 5, 7, 9, 32, 45, 65, 87, 98};
        System.out.println("ANS " + binarySearch(sortedArray, 9));
    }


    static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        if (target > array[end]) {
            return -1;
        }

        while (start <= end) {

            int middleIndex = start + (end - start) / 2;
// Not don't forget this
            int middleElement = array[middleIndex];
            if (target > middleElement) {
                start = middleIndex + 1;
            } else if (target < middleElement) {
                end = middleIndex - 1;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }
}
