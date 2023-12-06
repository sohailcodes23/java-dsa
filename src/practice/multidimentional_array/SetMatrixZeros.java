package practice.multidimentional_array;

public class SetMatrixZeros {

    public static void main(String[] args) {
//        int input[][] = {
//                {1, 2, 3},
//                {1, 0, 3},
//                {1, 2, 3}
//        };
        // 000
        // 000
        // 003
        int input[][] = {
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 1, 1},
        };
// 0 0 0 1
// 0 0 0 0
// 0 0 0 0
// 0 0 0 0

        setZeros_Optimal(input);
        printArray(input);
    }

    public static void setZeros_Optimal(int matrix[][]) {

//      final  TC=> O(2(N*M) + O(N)+ O(M))
//        SC=> O(1), bcz we only used col0, which is a just a variable(neglible)

        //int column[] = new int[matrix[0].length]; //to set m  matrix[..][0]
        //int rows[] = new int[matrix.length]; // to set n matrix[0][..]
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;

        // TC=> O(N*M)
        // mark the rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {

                    // row
                    if (j != 0) { // if not zero, bcz if one than we can directly mark it. But if it's zero than to keep the value save in col0
                        matrix[0][j] = 0;
                    } else { //But if it's zero than to keep the value save in col0
                        col0 = 0;
                    }

                    //column
                    matrix[i][0] = 0;

                }

            }
        }


        // TC=> O(N*M)
        //check the pending values and mark them
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
// we are checking are marked rows and columns
                if (matrix[i][0] == 0 || matrix[0][j] == 0) { // check the comment for reference

                    matrix[i][j] = 0;
                }
            }
        }

        // only pending are marked rows and column
        // we cannot first check the column, bcz it might impact the rows

        // TC=> O(M)
        if (matrix[0][0] == 0) {

            for (int j = 0; j < m; j++) {

                matrix[0][j] = 0;// even after saving the extra value in col),if the [0][0] is 0 that means the first row will be 0
            }
        }


        // TC=> O(N)
        if (col0 == 0) {

            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0; // so that only the first column value is updated bcz in extra col) the value is 0
            }
        }

    }

    public static void setZeros_Better(int matrix[][]) {

//        Final TC=> O(2(N*M))
//        SC=> O(N*M)
        int n = matrix.length;
        int m = matrix[0].length;

        int column[] = new int[matrix[0].length]; //to set m
        int rows[] = new int[matrix.length]; // to set n

//TC=> O(N*M)
        for (int i = 0; i < n; i++) {


            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {

                    rows[i] = -1; // marking and saving the row index
                    column[j] = -1; // marking and saving the column index
                }
            }

        }


//TC=> O(N*M)
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
