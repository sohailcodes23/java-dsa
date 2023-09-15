package maths.basic;

public class PrimeNumber {

    public static void main(String[] args) {
        System.out.println(isPrimeOptimised(11));
    }


    static boolean isPrimeOptimised(int n) {
//Same as we did in PrintAllDivisors, we can just check till sqrt of n

        int count = 0;
        //i * i <= n this is for sqrt check PrintAllDivisor for more info
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count++;

                if ((n / i) != i) {
                    count++;
                }
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }

    //Brute force
    static boolean isPrime(int n) {

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        }
        return false;
    }


}
