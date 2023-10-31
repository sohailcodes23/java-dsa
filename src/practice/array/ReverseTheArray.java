package practice.array;

import java.util.Arrays;


//GFG https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
public class ReverseTheArray {

    public static void main(String[] args) {
        int array[] = {200, 10, 20, 15, 2, 23, 90, 67, 101};

        reverseArray_Better2(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    // recursion
    static void reverseArray_Better2(int array[], int start, int end) {
//        TC=> O(N)
//        SC=> O(1), bcz we are not creating any objects

        if (start >= end) { // IMP base condition to break the recursion
            return;
        }

        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;

        reverseArray_Better2(array, start + 1, end - 1);

    }


    static int[] reverseArray_Better(int array[]) {
//        TC=> O(N)
//        SC=> O(1), bcz we are not creating any objects

        int start = 0;
        int end = array.length - 1;

        while (start < end) {

            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }

        return array;
    }

    //OWN
    // Brute
    static int[] reverseArray_Brute(int array[]) {
//        TC=> O(N)
//        SC=> O(N), bcz we are creating one more array to store the elements
        int[] reverseArray = new int[array.length];

        for (int j = array.length - 1; j >= 0; j--) {
            reverseArray[reverseArray.length - j - 1] = array[j];
        }

        return reverseArray;
    }

}
