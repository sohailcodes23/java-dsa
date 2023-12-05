package practice.multidimentional_array;

public class SetMatrixZeros {

    public static void main(String[] args) {
        int input[][] = {
                {1, 2, 3},
                {1, 0, 3},
                {1, 2, 3}
        };

        // 000
        // 000
        // 003


        setZeros_Better(input);
    }

    public static void setZeros_Better(int matrix[][]) {

        int n = matrix.length;
        int m = matrix[0].length;

        int column[] = new int[matrix[0].length]; //to set m
        int rows[] = new int[matrix.length]; // to set n


        for (int i = 0; i < n; i++) {


            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {

                    rows[i] = -1; // marking and saving the row index
                    column[j] = -1; // marking and saving the column index
                }
            }

        }


        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < column.length; j++) {

                if (rows[i] == -1) {
                    matrix[i][j] = 0;
                }

                if (column[j] == -1) {
                    matrix[i][j] = 0;
                }

            }
        }


        printArray(matrix);
    }

    public static void setZeros_Brute(int matrix[][]) {

        int n = matrix.length;
        int m = matrix[0].length;

//        TC=> O(N^2)
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {
                    markRow(i, matrix);
                    markColumn(j, matrix);
                }
            }

        }

//        TC=> O(N^2)
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    static void markRow(int i, int[][] array) {

        //        TC=> O(N)
        for (int j = 0; j < array[0].length; j++) {

            if (array[i][j] != 0) {
                array[i][j] = -1;
            }

        }
    }

    static void markColumn(int j, int[][] array) {
//        TC=> O(N)
        for (int i = 0; i < array.length; i++) {

            if (array[i][j] != 0) {
                array[i][j] = -1;
            }
        }
    }


    static void printArray(int[][] mat) {
//        System.out.println("AFTER " + value);
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {

                System.out.print(" " + mat[i][j]);
            }
        }
        System.out.println();
    }


}
