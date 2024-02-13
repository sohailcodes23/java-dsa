package coderarmy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {

    public static void main(String[] args) {
//        int arr[] = {1, 5, 3, 4, 3, 5, 6};
        int arr[] = {1, -2, 2, -4, 3, -5, 2};
//        int arr[] = {1, 2, 3, 4, 5};
//        int arr[] = {16, 19, 3, 14, 11, 7, 20, 2, 17, 6, 18, 11, 20, 4};
//        int arr[] = {1};
//        System.out.println(getCountBetween2Element(arr, arr.length, 3, 20));
//        System.out.println(firstRepeatedElement(arr, arr.length));

        moveAllNegativeElementsToRight(arr, arr.length);
    }

    public static int firstRepeatedElement(int[] arr, int n) {

//        TC=> O(N)
//        SC=> O(N)
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int count = hashMap.getOrDefault(arr[i], 0);
            hashMap.put(arr[i], count + 1);
        }

        for (int i = 0; i < n; i++) {

            if (hashMap.get(arr[i]) > 1) {
                return i + 1;
            }
        }
        return -1;
    }

    public static int firstRepeatedElement_Brute(int[] arr, int n) {
        // TC=> O(N^2)
        // SC=> O(1)
        boolean repeated = false;
        int index = -1;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (arr[i] == arr[j] && i != j) {
                    repeated = true;
                }
            }

            if (repeated) {
                index = i;

                return index + 1;
            }

        }
        return index;
    }

    public static int sumOfUnique(int[] nums) {

//        TC=> O(N)
//        SC=> O(N)
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : hashMap.entrySet()) {

            if (integerIntegerEntry.getValue() == 1) {
                sum = sum + integerIntegerEntry.getKey();
            }
        }

        return sum;
    }

    public static int sumOfUnique_Brute(int[] nums) {

//        TC=> O(N^2)
//        SC=> O(1)
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int currentCurrent = nums[i];

            boolean unique = true;
            for (int j = 0; j < n; j++) {
                if (currentCurrent == nums[j]
                        && i != j) {
                    unique = false;
                }
            }
            if (unique) {
                sum = currentCurrent + sum;
            }

        }

        return sum;
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

        System.out.println(sumOfNaturalValues + " " + sumOfAllValues);
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


    static int getCountBetween2Element(int arr[], int n, int num1, int num2) {
        // Complete the function

        int start = 0;
        int end = 0;
        int flag = 0;
        for (int i = 0; i < n; i++) {

            if (arr[i] == num1 && flag == 0) { // flag ==0 means index is not yet found

                start = i;
                flag = 1;
            }

            if (arr[i] == num2) { // Didn't checked flag bcz at the end, etreme right index will be assigned to end
                end = i;
            }
        }
        int ans = (end - start - 1);
        return Math.max(ans, 0);
    }

    public static void moveAllNegativeElementsToRight(int arr[], int n) {

    }
    public static void moveAllNegativeElementsToRight_Brute(int arr[], int n) {
        int tempArray[] = new int[arr.length];

        // Assigning positive number at start
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                tempArray[index] = arr[i];
                index++;
            }
        }


        // Assigning negative number at end
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                tempArray[index] = arr[i];
                index++;
            }
        }

        // reassigning all elements to original array
        for (int i = 0; i < tempArray.length; i++) {
            arr[i] = tempArray[i];
        }

        System.out.println(Arrays.toString(arr));
    }

}
