package linearSeach;

public class FindMaxNumber {

    public static void main(String[] args) {
        int[] sourceArray = {7, 43, 2, 1, 6, 8, 9, -9, 99, 9098};

        System.out.println("MAX " + getMaxNumber(sourceArray));
    }

    static int getMaxNumber(int[] sourceArray) {
        if (sourceArray.length == 0) {
            return -1;
        }
        int maxNumber = sourceArray[0];
        for (int j : sourceArray) {
            if (j > maxNumber) {
                maxNumber = j;
            }
        }

        return maxNumber;

    }
}
