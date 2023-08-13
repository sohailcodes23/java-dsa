package searching.linearSeachAlgo;

import java.util.Arrays;

public class FindIn2DArray {

    public static void main(String[] args) {
        int[][] sourceArray = {
                {1, 342, 6, 677},
                {1, 3, 5, 7, 4},
                {876, 4}
        };
        // Note to print the array we are using  Arrays.toString
        System.out.println("ANS " + Arrays.toString(searchIn2DArray(sourceArray, 876)));
    }

    static int[] searchIn2DArray(int[][] sourceArray, int target) {

        for (int row = 0; row < sourceArray.length; row++) {
            // Nested Array to get the columns
            for (int column = 0; column < sourceArray[row].length; column++) {

                if (target == sourceArray[row][column]) {
                    // Note the way int[] is returned
                    return new int[]{row, column};
                }
            }

        }


        return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
    }


}
