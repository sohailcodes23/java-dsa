package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// MergeSort =>Divide, Sort and Merge the array
// TS => O(N x log base of 2 N)
// TS Explanation : since the array is continuos divided, like n/2, n/4, n/6.... So whenever it is in division use log. so  log base of 2 N
//                  Now the sortAndMerge function may end up check all the elements in the array so O(N)
//                  Hence worst case TS =>     O(N x log base of 2 N)
// SC => O(N)   Explanation : In sortAndMerge a temporary array is always created so at the worst case might take 0(N). So SC is near about O(N)
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 8, 5, 4, 2, 23, 4};
//        int[] array = {3, 2, 1, 8, 5, 4, 23, 6, 7};
        // first time low(0) and high(n-1) will be normal
        divideAndMerge(array, 0, array.length - 1);
        System.out.println("ANS " + Arrays.toString(array));
    }

    static void divideAndMerge(int[] array, int low, int high) {

        if (low >= high) { // Base condition (low >= high) || (low == high)
            return;
        }

        int mid = (low + high) / 2; // to divide array

        divideAndMerge(array, low, mid); // first half of the array
        divideAndMerge(array, mid + 1, high); // 2nd half of the array
        sortAndMerge(array, low, mid, high); // sort the divided array and merge in temp array, than merge in original array
    }

    static void sortAndMerge(int[] array, int low, int mid, int high) {
        ArrayList<Integer> tempArray = new ArrayList<>();
        int left = low; // a pointer for left side of array
        int right = mid + 1; // a pointer for right side of array
        while (left <= mid && right <= high) {  // left and right pointer till the middle and high respectively
            if (array[left] > array[right]) { // Here left pointer is compared to right pointer, if left > right than the value is added in tempArray and right pointer moves forward till high element
                tempArray.add(array[right]);
                right++;
            } else {    // Here left pointer is compared to right pointer, if left < right than the value is added in tempArray and left pointer moves forward till middle element
                tempArray.add(array[left]);
                left++;
            }
        }

        // just incase there are still element remaining in the left half than directly add it in tempArray
        while (left <= mid) {
            tempArray.add(array[left]);
            left++;
        }


        // just incase there are still element remaining in the right half than directly add it in tempArray
        while (right <= high) {
            tempArray.add(array[right]);
            right++;
        }
//        System.out.println("tempArray " + tempArray);
//        System.out.println("LOW " + low);
//        System.out.println("MID " + mid);
//        System.out.println("HIGH " + high);
        // assigning number within the array
        // NOTE IMP ==> 'i = low', 'tempArray.get(i - low)'
        for (int i = low; i <= high; i++) {
            array[i] = tempArray.get(i - low);
        }
//        System.out.println("PRE ANS " + Arrays.toString(array));
    }

}
