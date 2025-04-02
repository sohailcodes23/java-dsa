package learnandpractice.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsequence_ALL_RecursionPattern {


    public static void main(String[] args) {
        int a[] = {1, 2, 1};
        printAllSubsequence(a, 2);
    }

    static int n = 0;

    public static void printAllSubsequence(int[] nums, int k) {
        // TC ==> O(2^n) : Almost : Every index always has 2 options and the no. of division is almost till 2^n
        // SC ==> O(N): Auxiliary space: Depth is always till n size so O(N)
        n = nums.length;
        int sum = 0;
//        recursiveFunction(0, nums, new ArrayList<>(), k, sum);
        recursiveFunctionForOnlyOneSumSequence(0, nums, new ArrayList<>(), k, sum);

        System.out.println("No. of Subsequenece for a array: " + recursiveFunctionForNoOfSubSequence(0, nums, k, sum));
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

    static int recursiveFunctionForNoOfSubSequence(int index, int dataStructure[], int k, int sum) {
        // List is required to show which elements is sum == k
        if (index >= n) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        sum = sum + dataStructure[index];// ADD in sum for the same reasons it was added in the list
        int l = recursiveFunctionForNoOfSubSequence(index + 1, dataStructure, k, sum);//RF1: Take the element

        sum = sum - dataStructure[index];// REMOVE from sum for the same reasons it was removed from the list, here we are removing value
        int r = recursiveFunctionForNoOfSubSequence(index + 1, dataStructure, k, sum);//RF2: Don't take the current index element: Here it will be the same index which was passed in RF1, so we are basically not taking that index element in that list

        return l + r;
    }

    // QQ: Print only one sum subsequence: return type is boolean bcz we want to do apply functional way to check this
    static boolean recursiveFunctionForOnlyOneSumSequence(int index, int dataStructure[], List<Integer> list, int k, int sum) {
        // List is required to show which elements is sum == k
        if (index >= n) {
            if (sum == k) {
                System.out.println("SUM " + list);
                return true;
            }
            return false;// At the last index but didn't found the sum
        }

        list.add(dataStructure[index]);// Add in the list
        sum = sum + dataStructure[index];// ADD in sum for the same reasons it was added in the list

        boolean foundOneSum = recursiveFunctionForOnlyOneSumSequence(index + 1, dataStructure, list, k, sum);//RF1: Take the element
        if (foundOneSum == false) {// if one is not found by taking the element, we need to check other subsets without taking the element
            list.remove(list.size() - 1);//MISTAKE: Remove from th elist to not take the current element in subset
            sum = sum - dataStructure[index];// REMOVE from sum for the same reasons it was removed from the list, here we are removing value
            return recursiveFunctionForOnlyOneSumSequence(index + 1, dataStructure, list, k, sum);//RF2: Don't take the current index element: Here it will be the same index which was passed in RF1, so we are basically not taking that index element in that list
        } else {
            return foundOneSum;// Always true
        }
    }

}
