package practice.array;

import java.util.Arrays;


// GFG= https://www.geeksforgeeks.org/program-find-minimum-maximum-element-array/
public class FindMinAndMaxELement {

    public static void main(String[] args) {
//        int array[] = {1, 2, 3, 44, 4, 8, 5, 9, 4};
        int array[] = {200, 10, 20, 15, 2, 23, 90, 67, 101};
//        int array[] = {10, 20, 15, 2, 23, 90, 67, 101};
//        int array[] = { 10, 20, 15, 2, 23, 90, 67};


        System.out.println("ANS " + Arrays.toString(findMinAndMaxv2(array)));
    }

    //linear
    static int[] findMinAndMax(int array[]) {
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }


        return new int[]{min, max};

    }

    static int[] findMinAndMaxv2(int array[]) {
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
        }


        return new int[]{min, max};

    }
}