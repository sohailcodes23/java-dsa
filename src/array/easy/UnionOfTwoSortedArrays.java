package array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {

//        int[] array1 = {1, 1, 2, 2, 3, 5, 6};
//        int[] array2 = {2, 2, 2, 3, 4, 4, 7};
        int[] array1 = {1, 2, 2, 3, 5, 6};
        int[] array2 = {2, 3, 4, 4, 7};
        System.out.println("DD " + unionArrays_Optimal(array1, array2));
        System.out.println("DD " + unionArrays_Optimalv2(array1, array2));
    }


    static ArrayList<Integer> unionArrays_Optimalv2(int arr1[], int arr2[]) {

        int i = 0;
        int j = 0;
        int n = arr1.length;
        int m = arr2.length;

        ArrayList<Integer> unionArray = new ArrayList<>();
        while (i < n && j < m) {

            if (arr1[i] <= arr2[j]) {

                if (unionArray.size() == 0 || unionArray.get((unionArray.size() - 1)) != arr1[i]) {
                    unionArray.add(arr1[i]);
                }
                i++;
            } else {
                if (unionArray.size() == 0 || unionArray.get((unionArray.size() - 1)) != arr2[i]) {
                    unionArray.add(arr2[j]);
                }
                j++;
            }
        }

        return unionArray;
    }

    // Approach when both the arrays are sorted
    static ArrayList<Integer> unionArrays_Optimal(int arr1[], int arr2[]) {
//        int[] array1 = {1, 1, 2, 2, 3, 5, 6};
//        int[] array2 = {2, 2, 2, 3, 4, 4, 7};
        int i = 0; // pointers for array1
        int j = 0; // pointers for array2

        int n = arr1.length, m = arr2.length;
        ArrayList<Integer> unionArray = new ArrayList<>(); // Uninon vector
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) // Case 1 and 2 // we need to add the smaller value in the array, so th elements are unique and sorted
            {
                if (unionArray.size() == 0 || unionArray.get(unionArray.size() - 1) != arr1[i]) { // unionArray.get(unionArray.size() - 1) = last value in the index
                    unionArray.add(arr1[i]);
                }
                i++;
            } else // case 3
            {
                if (unionArray.size() == 0 || unionArray.get(unionArray.size() - 1) != arr2[j]) {
                    unionArray.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < n) // IF any element left in arr1
        {
            if (unionArray.get(unionArray.size() - 1) != arr1[i])
                unionArray.add(arr1[i]);
            i++;
        }
        while (j < m) // If any elements left in arr2
        {
            if (unionArray.get(unionArray.size() - 1) != arr2[j])
                unionArray.add(arr2[j]);
            j++;
        }
        return unionArray;
    }

    public static List<Integer> unionArrays_Brute(int[] a, int[] b) {

        // we need to use ordered set or maps to store unqiue elements.
        HashMap<Integer, Integer> hashMap = new HashMap();
        List<Integer> unionArrays = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {

//            hashMap.put(a[i], a[i]); // this will work for unionArray
            hashMap.put(a[i], hashMap.getOrDefault(a[i], 0) + 1); // "hashMap.getOrDefault(a[i], 0) + 1" is added to update the frequencies of the number count
        }

        for (int i = 0; i < b.length; i++) {
//            hashMap.put(b[i], b[i]);
            hashMap.put(b[i], hashMap.getOrDefault(b[i], 0) + 1);
        }
        for (int i : hashMap.keySet()) {
            unionArrays.add(i);
        }
// optimised way fo adding in union
//        unionArrays.addAll(hashMap.keySet());
        return unionArrays;
    }
}
