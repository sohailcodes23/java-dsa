package coderarmy;

//maximum-difference-between-two-elements
public class DivideArrayInTwoSubArray {

    public static void main(String[] args) {

        int[] array = {3, 4, -2, 5, 8, 20, -10, 8};// true

        System.out.println("ANS " + canBeDivided_Brutev3(array));
    }

    public static boolean canBeDivided_Brutev3(int[] array) {

//        TC=> O(2N) == O(N)
//        SC=> O(1)
        int n = array.length;
        int sum = 0;
        int halfSum = 0;
        for (int i = 0; i < n; i++) { // TC=>N
            sum = sum + array[i];
        }

        halfSum = sum / 2;
        System.out.println("HALF " + halfSum);
        int firstHalfSum = 0;

        int halfSumIndex = -1;
        for (int i = 0; i < n; i++) { // TC=>N
            firstHalfSum = firstHalfSum + array[i];

            if (firstHalfSum == halfSum) {
                int secondHalfSum = sum - firstHalfSum;
                if (firstHalfSum == secondHalfSum) {
                    return true;
                }
            }
        }


        return false;

    }


    public static boolean canBeDivided_Brutev2(int[] array) {

//        TC=> O(N * 2N) == O(N^2)
//        SC=> O(1)
        int n = array.length;

        for (int breakIndex = 0; breakIndex < n; breakIndex++) { // TC=>N

            int firstHalfSum = 0;
            int secondHalfSum = 0;
            //first half
            for (int j = 0; j <= breakIndex; j++) { // TC=>N
                firstHalfSum = firstHalfSum + array[j];
            }

            //second half
            for (int j = breakIndex + 1; j <= n - 1; j++) { // TC=>N
                secondHalfSum = secondHalfSum + array[j];
            }
            System.out.println(breakIndex + " F " + firstHalfSum + " " + secondHalfSum);

            if (firstHalfSum == secondHalfSum) {
                return true;
            }
        }

        return false;

    }

    public static boolean canBeDivided_Brute(int[] array) {

//        TC=> O(3N) == O(N)
//        SC=> O(1)
        int n = array.length;
        int sum = 0;
        int halfSum = 0;
        for (int i = 0; i < n; i++) { // TC=>N
            sum = sum + array[i];
        }

        halfSum = sum / 2;
        System.out.println("HALF " + halfSum);
        int currentSum = 0;

        int halfSumIndex = -1;
        for (int i = 0; i < n; i++) { // TC=>N
            currentSum = currentSum + array[i];
            if (currentSum == halfSum) {
                halfSumIndex = i;
                break;
            }
        }

        System.out.println("HALF INDEX " + halfSumIndex);
        if (halfSumIndex == -1) {
            return false;
        }
        currentSum = 0;
        for (int i = halfSumIndex; i < n; i++) { // TC=>N
            currentSum = currentSum + array[i];
            if (currentSum == halfSum) {
                return true;
            }
        }

        return false;

    }

}
