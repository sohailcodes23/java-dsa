package learnandpractice.recursion;

public class NToOne {

    public static void main(String[] args) {
        recur(5);
        System.out.println();
        recurOneToN(5);
    }

    static void recur(int n) {

        if (n <= 0) {
            return;
        }

        System.out.println(n);
        recur(n - 1);
    }

    static void recurOneToN(int n) {

        if (n <= 0) {
            return;
        }

        recurOneToN(n - 1);
        System.out.println(n);
    }
}
