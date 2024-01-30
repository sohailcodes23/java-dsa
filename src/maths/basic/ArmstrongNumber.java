package maths.basic;

//https://leetcode.com/problems/armstrong-number/
//n=> n is number of digits like in 371 it is 3 and in 1634 it is 4
// if a number is distributed and each number is ^n, and the sum of all number are equal to n, than it is armstrong
// x=371 ==> 3^n + 7^n + 1^n = 371. Hence it is a armstrong number.
public class  ArmstrongNumber {

    public static void main(String[] args) {
        //371
        //1634
        System.out.println(isArmstrongNumber(1634));
    }


    static boolean isArmstrongNumber(int x) {

        int finalNumber = 0;
        int tempX = x;
        int n = 0;
        while (tempX != 0) {
            tempX = tempX / 10;
            n++;
        }
        tempX = x;
        System.out.println("N " + n);
        while (x != 0) {
            int lastDigit = x % 10;
//            finalNumber = (lastDigit * lastDigit * lastDigit) + finalNumber;
            finalNumber = (int) Math.pow(lastDigit, n) + finalNumber; // optimised way
            x = x / 10;
        }

        if (tempX == finalNumber) {
            return true;
        }

        return false;
    }
}
