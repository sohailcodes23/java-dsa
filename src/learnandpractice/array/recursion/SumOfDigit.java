package learnandpractice.array.recursion;

public class SumOfDigit {

    public static void main(String[] args) {
        System.out.println(SumOfDigit(1234));
        System.out.println(prodOfDigit(1234));
        System.out.println(reverse(1234));
    }

    static int sum = 0;

    static int reverse(int n) {

        if (n <= 0) {
            return n;
        }

        int last = n % 10;
        sum = sum * 10 + last;

        reverse(n / 10);

        return sum;

    }

    static int SumOfDigit(int n) {

        if (n <= 0) {
            return 0;
        }

        int lastDig = n % 10;
        return lastDig + SumOfDigit(n / 10);
    }

    static int prodOfDigit(int n) {

        if (n % 10 == n) {
            return n;
        }

        int lastDig = n % 10;
        return lastDig * prodOfDigit(n / 10);
    }

}
