package coderarmy.array;

public class RotateArrayBy1 {

    public static void main(String[] args) {

        int arra[] = {1, 2, 3, 4, 5};
        rotate(arra, arra.length);
    }

    public static void rotate(int arr[], int n) {
//        int temp = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            swapBasedOnIndex(i, i + 1, arr);
        }


    }

    public static void swapBasedOnIndex(int j, int i, int[] array) {
        int tempValue = array[j]; // IMP store the value not the index
        array[j] = array[i];
        array[i] = tempValue;
    }

}
