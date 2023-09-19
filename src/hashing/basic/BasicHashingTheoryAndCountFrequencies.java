package hashing.basic;

import java.util.HashMap;
import java.util.Scanner;

// READ : https://takeuforward.org/hashing/hashing-maps-time-complexity-collisions-division-rule-of-hashing-strivers-a2z-dsa-course/

// Note IMP
//if you add more than allowed  maxValue  it will throw Segmentation error // NOTE, I checked Integer hashing with 10 power of 8 It works for me in side main
// For Integer : Max Size in side main function can be 10 power of 6
// For Integer : Max Size globally can be 10 power of 7


// For Boolean : Max Size in side main function can be 10 power of 7
// For Boolean : Max Size globally can be 10 power of 8


// No limitation for hash size for characters, bcz max it can go if you add lower and upper case is 256

// Best and average case TS when HashMap is used=> 0(1) i.e. constant
// Worst case TS when HashMap is used=> 0(N) i.e. N is number of elements in array, This occurs very rarely.

//Our first priority will be always to use unordered_map(HashMap) and then map. If unordered_map gives a time limit exceeded error(TLE), we will then use the map.
//The time complexity in the worst case is O(N) because of the internal collision.

//Hashing methods :
//        1. Division method : In short the values are % by 10 and saved on that key, like 28%10 = 8(28 will be stored in a chain at key 8), 12%10= 2 (12 will be stored in a chain at key 2)
// Collisions: if multiple(Or all)  values are stored at a single key than collisions happens and then TS is worst case i.e. O(N)
//        2. Folding method
//        3. Mid-Square method
public class BasicHashingTheoryAndCountFrequencies {

    public static void main(String[] args) {
//        integerHashing();
//        charHashingForLowerOrUpperCase();
//        charHashingForAllCase();
        integerHashingUsingMapOptimised();
    }

    // Pre-compute is done in first for loop, but the TS doesn't change much
    static void integerHashingUsingMapOptimised() {

        // take the array length
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        // give the values of array
        //  pre-compute
        //  maxValue +1 //
        // if the input is 1,2,3,6,1,2, than while iterating after 3 it won't store for '4' value as 0, it will be assumed 0 by default, it will direct store '6' in the stash.
        // This is difference between using array and HashMap
        HashMap<Integer, Integer> hash = new HashMap<>(); // Here whatever problem states the maximum value in array are allowed add one, like if max size of array can be 12 than write 13, if 20 than 21,  maxValue +1
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();

            // Updating hashmap
            int key = array[i];
            int freq = 0;
            if (hash.containsKey(key)) {
                freq = hash.get(key);
            }
            freq++;
            hash.put(key, freq);
        }

        // Remove this
        //  pre-compute
        //  maxValue +1 //
        // if the input is 1,2,3,6,1,2, than while iterating after 3 it won't store for '4' value as 0, it will be assumed 0 by default, it will direct store '6' in the stash.
        // This is difference between using array and HashMap
//        for (int i = 0; i < n; i++) {
//            // Updating hashmap
//            int key = array[i];
//            int freq = 0;
//            if (hash.containsKey(key)) {
//                freq = hash.get(key);
//            }
//            freq++;
//            hash.put(key, freq);
//        }

        // Iterate over the map:
        /*
        for (Map.Entry<Integer, Integer> it : mp.entrySet()) {
            System.out.println(it.getKey() + "->" + it.getValue());
        }
        */

        // take the queries for which you numbers you want to print the occurrence of numbers

        int q = scanner.nextInt(); // this is the number of query values which we want to check in the array
        while (q-- != 0) { // we are decreasing till it's not = 0, EX if 5 than decreasing till 0
            int number = scanner.nextInt(); // taking the queries


            // fetching the value from hash
            // We can't directly fetch as hash.get(number) bcz if that key doesn't exist it will return null
            int frequencies = hash.get(number) == null ? 0 : hash.get(number);
            System.out.println("Occurrence of " + number + " " + frequencies);
        }
    }


    static void integerHashingUsingMap() {

        // take the array length
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int array[] = new int[n];
        // give the values of array
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        //  pre-compute
        //  maxValue +1 //
        // if the input is 1,2,3,6,1,2, than while iterating after 3 it won't store for '4' value as 0, it will be assumed 0 by default, it will direct store '6' in the stash. 
        // This is difference between using array and HashMap
        HashMap<Integer, Integer> hash = new HashMap<>(); // Here whatever problem states the maximum value in array are allowed add one, like if max size of array can be 12 than write 13, if 20 than 21,  maxValue +1
        for (int i = 0; i < n; i++) {
            // Updating hashmap
            int key = array[i];
            int freq = 0;
            if (hash.containsKey(key)) {
                freq = hash.get(key);
            }
            freq++;
            hash.put(key, freq);
        }

        // Iterate over the map:
        /*
        for (Map.Entry<Integer, Integer> it : mp.entrySet()) {
            System.out.println(it.getKey() + "->" + it.getValue());
        }
        */

        // take the queries for which you numbers you want to print the occurrence of numbers
        int q = scanner.nextInt(); // this is the number of query values which we want to check in the array
        while (q-- != 0) { // we are decreasing till it's not = 0, EX if 5 than decreasing till 0
            int number = scanner.nextInt(); // taking the queries


            // fetching the value from hash
            // We can't directly fetch as hash.get(number) bcz if that key doesn't exist it will return null
            int frequencies = hash.get(number) == null ? 0 : hash.get(number);
            System.out.println("Occurrence of " + number + " " + frequencies);
        }
    }


    // For all lower and upper alphabets
    static void charHashingForAllCase() {
        //input
        Scanner scanner = new Scanner(System.in);
        String value = scanner.next();

        //pre-compute
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

        //pre-compute
//        Since the assumption is for all lower case, There are total 25 lower case alphabets. So  maxValue +1
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
        //pre-compute
        //  maxValue +1 //
        int[] hash = new int[13]; // Here whatever problem states the maximum value in array are allowed add one, like if max size of array can be 12 than write 13, if 20 than 21,  maxValue +1
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
