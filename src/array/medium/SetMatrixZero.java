package array.medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZero {

    public static void main(String[] args) {

//        int array[][] = {
//                {2, 4, 3, 5},
//                {1, 0, 0, 6},
//                {1, 1, 1, 0},
//        };

        int array[][] = {
                {1, 1, 1},
                {1, 0, 0},
                {1, 1, 1},
        };

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        int n = matrix.size();
        int m = matrix.get(0).size();
        zeroMatrix_Better(matrix, n, m);


//        System.out.println("ANS " + Arrays.toString(array));
    }



    // Optimal : need to recheck, didn't understood properly

    // leetcode
    public static ArrayList<ArrayList<Integer>> zeroMatrix_Better(ArrayList<ArrayList<Integer>> matrix, Integer n, Integer m) {
        // Write your code here.

//        Final TC=> O(2 * n * m)
//        SC=> O(n) + O(m)
        int column[] = new int[m]; //to set m
        int rows[] = new int[n]; // to set n

//        TC=> n * m
        for (int i = 0; i < matrix.size(); i++) {

            for (int j = 0; j < matrix.get(i).size(); j++) {

                if (matrix.get(i).get(j) == 0) {
                    rows[i] = -1;
                    column[j] = -1;
                }
            }
        }
//   TC=> n*m
        for (int i = 0; i < matrix.size(); i++) {
            System.out.println();
            for (int j = 0; j < matrix.get(i).size(); j++) {

                if (rows[i] == -1) {

                    matrix.get(i).set(j, 0);
                }


                if (column[j] == -1) {

                    matrix.get(i).set(j, 0);
                }

            }
        }

        return matrix;
    }


    // code studio
    static void setMatrixZero_Better(int array[][]) {

        int column[] = new int[array[0].length]; //to set m
        int rows[] = new int[array.length]; // to set n

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {

                if (array[i][j] == 0) {
                    System.out.println(i + " II " + j);
                    rows[i] = -1;
                    column[j] = -1;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array[i].length; j++) {

                if (rows[i] == -1) {

                    array[i][j] = 0;
                }


                if (column[j] == -1) {

                    array[i][j] = 0;
                }

                System.out.print(" " + array[i][j]);
            }
        }
    }

    static void setMatrixZero_Brute(int array[][]) {

//        Final TC=> (n*m) + (n*m) + (n+m) almost = N^3, not good
        //TC=> n*m
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

        //TC=> n*m
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
        //TC=> n
        for (int j = 0; j < array.length; j++) {
            if (array[i][j] != 0) {
                array[i][j] = -1;
            }
        }
    }

    static void markColumn(int j, int[][] array) { // j bcz whole column which is to be updated
        //TC=> m
        for (int i = 0; i < array.length; i++) {
            if (array[i][j] != 0) {
                array[i][j] = -1;
            }
        }
    }


}
