package maths.basic;

//https://leetcode.com/problems/armstrong-number/
// if a number is distributed and each number is raised to power of 3, and the sum of all number are equal to n, tha it is arms string
// n=371 ==> 3 raised to power of 3 + 7 raised to power of 3 + 1 raised to power of 3 = 371. Hence it is a armstrong number.
public class ArmstrongNumber {

    public static void main(String[] args) {
        //371

        System.out.println(isArmstrongNumber(371));
    }


    static boolean isArmstrongNumber(int x) {

        int finalNumber = 0;
        int tempX = x;
        while (x != 0) {
            int lastDigit = x % 10;
//            finalNumber = (lastDigit * lastDigit * lastDigit) + finalNumber;
            finalNumber = (int) Math.pow(lastDigit, 3) + finalNumber; // optimised way
            x = x / 10;
        }

        if (tempX == finalNumber) {
            return true;
        }

        return false;
    }
}
