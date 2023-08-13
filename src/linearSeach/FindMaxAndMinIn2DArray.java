package linearSeach;

import java.util.Arrays;

public class FindMaxAndMinIn2DArray {

    public static void main(String[] args) {
        int[][] sourceArray = {
                {1, 342, 6, 677},
                {1, 3, 5, 7, 4},
                {876, 4,-9987}
        };
        // Note to print the array we are using  Arrays.toString
        System.out.println("MIN ANS " + searchMinIn2DArray(sourceArray));
        System.out.println("MAX ANS " + searchMaxIn2DArray(sourceArray));
    }

    static int searchMaxIn2DArray(int[][] sourceArray) {
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < sourceArray.length; row++) {
            // Nested Array to get the columns
            for (int column = 0; column < sourceArray[row].length; column++) {

                if (sourceArray[row][column] > max) {
                    // Note the way int[] is returned
                    max = sourceArray[row][column];
                }
            }

        }


        return max;
    }


    static int searchMinIn2DArray(int[][] sourceArray) {
        int max = Integer.MAX_VALUE;
        for (int row = 0; row < sourceArray.length; row++) {
            // Nested Array to get the columns
            for (int column = 0; column < sourceArray[row].length; column++) {

                if (sourceArray[row][column] < max) {
                    // Note the way int[] is returned
                    max = sourceArray[row][column];
                }
            }

        }


        return max;
    }

}
