package sorting;

import java.util.Arrays;

//https://www.youtube.com/watch?v=HGk_ypEuS24 : 31:30
//InsertionSort: Take a element from the array and put it in correct order

//TC :
// Best : O(N) --> Linear TC, if all the elements are already sorted than while loop won't run and this will be best case
//Worst and Average = O(N^2) , when elements are checked it checks till 0, +1,+2,+3... this is like sum of natural number = n*(n+1)/2 so almost ==> O(n^2)
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {9, 1, 8, 2, 6, 3};
//        int[] array = {13, 46, 24, 52, 20, 9};
//        int[] array = {1, 2, 4, 6, 7, 9};
        System.out.println("ANS " + Arrays.toString(insertionSort(array)));
    }

    static int[] insertionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) { //loop will run till the end of array
            int j = i;
            // j>0 bcz when checking the 'j-1' element is checked so it will throw exception when the element is at 0, 0-1 = -1 (This will cause exception)
//            array[j-1] > array[j] bcz only than you need to swap
            while (j > 0 && array[j - 1] > array[j]) {

                swapBasedOnIndex(j - 1, j, array);
                j--; // bcz we have to check from the j till 0, for example if j is at 5th index, in the loop it should check the 4th, than 3rd and so on elements till 0th
            }
        }

        return array;
    }


    static void swapBasedOnIndex(int minimumValueIndex, int i, int[] array) {
        int tempValue = array[minimumValueIndex]; // IMP store the value not the index
        array[minimumValueIndex] = array[i];
        array[i] = tempValue;
    }

}
