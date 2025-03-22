package learnandpractice.array;

public class Common {

    public static void main(String[] args) {
        print2DArray();
    }

    public static void print2DArray() {

        int arr[][] = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int n = arr.length;
        int m = arr[0].length;
        // outer - row
        //inner - column
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j]);
            }
        }

        System.out.println();
        // outer - column
        //inner - row

        for (int j = 0; j < m; j++) {
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i][j]);
            }
        }
    }
}
