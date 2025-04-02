package learnandpractice.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequenceWhereSumIsK_RecursionPattern {


    public static void main(String[] args) {
        int a[] = {1, 2, 1};
        printAllSubsequence(a, 2);
    }

    static int n = 3;

    public static void printAllSubsequence(int[] nums, int k) {
        n = nums.length;
        int sum = 0;
        recursiveFunction(0, nums, new ArrayList<>(), k, sum);
    }

    static void recursiveFunction(int index, int dataStructure[], List<Integer> list, int k, int sum) {
        // List is required to show which elements is sum == k
        if (index >= n) {
            if (sum == k) {
                System.out.println("SUM " + list);
            }
            return;
        }

        list.add(dataStructure[index]);// Add in the list
        sum = sum + dataStructure[index];// ADD in sum for the same reasons it was added in the list

        recursiveFunction(index + 1, dataStructure, list, k, sum);//RF1: Take the element
        list.remove(list.size() - 1);//MISTAKE: Remove from th elist to not take the current element in subset
        sum = sum - dataStructure[index];// REMOVE from sum for the same reasons it was removed from the list, here we are removing value
        recursiveFunction(index + 1, dataStructure, list, k, sum);//RF2: Don't take the current index element: Here it will be the same index which was passed in RF1, so we are basically not taking that index element in that list
    }

}
