package practice.array;

import java.util.Collections;
import java.util.HashMap;

//https://www.codingninjas.com/studio/problems/minimum-operations_762937?topList=top-array-coding-interview-questions&leftPanelTabValue=PROBLEM

// IMP: you only have to check how many elements are there that need operations on them
// so we are saving occurence of all the elements
// than check what's the max occurence
// now lets say there are 10 elements and 4 elements have value as "3". Now how many remaing elements are there
// N- max occurence, so 10 -4 =6. We don't have to think about which type of operation we will do like add, substract and all
// we just want the number of minimum operations to be performed on all the elements to make the elements equal
public class MinimumOperation {

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 4, 3, 3, 3, 2, 1};
//        int array[] = {1, 2, 3};
        System.out.println("ANS " + minimumOperation(array, array.length));
    }

    public static int minimumOperation(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {

            map.put(num, map.getOrDefault(num, 0) + 1);

        }

        int max = Collections.max(map.values());
        return n - max;
    }
}
