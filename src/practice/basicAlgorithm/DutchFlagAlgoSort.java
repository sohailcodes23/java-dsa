package practice.basicAlgorithm;

import util.CommonUtility;

import java.util.Arrays;


//3 IMP rules
// Q = 2,1,2,1,0,0,0,2 A= 0, 0, 0,1, 1, 2, 2,2,2
// A scenario 1=> index 0 to low -1(in this scenarios index 2)
// A scenario 2=> index low(in this scenarios index 3) to mid -1(in this scenarios index 4)
// A scenario 3=> index mid to high (whole unsorted array, at start whole array is this scenario)
// A scenario 4=> index high + 1(in this scenarios index 5) to (n-1)(in this scenarios index 8)

//so the rules are based on the above scenarios
//Rule 1 if (a[mid] == 0) swap(a[mid], a[low])  mid++; low++;
//Rule 2 if (a[mid] == 1) swap(a[mid], a[low])  mid++
//Rule 2 if (a[mid] == 2) swap(a[high], a[mid])  high--
public class DutchFlagAlgoSort {

    public static void main(String[] args) {
        int array[] = {2, 1, 2, 1, 0, 0};

        sort(array);
        System.out.printf("ANS " + Arrays.toString(array));
    }

    static void sort(int array[]) {

//        TC=> O(N)
        int n = array.length;
        int mid = 0;
        int high = n - 1;
        int low = 0;
        while (mid <= high) {

            if (mid == 0 && array[mid] == 0) { // this if the first element is 0, so no need to swap, move forward
                mid++;
                low++;
            } else if (array[mid] == 0) {
                CommonUtility.swapBasedOnIndex(mid, low, array);
                mid++;
                low++;
            } else if (array[mid] == 1) {
                mid++; // only incrementing bcz the array will be sorted based on scenario 2 the value 1 will be under low to mid-1
            } else if (array[mid] == 2) {
                CommonUtility.swapBasedOnIndex(mid, high, array);
                high--;
            }

        }
    }

    static void sort_Better(int array[]) {
        // using Bubble sort
        int n = array.length;

        for (int i = 1; i < n; i++) {

            int j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                CommonUtility.swapBasedOnIndex(j, j - 1, array);
                j--;
            }
        }
    }

}
