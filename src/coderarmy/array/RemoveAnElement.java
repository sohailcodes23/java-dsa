package coderarmy.array;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveAnElement {

    public static void main(String[] args) {
//        ArrayList<Integer> a = new ArrayList<>();
//        int array[] = {3, 2, 2, 3};//3
//        int array[] = {0, 1, 2, 2, 3, 0, 4, 2};//2
        int array[] = {3, 3};//5
//
//        a.addAll(Arrays.asList(2, 0, 1, 2, 0, 3, 2, 2, 2, 1, 0, 0, 0, 1, 0, 0, 2, 2, 2, 3, 2, 3, 1, 2, 1, 2, 2, 3, 2, 3, 0, 3, 0, 2, 1, 2, 0, 0, 3, 2, 3, 0, 3, 0, 2, 3, 2, 2, 3, 1, 3, 3, 0, 3, 3, 0, 3, 3, 2, 0, 0, 0, 0, 1, 3, 0, 3, 1, 3, 1, 0, 2, 3, 3, 3, 2, 3, 3, 2, 2, 3, 3, 3, 1, 3, 2, 1, 0, 0, 0, 1, 0, 3, 2, 1, 0, 2, 3, 0, 2, 1, 1, 3, 2, 0, 1, 1, 3, 3, 0, 1, 2, 1, 2, 2, 3, 1, 1, 3, 0, 2, 2, 2, 2, 1, 0, 2, 2, 2, 1, 3, 1, 3, 1, 1, 0, 2, 2, 0, 2, 3, 0, 1, 2, 1, 1, 3, 0, 2, 3, 2, 3, 2, 0, 2, 2, 3, 2, 2, 0, 2, 1, 3, 0, 2, 0, 2, 1, 3, 1, 1, 0, 0, 3, 0, 1, 2, 2, 1, 2, 0, 1, 0, 0, 0, 1, 1, 0, 3, 2, 3, 0, 1, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0, 3, 2, 2, 0, 0, 1, 2, 0, 3, 0, 3, 3, 3, 0, 3, 3, 1, 0, 1, 2, 1, 0, 0, 2, 3, 1, 1, 3, 2)); //2
//        a.addAll(Arrays.asList(4, 1, 1, 2, 1, 3)); //1
        System.out.println("ANS " + removeElement(array, 2));
    }


    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n < 1) {
            return n;
        }

        // this will move all the values to forward, bcz we want to get the non value counter

        int j = 0;//  target counter
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i]; // update the value of the j
                j++;
            }
        }

        return j;
    }


}
