package learnandpractice.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {


    public static void main(String[] args) {
        int a[] = {3, 1, 2};
        subsets(a);
        System.out.println("LL " + subsets);
    }

    static List<List<Integer>> subsets = new ArrayList<>();
    static int n = 0;

    public static List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        recursiveFunctionToGetSubSets(0, nums, new ArrayList<>());
        return subsets;
    }

    static void recursiveFunctionToGetSubSets(int i, int arr[], List<Integer> list) {

        if (i >= n) {
            subsets.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[i]);
        recursiveFunctionToGetSubSets(i + 1, arr, list);// Take the element

        list.remove(list.size() - 1);
        recursiveFunctionToGetSubSets(i + 1, arr, list);// Don't take the current index element
    }

}
