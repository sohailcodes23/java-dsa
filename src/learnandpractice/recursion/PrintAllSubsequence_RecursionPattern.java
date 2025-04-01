package learnandpractice.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence_RecursionPattern {


    public static void main(String[] args) {
        int a[] = {3, 1, 2};
        printAllSubsequence(a);
    }

    static int n = 3;

    public static void printAllSubsequence(int[] nums) {
        n = nums.length;
        helper(0, nums, new ArrayList<>());
    }

    static void helper(int index, int ds[], List<Integer> list) {

        if (index >= n) {
            System.out.println(list);
            return;
        }

        list.add(ds[index]);
        helper(index + 1, ds, list);// Take the element
        list.remove(list.size() - 1);
        helper(index + 1, ds, list);// Don't take the current index element
    }

}
