package recursion.basic;

// 0 1 1 2 3 5 8 15....
// f(n) = f(n-1) + f(n-2)
public class FibonacciSeries {

    public static void main(String[] args) {
//        System.out.println("ANS " + NthValueInFibonacciSeries(4));
        FibonacciSeriesTillNth(8);
    }

    static int NthValueInFibonacciSeries(int n) {

        if (n <= 1) {
            return n;
        }
        return NthValueInFibonacciSeries(n - 1) + NthValueInFibonacciSeries(n - 2);
    }

    static void FibonacciSeriesTillNth(int n) {

        for (int i = 0; i < n; i++) {
            System.out.print(FibonacciSeries(i) + " ");
        }
    }


    static int FibonacciSeries(int n) {

        if (n <= 1) {
            return n;
        } else {
            return FibonacciSeries(n - 1) + FibonacciSeries(n - 2);
        }
    }

}
