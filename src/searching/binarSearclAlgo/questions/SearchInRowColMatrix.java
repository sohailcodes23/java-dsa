package searching.binarSearclAlgo.questions;

import java.util.Arrays;

public class SearchInRowColMatrix {

    public static void main(String[] args) {
        int[][] array = {
                {10, 20, 30, 40, 51},
                {15, 25, 35, 45, 55},
                {28, 29, 37, 49, 59},
                {33, 34, 38, 50, 60}
        };

        System.out.println("ANS " + Arrays.toString(search2(array, 37)));
    }

    // Own code
    static int[] search2(int[][] array, int target) {
        int[] ans = {-1, -1};
        int row = 0;
        int column = array.length - 1;
        while (row < array.length && column >= 0) {

            if (array[row][column] == target) {
                return new int[]{row, column};
            }

            // we are checking from the last element of the row.
            // so if the last element of the row is greater that mean the whole column is greater than target
            // if the last element of the row is smaller
            if (array[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }

        return ans;
    }


    // Optimised
    static int[] search(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length - 1;

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[]{r, c};
            }
            if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new int[]{-1, -1};
    }

    // OWN CODE : Brute force
    public static int[] search1(int[][] array, int target) {

        int[] ans = {-1, -1};
        int ansCount = 0;

        for (int row = 0; row < array.length; row++) {
            int potentialAnsColumn = 0;
            for (int column = 0; column < array[potentialAnsColumn].length; column++) {
                if (array[row][column] == target) {
                    ans = new int[]{row, column};

                    return ans;
                }

                if (array[row][column] > target) {
                    potentialAnsColumn = column - 1;
                }
            }
        }
        return ans;
    }
}
