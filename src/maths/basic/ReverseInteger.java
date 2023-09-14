package maths.basic;

//https://leetcode.com/problems/reverse-integer/description/
public class ReverseInteger {
    //9646324351
    public static void main(String[] args) {
        System.out.println(reverse1(1534236469));

    }

    // Not working for 1534236469, working for rest of the test cases
    public static int reverse1(int x) {
        long finalNumber = 0;
        // Replacing  while (x > 0) { with  while (x != 0) {, so that you can directly use the x variable rather than converting it to a positive number
        while (x != 0) {
            int lastDigit = x % 10;
            finalNumber = (finalNumber * 10) + lastDigit;
            x = x / 10;
        }
        if (finalNumber < Integer.MIN_VALUE || finalNumber > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) finalNumber;
    }

    //Works in all scenario, but we can't use long according to question
    public static int reverse(int x) {
        long finalNum = 0;
        while (x != 0) {
            int lastDig = x % 10;
            finalNum = finalNum * 10 + lastDig;
            x = x / 10;
        }
        System.out.println("FF " + finalNum);
        if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            return (int) (-1 * finalNum);
        }
        return (int) finalNum;
    }
}
