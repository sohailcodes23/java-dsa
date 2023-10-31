package practice.array;

import util.CommonUtility;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int array[] = {200, 10, 20, 15, 2, 23, 90, 67, 101};

        sortArray(array);
    }

    //    SelectionSort: Select minimum value from array and swap with the starting index of sorting
    static void sortArray(int array[]) {
//        TC=> O(N^2)
//        SC=> O(1)
        for (int i = 0; i < array.length; i++) { // further optimise : i< array.length-2
            int minimumValueIndex = i;

            for (int j = i + 1; j < array.length; j++) { // further optimise : i< array.length-1
                if (array[j] < array[minimumValueIndex]) {
                    minimumValueIndex = j;
                }
            }

            CommonUtility.swapBasedOnIndex(i, minimumValueIndex, array);
        }

        System.out.println("ANS " + Arrays.toString(array));
    }

}
