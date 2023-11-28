package practice.array;

import java.util.Arrays;


//https://www.youtube.com/watch?v=RegQckCegDk
public class NonDecreasingArray {

    public static void main(String[] args) {


//        int array[]={8,4,6}; // update 0th index with 2
//        int array[] = {-2, 7, -1, 0, 1, 2}; // update 1st index with -2
//        int array[] = {8, 4, 2}; // false
        int array[] = {3,4,2,3}; // false
//        int array[] = {1, 3, 2}; // false
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
//        System.out.println("ANS " + checkPossibility_Better(array));
        System.out.println("ANS " + checkPossibility_Optimal(array));
//        System.out.println("ANS " + checkPossibility_Optimal(array));
    }

    public static boolean checkPossibility_Optimal(int[] nums) {

//        TC=> O(N)
//        SC=> O(1)
        int n = nums.length;
        boolean changed = false;

        for (int i = 0; i < n-1; i++) {
            if (nums[i] > nums[i + 1]) {

                if (changed) {// this is wihtin the condition, so if it's true that means it has been changed once
                    return false;
                }

//                EX 1: 4 2 3
//              if i>i+1
//                if i at 0th than
//                        i=i+1
//                if i !=0 than (i+1)[3] >= (i-1)[2]
//                        i=i+1
//                else i+1= i

//                EX 1: 8 4 2
//              if i>i+1
//                if i at 0th than
//                        i=i+1 [4 4 2]
//                if i !=0 than (i+1)[2] >= (i-1)[8]
//                        i=i+1
//                else i+1= i


                if (i == 0 || nums[i + 1] >= nums[i - 1]) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i + 1] = nums[i];
                }

                changed = true;
            }
        }

        return true;
    }

    // Another way
    public static boolean checkPossibility_Optimalv2(int[] nums) {

        int count = 0;
        //We can edit atmost 1 value, so break the loop if the count exceeds 1.
        for (int i = 1; i < nums.length; i++) {
            //Checking prev value with curr value
            if (nums[i - 1] > nums[i]) {
                System.out.println("BB " + Arrays.toString(nums));
                count++;
                //checking the second prev value from curr value.
                if (i - 2 < 0 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];    //If prev value is > current val, change the prev value.
                else
                    nums[i] = nums[i - 1];    //If last 2 values both are > current, change the current value.
            }
            if (count > 1) {
                break;
            }
        }
        return count <= 1;
    }





    public static boolean checkPossibility_Brute(int[] arr, int n) {

//        TC=> O(2N)
//        SC=> O(1)
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
