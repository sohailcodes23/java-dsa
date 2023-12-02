package practice.multidimentional_array;

public class MatrixIsSymmetric {

    public static void main(String[] args) {

        int[][] array = {
                {1, 2, 3},
                {2, 4, 5},
                {3, 5, 8}
        };

        System.out.println("ANS " + isMatrixSymmetric(array));
    }

    // Better / Optimal
    public static boolean isMatrixSymmetric(int[][] matrix) {
        // TC=> O(N)
        int n = matrix.length;
//        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) { // since we are checking the i+1 and only running the j till n, that means the first half triangle

                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isMatrixSymmetric_Brute(int[][] matrix) {
        // TC=> O(N^2)
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }
}
