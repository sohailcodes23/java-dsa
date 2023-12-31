package searching.binarSearclAlgo;

public class DescSortedArrayBinarySearch {

    public static void main(String[] args) {
        int[] sortedArray = {98, 76, 54, 43, 33, 22, 11, 9, 8, 7, 3, 2, 1};
        System.out.println("ANS " + binarySearch(sortedArray, 3));
    }

    // this is only for sorted array
    static int binarySearch(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;

//
//        // My way of code
//        for (int i = start; start <= end; i++) {
//
//            // Actual logic is this, don't use this in scenoarios where the (start+end) value is greater than int Max value
////            int middleIndex = start + end / 2;
//
//            // Optimised way of getting mid, but add more loops
//            int middleIndex = start + (end - start) / 2;
//            int middleElement = array[middleIndex];
//            System.out.println("MIDDLE " + middleIndex + " " + middleElement);
//            if (middleElement > target) {
//                end = middleIndex - 1;
//            } else if (middleElement < target) {
//                start = middleIndex + 1;
//            } else {
//                return middleIndex;
//            }
//        }


        // Optimised way by Kunal, Note using while loop
        while (start <= end) {

            // Actual logic is this, don't use this in scenoarios where the (start+end) value is greater than int Max value
//            int middleIndex = start + end / 2;

            // Optimised way of getting mid
            int middleIndex = start + (end - start) / 2;
            int middleElement = array[middleIndex];
            System.out.println("MIDDLE " + middleIndex + " " + middleElement);
            if (middleElement < target) {
                end = middleIndex - 1;
            } else if (middleElement > target) {
                start = middleIndex + 1;
            } else {
                return middleIndex;
            }
        }

        return -1;
    }
}
