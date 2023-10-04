package array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Common {

    public static void main(String[] args) {
//        int a[] = {2, 5, 8, 1, 4, 6};
//        int a[] = {3, 4, 5, 6, 7, 8};
        int a[] = {3, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 8};
//        int a[] = {2, 5, 8,8,1, 1, 4, 6};

//        System.out.println("ANS " + Arrays.toString(isSorted(a.length, a)));
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(3, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 8));
        System.out.println("ANS " + removeDuplicates(arr, 0));
    }

    //removeDuplicates and give unique elements count
    public static int removeDuplicates(ArrayList<Integer> arr, int n) {
        // 2 pointer approach
//        TS=> O(N)
//        SC=> O(1) // 1 bcz we are not taking any other space, updating the same array
        int i = 0;
        for (int j = 1; j < arr.size(); j++) {
            if (arr.get(i) != arr.get(j)) { // to avoid same values
                i++; // to increment i position, so during add the data is added to next position
                arr.set(i, arr.get(j)); // setting the data on next position
            }
        }
        System.out.println("ARRAY " + arr);
        return i + 1;
    }


    public static int removeDuplicates(int[] nums, int n) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println("ARRAY " + Arrays.toString(nums));
        return i + 1;
    }

    public static int isSorted(int n, int[] a) {
//        TS=> O(N)
        int firstElement = a[0];
        for (int value : a) {
            if (value < firstElement) {
                return 0;
            } else if (firstElement != value) { // checking this bcz if same values, than no need of reassigning of the value
                firstElement = value;
            }
        }

        return 1;
    }

    public static int[] getSecondOrderElements(int n, int[] a) {
// FOr finding 2nd Largest, if we add 2nd smallest the TS will be more
        // #Brute : 1. Sort the array.
        //          2. Since the array is sort we know the last element (n-1) is the largest element, we can run the array from (n-2) and check if the value is larger than a(n-1), if it's same value than ignore the update.
        //          3. Here TS => N Log N (For sorting) and N (For loop)
        //          4. Final TS=> O(NLogN + N)
        // #Better :1. Run the loop and compare each element and get largest.
        //          2. Run the loop and compare each element and get sLargest and it shpuld be less than largest.
        //          3. Here TS => N (For first loop) and N (For 2nd loop)
        //          3. Final TS => O(N + N) = O(2N)

//        #Optimal Solution
        int sLargestElement = secondLargest(a); // TS => O(N), single pass of of data and single loop
        int sSmallestElement = secondSmallest(a); // TS => O(N)

        return new int[]{sLargestElement, sSmallestElement};
    }

    private static int secondSmallest(int[] a) {
        int smallest = a[0];
        int sSmallest = Integer.MAX_VALUE;

        for (int value : a) {
            if (value < smallest) {
                sSmallest = smallest;
                smallest = value;
            } else if (value > smallest && value < sSmallest) { // if the value is same like smallest = 7 and next value is 7 it will skip it. If next value is 5 than we have to update the sSmallest
                sSmallest = value;
            }
        }

        return sSmallest;
    }

    private static int secondLargest(int[] a) {
        int largest = a[0];
        int slargest = Integer.MIN_VALUE;

        for (int value : a) {
            if (value > largest) {
                slargest = largest;
                largest = value;
            } else if (value < largest && value > slargest) { // if the value is same like largest = 7 and next value is 7 it will skip it. If next value is 5 than we have to update the slargest
                slargest = value;
            }
        }

        return slargest;
    }

    static int largestElement(int[] arr, int n) {
        // Write your code here.
        int largest = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    static void swapBasedOnIndex(int minimumValueIndex, int i, int[] array) {
        int tempValue = array[minimumValueIndex]; // IMP store the value not the index
        array[minimumValueIndex] = array[i];
        array[i] = tempValue;
    }
}
