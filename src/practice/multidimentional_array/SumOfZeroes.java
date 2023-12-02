package practice.multidimentional_array;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfZeroes {

    public static void main(String[] args) {

        int[][] array = {
                {0, 1},
                {1, 2},
                {0, 1}
        };

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        // Add rows to the matrix
        matrix.add(new ArrayList<>(Arrays.asList(0, 2)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 1)));

        Integer i = coverageOfMatrix(matrix);
        System.out.println("ANS " + i);
    }


    public static Integer coverageOfMatrix(ArrayList<ArrayList<Integer>> mat) {

//        TC=> 0(N^2)

        int n = mat.size(); // all horizontal lines
        int m = mat.get(0).size(); // all vertical(within horizontal data size) lines
        int sum = 0;
        for (int i = 0; i < n; i++) {


            for (int j = 0; j < m; j++) {

                // only check all directions when there is 0
                if (mat.get(i).get(j) == 0) {

                    // check top elements

                    if (i > 0  // i>0 bcz if is greater only than there will be top rows, if i is at 0th index than there won't be any top row
                            && mat.get(i - 1).get(j) == 1) { // 'mat.get(i - 1).get(j)' bcz if i is at more than 0th index than there is a top and to access that we need to '-1'. let's say i=1, so the top row will be 0th index so now when we want to access it we will 1-1 =0. we accessed the 0th index, this will go if i=2 than 2-1=1, to access 1st index

                        sum++;
                    }

                    // check left element
                    if (j > 0       // j>0 bcz if is greater only than there will be left columns, if j is at 0th index than there won't be any left column
                            && mat.get(i).get(j - 1) == 1) { // 'mat.get(i).get(j - 1)' bcz if j is at more than 0th index than there is a left and to access that we need to '-1'. let's say j=1, so the left column will be 0th index so now when we want to access it we will 1-1 =0. we accessed the 0th index, this will go if j=2 than 2-1=1, to access 1st index

                        sum++;
                    }

                    // check bottom

                    if (i < n - 1 // so if there are 3 rows than n=3, n-1 = 2, and i<n-1 means i<2, that means either 0 or 1, if i is 0 or 1 only than it will be able to access the bottom values
                            && mat.get(i + 1).get(j) == 1) { // 'mat.get(i + 1).get(j)' if i+1 that means we accessed the bottom row and now we will iterate through the columns

                        sum++;
                    }

                    // check right
                    if (j < m - 1 // so if there are 3 columns than m=3, m-1 = 2, and j<m-1 means j<2, that means either 0 or 1, if i is 0 or 1 only than it will be able to access the right values
                            && mat.get(i).get(j + 1) == 1) { // 'mat.get(i).get(j + 1)' if j+1 that means we accessed the right column
                        sum++;
                    }


                }

            }

        }

        return sum;

    }

}
