package hashing.basic;

import java.util.Scanner;

// Note IMP
//if you add more than allowed maxSize it will throw Segmentation error // NOTE, I checked Integer hashing with 10 power of 8 It works for me in side main
// For Integer : Max Size in side main function can be 10 power of 6
// For Integer : Max Size globally can be 10 power of 7


// For Boolean : Max Size in side main function can be 10 power of 7
// For Boolean : Max Size globally can be 10 power of 8


// No limitation for hash size for characters, bcz max it can go if you add lower and upper case is 256
public class BasicHashing {

    public static void main(String[] args) {
//        integerHashing();
//        charHashingForLowerOrUpperCase();
        charHashingForAllCase();
    }

    // For all lower and upper alphabets
    static void charHashingForAllCase() {
        //input
        Scanner scanner = new Scanner(System.in);
        String value = scanner.next();

        //precompute
//        Since the assumption is for all case, There are total 256 alphabets.
        // No limitation for hash size for characters, bcz max it can go if you add lower and upper case is 256
        int[] hash = new int[256];
        for (int i = 0; i < value.length(); i++) {
            // Note : This is case sensitive
            hash[value.charAt(i)]++; // EX => if i = 'A', it will be incremented +1 at index 65, if again 'A' than again increment.
        }

        // queries
        int q = scanner.nextInt();
        while (q-- != 0) {
            char checkValue = scanner.next().charAt(0);

            //fetch
            System.out.println("Value of " + checkValue + " " + hash[checkValue]);
        }

    }


    // Assumed all the values are lower case, so minus 'a'
    // If all are upper case than minus 'A'
    static void charHashingForLowerOrUpperCase() {
//        String value = "valuee";

        //input
        Scanner scanner = new Scanner(System.in);
        String value = scanner.next();    // We are assuming all the characters are lower case

        //precompute
//        Since the assumption is for all lower case, There are total 25 lower case alphabets. So maxSize+1
        int[] hash = new int[26];
        for (int i = 0; i < value.length(); i++) {
            hash[value.charAt(i) - 'a']++; // EX => a = 97 and f=102, if i=f, than f-1 i.e. 102-93=5. So at 5th index it will store the value and increment it if again f is found.
        }

        // queries
        int q = scanner.nextInt();
        while (q-- != 0) {
            char checkValue = scanner.next().charAt(0);

            //fetch
            System.out.println("Value of " + checkValue + " " + hash[checkValue - 'a']);
        }

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
