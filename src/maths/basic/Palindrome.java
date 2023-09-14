package maths.basic;

// on reverse of the number the value should be same as n
public class Palindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        int finalNumber = 0;
        int tempX = x;
        // here for negative number it won't be usefull to use loop bcz -121 will be 121-, which doesn't make sense

        while (tempX > 0) {
            int lastDigit = tempX % 10;
            tempX = tempX / 10;
            finalNumber = finalNumber * 10 + lastDigit;
        }
        return finalNumber == x;
    }


}
