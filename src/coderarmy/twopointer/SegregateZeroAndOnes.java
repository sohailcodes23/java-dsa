package coderarmy.twopointer;

public class SegregateZeroAndOnes {

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 0, 0, 1, 1, 1, 1};//0000 11111
    }

    void segregate0and1(int[] arr, int n) {
        //TC=>O(N)
        // SC=> O(1)
        int start = 0;
        int end = n - 1;

        while (start < end) {
            if (arr[start] == 0) {
                start++;
            } else {

                if (arr[end] == 0) {
                    swapBasedOnIndex(start, end, arr);
                    start++;
                    end--;
                } else { // if arr[end] == 1
                    end--;
                }
            }

        }
    }

    public static void swapBasedOnIndex(int j, int i, int[] array) {
        int tempValue = array[j]; // IMP store the value not the index
        array[j] = array[i];
        array[i] = tempValue;
    }
}
