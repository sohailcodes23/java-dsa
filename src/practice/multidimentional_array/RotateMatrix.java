package practice.multidimentional_array;

// Inplace rotate matrix 90 degree
public class RotateMatrix {

    public static void main(String[] args) {


//        int[][] matrix = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        inplace_LeftRotate_Optimal(matrix, matrix.length);
//        inplaceRotateLeft(matrix, matrix.length);
//        rotateMatrix_leftRotate_Brute(matrix);
//        System.out.println("ANS " + Arrays.toString());
    }


    public static void inplace_LeftRotate_Optimal(int[][] mat, int n) {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}

//        TC=> O(N^2)
//        SC=> O(1)

        // always remember, you want to take each element and move ant-clockwise
        for (int i = 0; i < n / 2; i++) {

            for (int j = i; j < n - i - 1; j++) { // n-1-1 // n-2 till second last
                int iElementInJ = (n - 1 - i);
                // Save top-left
                int temp = mat[i][j]; // take the element
                // Move values from right to top
                mat[i][j] = mat[j][iElementInJ]; //the next element according to the anti-clockwise

                // Move values from bottom to right
                mat[j][iElementInJ] = mat[(n - 1 - i)][(n - 1 - j)];  // the previous element which was saved, now update that with the element according to ant-clockwise
                // Move values from left to bottom
                mat[(n - 1 - i)][(n - 1 - j)] = mat[(n - 1 - j)][i];  // the previous element which was saved, now update that with the element according to ant-clockwise

                // Move saved top-left to left
                mat[(n - 1 - j)][i] = temp; // save the temp
            }
        }

    }

    static void rotate_Right_Optimal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }


    // Referenced from this
    public static void inplaceRotateLeft_S(int[][] mat, int n) {
        for (int i = 0; i < n / 2; i++) {

            for (int j = i; j < n - i - 1; j++) {
                // Save top-left
                int temp = mat[i][j];
                System.out.println(i + " TEMP " + temp);

                // Move values from right to top
                System.out.println("FROM i :" + j + " j: " + (n - i - 1) + " ELEMENT " + mat[j][n - i - 1] + " REPLACED WITH " + mat[i][j]);
                mat[i][j] = mat[j][n - i - 1];
                printArray("", mat);
                // Move values from bottom to right

                System.out.println("FROM i :" + (n - i - 1) + " j: " + (n - j - 1) + " ELEMENT " + mat[n - i - 1][n - j - 1] + " REPLACED WITH " + mat[j][n - i - 1]);
                mat[j][n - i - 1] = mat[n - i - 1][n - j - 1];
                printArray("", mat);
                // Move values from left to bottom
                System.out.println("FROM i :" + (n - j - 1) + " j: " + i + " ELEMENT " + mat[n - j - 1][i] + " REPLACED WITH " + mat[n - i - 1][n - j - 1]);
                mat[n - i - 1][n - j - 1] = mat[n - j - 1][i];
                printArray("", mat);
                // Move saved top-left to left
                System.out.println("FROM i :" + i + " j: " + j + " ELEMENT " + temp + " REPLACED WITH " + mat[n - j - 1][i]);
                mat[n - j - 1][i] = temp;
                printArray("", mat);
            }
            System.out.println();
//            System.out.println("ARRAY after swap " + i + " : " + Arrays.toString(mat[i]));
//            printArray("", mat);
        }

        for (int i = 0; i < n; i++) {

            System.out.println();
            for (int j = 0; j < n; j++) {

                System.out.print(" " + mat[i][j]);
            }
        }
    }


    static void printArray(String value, int[][] mat) {
        System.out.println("AFTER " + value);
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {

                System.out.print(" " + mat[i][j]);
            }
        }
        System.out.println();
    }


    public static void rotateMatrix_rightRotate_Brute(int[][] mat) {
        int n = mat.length;

//        TC=> O(N^2)
//        SC=> O(N^2)
        int ans[][] = new int[n][n];

        for (int i = 0; i < n; i++) {


            for (int j = 0; j < n; j++) {
                // j will be constant, only i will change
                ans[j][n - 1 - i] = mat[i][j]; // n-1-i, to get the constant column

            }
        }

        // to update the original array
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                mat[i][j] = ans[i][j];
            }
        }

    }


    public static void rotateMatrix_leftRotate_Brute(int[][] mat) {
        int n = mat.length;

        int ans[][] = new int[n][n];

        for (int i = 0; i < n; i++) {

            int newI = n - 1;
            for (int j = 0; j < n; j++) {
                ans[newI][i] = mat[i][j]; // newI is used to update the i postion
                newI--;                   // IMP
            }
        }

        // to update the original array
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                mat[i][j] = ans[i][j];
            }
        }

        printArray("", mat);
    }
}
