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
        recursiveFunction(0, nums, new ArrayList<>());
    }

    static void recursiveFunction(int index, int dataStructure[], List<Integer> list) {

        if (index >= n) {
            System.out.println(list);
            return;
        }

        list.add(dataStructure[index]);
        recursiveFunction(index + 1, dataStructure, list);// Take the element // RF1
        list.remove(list.size() - 1);
        recursiveFunction(index + 1, dataStructure, list);// Don't take the current index element // RF2
    }

}
