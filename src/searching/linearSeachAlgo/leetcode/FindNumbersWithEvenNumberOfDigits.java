package searching.linearSeachAlgo.leetcode;

//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        int[] sourceArray = {12, 345, 2, 6, 7896};
        System.out.println("EVEN ANS " + findNumbersWithEvenNumberOfDigits(sourceArray));
        System.out.println("ODD ANS " + findNumbersWithODDNumberOfDigits(sourceArray));
    }


    //EVEN
    public static int findNumbersWithEvenNumberOfDigits(int[] nums) {
        int ans = 0;
        for (int value : nums) {
            // NOTE Using String.valueOf to get the length of number
            int valueLength = String.valueOf(value).length();
            if (valueLength % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    //ODD
    public static int findNumbersWithODDNumberOfDigits(int[] nums) {
        int ans = 0;
        for (int value : nums) {

            // NOTE Using String.valueOf to get the length of number
            int valueLength = String.valueOf(value).length();
            if (valueLength % 2 != 0) {
                ans++;
            }
        }
        return ans;
    }

}
