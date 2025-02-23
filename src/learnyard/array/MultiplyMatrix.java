package learnyard.array;

public class MultiplyMatrix {

    public static void main(String[] args) {
        MultipleTwoArray();
    }

    static void MultipleTwoArray() {
        // Multiply row * column, and keep sum
        // HERE n* n
        int a[][] = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        int b[][] = new int[][]{
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}};
        int n = a.length;
        int c[][] = new int[n][n];
//       Expected ANS:
        //30 24 18
        //84 69 54
        //138 114 90

//        int j = 0;// will help 1st loop
        for (int i = 0; i < n; i++) {// row arr
            for (int j = 0; j < n; j++) {// column arr
                int sum = 0;
//                Here we want to iterate all the columsn but the row should be same till we iterate all the columns
                // So a new loop
                for (int k = 0; k < n; k++) {// columns arr, but only used till the ith row has multiplied with all the columns
                    sum = sum + a[i][k] * b[k][j];// [k][j] bcz j is updating the column, i,k only to multiply
                }
                c[i][j] = sum;
                System.out.print(sum + " ");
            }
            System.out.println();

        }

    }
}
