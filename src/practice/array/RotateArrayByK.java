package practice.array;

import java.util.ArrayList;
import java.util.Arrays;


// Left rotate : take k element from left and move to right
// right rotate : take k elements from right and move to left
public class RotateArrayByK {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println("LEFT (CN) " + leftRotateArray_CN(list, 2));
//
//        System.out.println(rotateArray(list, 2));
        int array[] = {1, 2, 3, 4, 5, 6, 7};

        rightRotate_Better_Optimal(array, 3);


        System.out.println("RIGHT (LC) " + Arrays.toString(array));
    }


    // Not
    public static ArrayList<Integer> leftRotateArray_Brute(ArrayList<Integer> arr, int k) {

        k = k % arr.size();
        if (k > 0) {

            ArrayList<Integer> tempArr = new ArrayList<>();
            int n = arr.size();
            for (int i = 0; i < n; i++) {
                if (i < k) {
                    tempArr.add(i, arr.get(i));
                } else {
                    arr.set(i - k, arr.get(i));
                }
            }

            for (int j = 0; j < tempArr.size(); j++) {
                arr.set(n - tempArr.size() + j, tempArr.get(j));
            }
        }
        return arr;

    }


    // leetcode
    public static void rightRotate_Better_Optimal(int[] arr, int k) {

        int n = arr.length;
        if (n != 0 && n != 1) {

            k = k % n;

            reverseArray(arr, n - k, n - 1); // reverse from k till end to get the right k elements

//        System.out.println("ANS 1 " + Arrays.toString(arr));
            reverseArray(arr, 0, n - k - 1); // reverse from 0 till kth element to get the starting elements

//        System.out.println("ANS 2 " + Arrays.toString(arr));


            reverseArray(arr, 0, n - 1); // reverse from start to end
        }
    }

    static void reverseArray(int array[], int start, int end) {
        while (start <= end) {

            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;

        }
    }

    // codingNinja

    public static void Reverse_CN(ArrayList<Integer> arr, int start, int end) {
        while (start <= end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }
    }

    // Function to Rotate k elements to right
    public static ArrayList<Integer> leftRotateArray_CN(ArrayList<Integer> arr, int k) {
        int n = arr.size();
        // Reverse first k elements
        Reverse_CN(arr, 0, k - 1);
        // Reverse last n-k elements
        Reverse_CN(arr, k, n - 1);
        // Reverse whole array
        Reverse_CN(arr, 0, n - 1);

        return arr;
    }

    public static void rightRotate_Brute(int[] arr, int k) {

        int temp[] = new int[k];
        int n = arr.length;
        int a = 0;
        for (int i = n - k; i < n; i++) {
            temp[a] = arr[i]; // temp[a] or temp[i-n+k]
            a++;
        }

        for (int i = n - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }


        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }

        System.out.println("ANS " + Arrays.toString(arr));

    }

    public static void leftRotatev2_Brute(int[] arr, int k) {

//4, 5, 6, 7, 1, 2, 3
        int n = arr.length;//7

        k = k % n;
        int temp[] = new int[k];

        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        for (int i = k; i < n; i++) { // correct
            arr[i - k] = arr[i];
        }

//        int a = 0;
        for (int i = n - k; i < n; i++) {
//            arr[i] = temp[a]; OR below
            arr[i] = temp[i - (n - k)]; // Here if n=7 & k=3 at start i = 4, so the index is 4-(4) = 0, next time i=5, so the index is 5-(4)=1, that';s how it increments and get data from temp array.
//            a++;
        }

        System.out.println("ANS " + Arrays.toString(arr));
    }

    public static void leftRotate(int[] arr, int k) {


        int result[] = new int[arr.length];


        int n = arr.length;//7

        for (int i = k; i < n; i++) { // correct
            result[i - k] = arr[i];
        }

        int a = 0;
        for (int i = n - k; i < n; i++) {
            result[i] = arr[a];
            a++;
        }

        System.out.println("ANS " + Arrays.toString(result));
    }


    // brute
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> arr, int k) {

        ArrayList<Integer> result = new ArrayList<>();


        int n = arr.size();


//        for (in)


//        int indexLength = n - 1;
//        int till = indexLength - k;
//        for (int i = 0; i <= till; i++) {
//
//            result.set(i + k, arr.get(i));
//        }
//
//        for (int j = n - 1; j >= n - k; j--) {
//
//            result.add(j - k, arr.get(j));
//        }


        return result;
    }


}
