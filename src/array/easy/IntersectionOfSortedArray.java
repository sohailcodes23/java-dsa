package array.easy;

import java.util.ArrayList;

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
        System.out.println("ANS " + findIntersection(array1, array2));
    }

    static ArrayList<Integer> findIntersection(int a[], int b[]) {

        // TC => O(N)
        // SC => O(N)
        int i = 0, j = 0;
        ArrayList<Integer> intersectionArray = new ArrayList<>();
        while (i < a.length) {

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

}
