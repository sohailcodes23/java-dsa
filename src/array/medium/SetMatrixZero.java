package array.medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SetMatrixZero {

    public static void main(String[] args) {

        int array[][] = {
                {2, 4, 3},
                {1, 0, 0},
                {1, 1, 1},
        };
        setMatrixZero_Brute(array);

//        System.out.println("ANS " + Arrays.toString(array));
    }

    static void setMatrixZero_Brute(int array[][]) {

        for (int i = 0; i < array.length; i++) {

            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + array[i][j]);

                if (array[i][j] == 0) {
                    markRow(i, array);
                    markColumn(j, array);
                }
            }
        }

        for (int i = 0; i < array.length; i++) {

            System.out.println();
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == -1) {
                    array[i][j] = 0;
                }
                System.out.print(" " + array[i][j]);

            }
        }
    }

    static void markRow(int i, int[][] array) { // i bcz whole row which is to be updated
        for (int j = 0; j < array.length; j++) {
            if (array[i][j] != 0) {
                array[i][j] = -1;
            }
        }
    }

    static void markColumn(int j, int[][] array) { // j bcz whole column which is to be updated
        for (int i = 0; i < array.length; i++) {
            if (array[i][j] != 0) {
                array[i][j] = -1;
            }
        }
    }


}
