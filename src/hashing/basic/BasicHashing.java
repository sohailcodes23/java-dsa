package hashing.basic;

import java.util.Scanner;

// Note IMP
// For Integer : Max Size in side main function can be 10 power of 6
// For Integer : Max Size globally can be 10 power of 7


// For Boolean : Max Size in side main function can be 10 power of 7
// For Boolean : Max Size globally can be 10 power of 8
public class BasicHashing {

    public static void main(String[] args) {
        integerHashing();
    }

    static void integerHashing() {

        // take the array length
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        // give the values of array
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        //precompute
        // maxSize+1 //
        int[] hash = new int[13]; // Here whatever problem states the maximum size of array are allowed add one, like if max size of array can be 12 than write 13, if 20 than 21, maxSize+1
        for (int i = 0; i < n; i++) {
            // assigning the value of hash
            // so if array[1] is 3, than in hash at the 3rd index it will add one, same goes for other values as well.
            hash[array[i]] += 1;
        }

        // take the queries for which you numbers you want to print the occurrence of numbers

        int q = scanner.nextInt(); // this is the number of query values which we want to check in the array
        while (q-- != 0) { // we are decreasing till it's not = 0, EX if 5 than decreasing till 0
            int number = scanner.nextInt(); // taking the queries


            // fetching the value from hash
            System.out.println("Occurrence of " + number + " " + hash[number]);
        }
    }

}
