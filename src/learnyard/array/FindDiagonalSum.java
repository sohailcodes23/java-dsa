package learnyard.array;

public class FindDiagonalSum {

    public static void main(String[] args) {
        diagonalSum();
    }

    public static void diagonalSum() {

        int arr[][] = new int[][]{
                {1, 2, 3},
                {4, 9, 6},
                {5, 8, 9}};


        int n = arr.length;
        int m = arr[0].length;

        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    leftDiagonalSum = leftDiagonalSum + arr[i][j];
                }

                if ((i + j) == n - 1) {
                    rightDiagonalSum = rightDiagonalSum + arr[i][j];
                }
            }
        }

        System.out.println("LEFT " + leftDiagonalSum);
        System.out.println("RIGHT " + rightDiagonalSum);
    }
}
