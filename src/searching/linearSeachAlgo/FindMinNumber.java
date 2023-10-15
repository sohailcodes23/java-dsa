package searching.linearSeachAlgo;

public class FindMinNumber {

    public static void main(String[] args) {
        int[] sourceArray = {7, 43, 2, 1, 6, 8, 9, -9};

        System.out.println("MIN " + getMinNumber(sourceArray));
    }

    static int getMinNumber(int[] sourceArray) {
        if (sourceArray.length == 0) {
            return -1;
        }
        int minNumber = sourceArray[0];
        for (int j : sourceArray) {
            if (j < minNumber) {
                minNumber = j;
            }
        }

        return minNumber;

    }
}
