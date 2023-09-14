package maths.basic;

import sun.security.timestamp.TSRequest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// Remainder should be 0, so use %
public class PrintAllDivisors {
    // TS ==> O(N), bcz loop is running till N and the inner calculation is unit calculation, can be avoided for TS
    public static void main(String[] args) {
        PrintAllDivisorsOptimisedAndSorted(36);
    }

    //Optimised 3
    static void PrintAllDivisorsOptimisedAndSorted(int n) {
        //https://www.youtube.com/watch?v=1xNbjMdbjug&t=8s 30:10
//        since the values during iteration are same, we can take the loop till square root of N

        // EX ==> for N=36
        // 1 * 36 = 36
        // 2 * 18 = 36
        // 3 * 12 = 36
        // 4 * 9 = 36
        // 6 * 6 = 36   /// this is the breaking point. Hence we will take iteration till square root of N
        // 9 * 4 = 36
        // 3 * 12 = 36
        // 2 * 18 = 36
        // 1 * 36 = 36

        List<Integer> list = new ArrayList<>();
        // n = no of factors
        // TS=> O(sqrt(n))
        for (int i = 1; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {
                list.add(i);
//                System.out.print(i + ", ");
                if ((n / i) != i) { // this is to avoid is both the side has same numbers like 6*6 in above example
                    // all the right side of the calculation
//                    System.out.print(n / i + ", ");
                    list.add((n / i));
                }
            }
        }
        System.out.println("Unsorted " + list);
        // TS=> O( n * log(n))  // Internal sorting is O(n * log(n))
        Collections.sort(list); // for sorting
        System.out.println("Sorted " + list);

        // if you print your list than the TS ==> O(n)

        // so all the TS will be added for final TS
        // final  TS=> O(sqrt(n)) +  O( n * log(n))
    }

    //Optimised 1
    static void PrintAllDivisorsOptimised(int n) {
//https://www.youtube.com/watch?v=1xNbjMdbjug&t=8s 30:10
//        since the values during iteration are same, we can take the loop till square root of N

        // EX ==> for N=36
        // 1 * 36 = 36
        // 2 * 18 = 36
        // 3 * 12 = 36
        // 4 * 9 = 36
        // 6 * 6 = 36   /// this is the breaking point. Hence we will take iteration till square root of N
        // 9 * 4 = 36
        // 3 * 12 = 36
        // 2 * 18 = 36
        // 1 * 36 = 36

        for (int i = 1; i <= Math.sqrt(n); i++) {

            if (n % i == 0) {
                System.out.print(i + ", ");
                if ((n / i) != i) { // this is to avoid is both the side has same numbers like 6*6 in above example
                    // all the right side of the calculation
                    System.out.print(n / i + ", ");
                }
            }
        }
    }


    //Optimised 2
    static void PrintAllDivisorsOptimisedV2(int n) {
        // Explanation for : i * i <= n
//        since 6*6 <=36
//              7*7<= 36 ==> It will be false
        for (int i = 1; i * i <= n; i++) {

            if (n % i == 0) {
                System.out.print(i + ", ");
                if ((n / i) != i) { // this is to avoid is both the side has same numbers like 6*6 in above example
                    // all the right side of the calculation
                    System.out.print(n / i + ", ");
                }
            }
        }
    }

    //OWN
    static void PrintAllDivisors(int n) {

        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {
                System.out.print(i + ", ");
            }
        }

    }


}
