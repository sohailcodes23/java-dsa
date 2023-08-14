package searching.binarSearclAlgo;

// when sorted order is not known
public class OrderAgnosticArrayBinarySearch {

    public static void main(String[] args) {
        // asc array
//        int[] sortedArray = {1, 2, 3, 4, 5, 7, 9, 32, 33, 45, 65, 87, 98};

        // desc array
        int[] sortedArray = {98, 76, 54, 43, 33, 22, 11, 9, 8, 7, 3, 2, 1};

        // same value array
//        int[] sortedArray = {3,3,3,3,3,3,3,3};
        System.out.println("ANS " + getTheIndexOfElement(sortedArray, 3));
    }

    static int getTheIndexOfElement(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        int ans = -1;
        // this means whole array has the same value
        if (array[start] == array[end]) {
            return -1;
        } else if (array[start] < array[end]) {
            ans = ascBinarySearch(array, target);
        } else {
            ans = descBinarySearch(array, target);
        }

        return ans;
    }

    // this is only for sorted array
    static int ascBinarySearch(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {

            // Actual logic is this, don't use this in scenoarios where the (start+end) value is greater than int Max value
//            int middleIndex = start + end / 2;

            // Optimised way of getting mid
            int middleIndex = start + (end - start) / 2;
            int middleElement = array[middleIndex];
            System.out.println("MIDDLE " + middleIndex + " " + middleElement);
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

    static int descBinarySearch(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;
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
