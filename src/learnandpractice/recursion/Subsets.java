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
        // TC ==> O(2^n) : Almost : Every index always has 2 options and the no. of division is almost till 2^n
        // SC ==> O(N): Auxiliary space: Depth is always till n size so O(N)
        n = nums.length;
        recursiveFunctionToGetSubSets(0, nums, new ArrayList<>());// helper function
        return subsets;
    }

    static void recursiveFunctionToGetSubSets(int i, int arr[], List<Integer> list) {

        if (i >= n) { // base case
            subsets.add(new ArrayList<>(list));
            return;
        }

        list.add(arr[i]);// Add in the list
        recursiveFunctionToGetSubSets(i + 1, arr, list);//RF1: Take the element

        list.remove(list.size() - 1);//MISTAKE: Remove from th elist to not take the current element in subset
        recursiveFunctionToGetSubSets(i + 1, arr, list);//RF2: Don't take the current index element: Here it will be the same index which was passed in RF1, so we are basically not taking that index element in that list
    }

}
