package practice.multidimentional_array;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralArray_SpiralOrder {

    public static void main(String[] args) {
//        int array[][] = {
//                {1, 2, 3, 4},
//                {14, 15, 16, 5},
//                {13, 20, 17, 6},
//                {12, 19, 18, 7},
//                {11, 10, 9, 8}
//        };

//        int array[][] = {
//
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9},
//                {10, 11, 12},
//
//        };

        int array[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

//        spiralPrint(array);
        List<Integer> integers = spiralOrder(array);
        System.out.println("ANS " + integers);
    }


    // working : cleared 4/5 test cases
    // codestudio
    public static void spiralPrint(int matrix[][]) {


        int n = matrix.length;
        int m = 0;
        if (n > 0) {
            m = matrix[0].length;
        }
        int top = 0, left = 0;
        int right = m - 1, bottom = n - 1;

        while (top <= bottom && left <= right) {
            // left to right
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            // right to bottom
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;
            // bottom right to left

            if (top <= bottom) { // bcz we have already incremented the top, so we need to check it
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }

            // bottom to top
            if (left <= right) {  // bcz we have already decremented the left, so we need to check it
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }

        }
    }

    //leetcode
    public static List<Integer> spiralOrder(int[][] matrix) {

//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        int m = 0;
        if (n > 0) {
            m = matrix[0].length;
        }
        int top = 0, left = 0;
        int right = m - 1, bottom = n - 1;

        while (top <= bottom && left <= right) {
            // left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            // right to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            // bottom right to left
            if (top <= bottom) { // bcz we have already incremented the top, so we need to check it
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }


            // bottom left to top
            if (left <= right) {  // bcz we have already decremented the left, so we need to check it
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }

        }

        return result;
    }
}
