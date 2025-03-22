package learnandpractice.array.recursion;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(fact(5));
        System.out.println(sumOfN(3));
        System.out.println(1234%10);
    }

    static int fact(int n) {

        if (n <= 1) {
            return 1;
        }

        return n * fact(n - 1);
    }
    static int sumOfN(int n) {

        if (n <= 1) {
            return 1;
        }

        return n + sumOfN(n - 1);
    }
}
