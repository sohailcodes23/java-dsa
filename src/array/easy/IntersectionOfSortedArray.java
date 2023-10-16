package array.easy;

import java.util.ArrayList;
import java.util.Arrays;

//Intersection = present in both the array
// Multiple same values are allowed
public class IntersectionOfSortedArray {

    public static void main(String[] args) {

//        int[] array1 = {1, 1, 2, 2, 3, 5, 6};
//        int[] array2 = {2, 2, 2, 3, 4, 4, 7};
        int[] array1 = {1, 2, 2, 3, 5, 6};
        int[] array2 = {2, 3, 4, 4, 5, 7};
//     int[] array1 = {1, 2, 2, 3, 3, 4, 5, 6,7};
//        int[] array2 = {2, 3, 3, 5, 6, 6,6, 7};

        ArrayList<Integer> arr1 = new ArrayList<>();
//        arr1.addAll(Arrays.asList(1, 2, 2, 3, 5, 6));
        arr1.addAll(Arrays.asList(1, 4, 5));
        ArrayList<Integer> arr2 = new ArrayList<>();
//        arr2.addAll(Arrays.asList(2, 3, 4, 4, 5, 7));
        arr2.addAll(Arrays.asList(3, 4, 5));
        System.out.println("ANS " + findIntersection(array1, array2));
        System.out.println("ANS " + findIntersectionv2(arr1, arr2));
    }

    //OWN
    static ArrayList<Integer> findIntersectionv2(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {

        // TC => O(N1 + N2)
        // SC => O(1) , bcz we are not using any extra space
        // SC => O(N1 + N2) in worst case scenario to store ans and return ans


        int i = 0, j = 0;
        int n = arr1.size();
        int m = arr2.size();
        ArrayList<Integer> intersectionArray = new ArrayList<>();
        while (i < n && j < m) { // IMP compare both the array size to avoid IndexOutOfBoundException

            if (arr1.get(i).equals(arr2.get(j))) { // if both the array have the same values
                intersectionArray.add(arr1.get(i));
                i++; // increment the i pointer
                j++; // increment the j pointer
            } else if (arr1.get(i) > arr2.get(j)) { // if the value in array 1 is greater and the value in array 2 is greater than increment j so that it can check next value as well
                j++;
            } else { // so that loop checks all the elements in the array
                i++;
            }
        }

        return intersectionArray;
    }

    //OWN
    static ArrayList<Integer> findIntersection(int a[], int b[]) {


        // TC => O(N1 + N2)
        // SC => O(1) , bcz we are not using any extra space
        // SC => O(N1 + N2) in worst case scenario to store ans and return ans

        int i = 0, j = 0;

        int n = a.length;
        int m = b.length;
        ArrayList<Integer> intersectionArray = new ArrayList<>();
        while (i < n && j < m) {

            if (a[i] == b[j]) { // if both the array have the same values
                intersectionArray.add(a[i]);
                i++; // increment the i pointer
                j++; // increment the j pointer
            } else if (a[i] > b[j]) { // if the value in array 1 is greater and the value in array 2 is greater than increment j so that it can check next value as well
                j++;
            } else { // so that loop checks all the elements in the array
                i++;
            }
        }

        return intersectionArray;
    }

    //Brute //Striver

    public static ArrayList<Integer> intersectionOfArrays(int[] A, int[] B) {

//        TC => O(n1 x n2)
//        SC => O(n2)
        ArrayList<Integer> ans = new ArrayList<>();

        // to maintain visited
        int visited[] = new int[B.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {

                if (A[i] == B[j] && visited[j] == 0) {

                    //if element matches and has not been matched with any other before
                    ans.add(B[j]);
                    visited[j] = 1;

                    break;
                } else if (B[j] > A[i]) break;
                //because array is sorted , element will not be beyond this
            }
        }
        return ans;
    }

}
