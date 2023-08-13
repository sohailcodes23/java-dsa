package linearSeach;

import java.util.Arrays;

public class FindMaxAndMinIn2DArray {

    public static void main(String[] args) {
        int[][] sourceArray = {
                {1, 342, 6, 677},
                {1, 3, 5, 7, 4},
                {876, 4, -9987}
        };
        // Note to print the array we are using  Arrays.toString
        System.out.println("MIN ANS " + searchMinIn2DArray(sourceArray));
        System.out.println("MAX ANS " + searchMaxIn2DArray(sourceArray));
    }

    static int searchMaxIn2DArray(int[][] sourceArray) {
        // max can be the first element of the array as well
        int max = Integer.MIN_VALUE;
        for (int[] rowArrays : sourceArray) {
            // Nested Array to get the columns
            for (int rowValue : rowArrays) {

                if (rowValue > max) {
                    // Note the way int[] is returned
                    max = rowValue;
                }
            }

        }


        return max;
    }


    static int searchMinIn2DArray(int[][] sourceArray) {
        // min can be the first element of the array as well
        int min = Integer.MAX_VALUE;
        for (int[] rowArrays : sourceArray) {
            // Nested Array to get the columns
            for (int rowValue : rowArrays) {

                if (rowValue < min) {
                    // Note the way int[] is returned
                    min = rowValue;
                }
            }

        }


        return min;
    }

}
