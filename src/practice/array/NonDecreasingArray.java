package practice.array;

import java.util.Arrays;


//https://www.youtube.com/watch?v=RegQckCegDk
public class NonDecreasingArray {

    public static void main(String[] args) {


//        int array[]={8,4,6}; // update 0th index with 2
//        int array[] = {-2, 7, -1, 0, 1, 2}; // update 1st index with -2
//        int array[] = {8, 4, 2}; // false
        int array[] = {1, 3, 2}; // false
//        int array[] = {4, 2, 3}; // true
//        int array[] = {5, 7, 1, 8}; // true

//        int array[] = { -98,-65, -18, 44, 6, 49, 64, 95, 81, 68};
//
//        int array[] = {-73,-262, -10, 26, 36, 432, 63, 65, 79, 82};
//
//        int array[] = {-100, 285, -84, -80, -76, -50, -15, -14, -6 ,90};

//        int array[][] = {{-98, -65, -18, 44, 6, 49, 64, 95, 81, 68},
//
//                {
//                        -73, -262, -10, 26, 36, 432, 63, 65, 79, 82
//                },
//
//                {
//                        -100, 285, -84, -80, -76, -50, -15, -14, -6, 90
//                }};
//
//
//        for (int i = 0; i < 3; i++) {
////            System.out.println("ANS " + i + " " + isPossible(array[i], array[i].length));
//            System.out.println(isPossible_Brute(array[i], array[i].length));
//        }

//        System.out.println("ANS " + isPossible_Brute(array, array.length));
//        System.out.println("ANS " + isPossible(array, array.length));
        System.out.println("ANS " + isPossiblev2(array, array.length));
    }

    public static boolean isPossiblev2(int[] arr, int n) {

        boolean changed = false;
        for (int i = 0; i < n - 1; i++) {


            if (arr[i] > arr[i + 1]) { // bcz the we want the values should be ascending order

                if (i == (n - 2) ||                 // check (i == (n - 2)) bcz with 2nd last element, it will go in the if condition, if we don't add this, based on our logic i+2 will throw index exception
                        arr[i] <= arr[i + 2]) {
                    arr[i + 1] = arr[i];
                } else {
                    arr[i] = arr[i + 1];
                }
                changed = true;
                break;
            }
        }
        if (changed) {
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
        }
        return true;

    }
}
