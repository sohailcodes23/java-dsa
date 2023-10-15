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
        System.out.println("DD " + FindUnion(array1, array2, array1.length, array2.length));
        System.out.println("DD " + unionArrays_Optimal(array1, array2 ));
    }

    static ArrayList<Integer> FindUnion(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0; // pointers
        ArrayList<Integer> Union = new ArrayList<>(); // Uninon vector
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) // Case 1 and 2
            {
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else // case 3
            {
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
        }
        while (i < n) // IF any element left in arr1
        {
            if (Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }
        while (j < m) // If any elements left in arr2
        {
            if (Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }
        return Union;
    }

    // Approach when both the arrays are sorted
    static ArrayList<Integer> unionArrays_Optimal(int arr1[], int arr2[]) {
        int i = 0, j = 0; // pointers
        // unionArray.get(unionArray.size() - 1) = last value in the index
        int n = arr1.length, m = arr2.length;
        ArrayList<Integer> unionArray = new ArrayList<>(); // Uninon vector
        while (i < n && j < m) {
            System.out.println("1");
            if (arr1[i] <= arr2[j]) // Case 1 and 2
            {
                System.out.println("2");
                if (unionArray.size() == 0 || unionArray.get(unionArray.size() - 1) != arr1[i]) {
                    unionArray.add(arr1[i]);
                    i++;
                }
            } else // case 3
                System.out.println("3");
            {
                if (unionArray.size() == 0 || unionArray.get(unionArray.size() - 1) != arr2[j]) {
                    unionArray.add(arr2[j]);
                    j++;
                }
            }
        }

        while (i < n) // IF any element left in arr1
        {
            System.out.println("4");
            if (unionArray.get(unionArray.size() - 1) != arr1[i]) {
                unionArray.add(arr1[i]);
                i++;
            }
        }
        while (j < m) // If any elements left in arr2
        {
            System.out.println("5");
            if (unionArray.get(unionArray.size() - 1) != arr2[j]) {
                unionArray.add(arr2[j]);
                j++;
            }
        }
        System.out.println("6");
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
