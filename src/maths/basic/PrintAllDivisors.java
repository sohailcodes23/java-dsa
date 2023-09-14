package maths.basic;

// Remainder should be 0, so use %
public class PrintAllDivisors {
    // TS ==> O(N), bcz loop is running till N and the inner calculation is unit calculation, can be avoided for TS
    public static void main(String[] args) {
        PrintAllDivisors(36);
    }

    static void PrintAllDivisors(int n) {

        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {
                System.out.print(i + ", ");
            }
        }

    }

}
