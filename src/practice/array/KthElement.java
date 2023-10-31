package practice.array;

import util.CommonUtility;

public class KthElement {

    public static void main(String[] args) {
        int array[] = {200, 10, 20, 15, 2, 23, 90, 67, 101};

        System.out.println("ARR "+findKthSmallest(array, 3));
    }

    static int findKthSmallest(int[] array, int k) {

        CommonUtility.sortArray_Selection(array);

        return array[k - 1];
    }
}
