package general;

import java.io.BufferedReader;
import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine() // String
        int inputNumber = scanner.nextInt(); // to get Int

        boolean isPrime = true;

        if (inputNumber <= 1) {
            isPrime = false;
        }

        //Brute
//        for (int i = 2; i < inputNumber; i++) {
//// % means remainder(left after the division)
//            if (inputNumber % i == 0) {
//                isPrime = false;
//                break;
//            }
//        }


        // Optimised Approach
        for (int i = 2; i * i <= inputNumber; i++) {
            // % means remainder(left after the division)
            if (inputNumber % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(" Prime Number");
        } else {
            System.out.println("Not a Prime Number");
        }
    }
}
