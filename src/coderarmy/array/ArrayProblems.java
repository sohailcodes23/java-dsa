package coderarmy.array;

import java.util.Arrays;

public class ArrayProblems {

    public static void main(String[] args) {
//        int arr[] = {1, 2, 3, 5};
//        int arr[] = {1};
//        System.out.println(missingNumber(arr, 5));
        System.out.println(fibonacciNumberTillN(7));
    }

    static int fibonacciNumberTillN(int n) {
        //n means gets the nth number : 0 1 1 2 3 5 8 13.............., so if n=7 than ANS = 8

        int array[] = new int[n];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n - 1; i++) {
            array[i] = array[i - 1] + array[i - 2];// we are starting the loop from 3rd element, so that we can add the last 2 element values
        }

        return array[n - 1];
    }

    static int missingNumber(int array[], int n) {
        // n is biggest number in array
        //(sum of n natural numbers) - (sum of all value)

        int sumOfNaturalValues = n * (n + 1) / 2;
        int sumOfAllValues = 0;
        for (int i = 0; i < n - 1; i++) {
            sumOfAllValues = array[i] + sumOfAllValues;
        }

        return sumOfNaturalValues - sumOfAllValues;
    }

    static int secondMax(int arr[]) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }


        int secondMax = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != max && arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }

    static void reverseArray(int arr[]) {
        int n = arr.length;
        //1
//        for (int i = 0; i < arr.length / 2; i++) {
//            swapBasedOnIndex(i, n - 1 - i, arr);
//        }

        //2
        int i = 0, j = n - 1;
        while (i < j) {
            swapBasedOnIndex(i, j, arr);
            i++;
            j--;
        }

        System.out.println("ANS " + Arrays.toString(arr));
    }

    static void swapBasedOnIndex(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int linearSearch(int arr[], int N, int X) {

        // Your code here

        for (int i = 0; i < N; i++) {

            if (arr[i] == X) {
                return i;
            }
        }

        return -1;
    }


}
