package maths.basic;

// on reverse of the number the value should be same as n
public class Palindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(-121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) { // to handle negative no. case
            return false;
        }
        long finalNum = 0;
        int tempX = x;
        while (x != 0) {
            int lastDig = x % 10;
            finalNum = finalNum * 10 + lastDig;
            x = x / 10;
        }
        if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
            return false;
        }
        if (tempX == finalNum) {
            return true;
        }
        return false;
    }


}
