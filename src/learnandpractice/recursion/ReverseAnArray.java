package learnandpractice.recursion;

import util.CommonUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseAnArray {
    static List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
//        ReverseAnArrayv3(a, 0, a.length - 1);// way 3
        ReverseAnArrayv2(a, 0);// way 2
        System.out.println(Arrays.toString(a));
//        ReverseAnArray(a, 0);
//
//        System.out.println(integerList);
    }

    // Way 1: using an external list
    static void ReverseAnArray(int arr[], int i) {

        if (i == arr.length) {
            return;
        }

        ReverseAnArray(arr, i + 1);
        integerList.add(arr[i]);
    }

    //Way 2: Using single variable
    static void ReverseAnArrayv2(int arr[], int i) {
        int n = arr.length;
        if (i == n / 2) {
            return;
        }
        int j = n - i - 1;
        ReverseAnArrayv2(arr, i + 1);
        CommonUtility.swapBasedOnIndex(i, j, arr);// can be called any where before or after recursinve function
    }

    // way 3: using 2 pointers
    static void ReverseAnArrayv3(int arr[], int i, int j) {
        if (i >= j) {
            return;
        }
        CommonUtility.swapBasedOnIndex(i, j, arr);
        ReverseAnArrayv3(arr, i + 1, j - 1);
    }
}
