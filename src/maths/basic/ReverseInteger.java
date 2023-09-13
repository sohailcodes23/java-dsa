package maths.basic;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(123));

    }

    public static int reverse(int x) {
        int finalNumber = 0;
        while (x > 0) {
            int lastDigit = x % 10;
            x = x / 10;

            finalNumber = (finalNumber * 10) + lastDigit;
        }

        return finalNumber;
    }
}
