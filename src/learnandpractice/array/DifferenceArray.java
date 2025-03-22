package learnandpractice.array;

import java.util.Scanner;

public class DifferenceArray {// Using PrefixSum

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();// size of array

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {// Add data in array
            arr[i] = sc.nextInt();
        }

        int diff[] = new int[n + 1];
        // Fill diff array
        for (int i = 0; i < diff.length; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int query = sc.nextInt();// value to add

            diff[l] = diff[l] + query;
            diff[r + 1] = diff[r + 1] - query;
        }

        int sum = 0;
        // Fill prefixSum aaray
        int prefix[] = new int[n + 1];
        for (int i = 0; i < prefix.length; i++) {
            sum = sum + diff[i];
            prefix[i] = sum;
        }

//        Add prefix + original array
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] + prefix[i];
            System.out.print(arr[i] + " ");
        }

    }
}
