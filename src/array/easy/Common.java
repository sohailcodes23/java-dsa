package array.easy;

import java.util.ArrayList;
import java.util.Arrays;

import static util.CommonUtility.reverseArray;
import static util.CommonUtility.swapBasedOnIndex;

public class Common {

    public static void main(String[] args) {
//        int a[] = {2, 5, 8, 1, 4, 6};
//        int a[] = {3, 4, 5, 6, 7, 8};
//        int a[] = {3, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 8};
//        int a[] = {2, 5, 8, 8, 1, 1, 4, 6};
//        int a[] = {1, 2, 3, 4, 0, 0, 5, 6, 7, 8, 9, 0};
        int a[] = {1, 2, 3, 4, 5, 6, 7, 4, 5};
//        int a[] = {3, 1, 6, 5, 10, 7, 6, 6, 1, 7};

//        System.out.println("ANS " + Arrays.toString(isSorted(a.length, a)));
        ArrayList<Integer> arr = new ArrayList<>();
//        arr.addAll(Arrays.asList(3, 4, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 8));
        arr.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
//        arr.addAll(Arrays.asList(3, 5, 22, 54, 12, 32, 76, 44, 43, 21, 65, 33, 211, 65, 23, 98, 23, 43, 11, 1, 10));
        // Q
        //65 33 211 65 23 98 23 43 11 1 3 5 22 54 12 32 76 44 43 21

//        System.out.println("ANS " + removeDuplicatesAndCountUniqueElements(arr, 0));
//        System.out.println("ANS " + leftRotateElementsByN(a, 0));
//        System.out.println(Arrays.toString(leftRotateElementsByK(a, 3)));
        System.out.println(linearSearch(a, 9));
//        moveZeroesToEnd_Optimal(a.length, a);
    }

    public static int linearSearch(int[] arr, int num) {

        // first occurrence
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }

        // last occurrence
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }


    public static int[] moveZeroesToEnd_Optimal(int n, int a[]) {
        //  1, 0, 2, 3, 4, 0, 0, 5, 6, 7, 8, 9, 0
        // TC => O(N) , explain below
        // SC => O(1), we are not using any extra space, just modifying the array
        int lastZeroIndex = -1;
        for (int i = 0; i < a.length; i++) { // TC => O(x), x bcz the array breaks when 0 is found so loop runs till x.
            if (a[i] == 0) {
                lastZeroIndex = i;
                break;
            }
        }

        if (lastZeroIndex >= 0) {
            for (int i = lastZeroIndex + 1; i < a.length; i++) { // TC => O(n-x), n-x bcz once x is found the rest of the array left is n-x.
                if (a[i] != 0) {
                    swapBasedOnIndex(i, lastZeroIndex, a);
                    lastZeroIndex++;
                }
            }
        }

        // FINAL TC=> O(x) + O(n-x) = O(N)

        return a;
    }


    //OWN // Brute
    public static int[] moveZeroesToEnd(int n, int a[]) {

        int temp[] = new int[n];
        int zeroes = 0;
        int newIndex = 0;
        for (int i = 0; i < n; i++) {

            if (a[i] != 0) {
                temp[newIndex] = a[i];
                newIndex++;
            } else {
                zeroes++;
            }
        }
        System.out.println("BB " + Arrays.toString(temp)); // Here the default vlaue that is not assigned is 0, so all the zeroes are moved to end
        for (int i = temp.length - zeroes; i < temp.length; i++) { // this logic for any type of number
            temp[i] = 0;
        }

//        for (int i = 0; i < temp.length; i++) {
//            a[i] = temp[i];
//        }

        System.out.println("AA " + Arrays.toString(a));

        return a;
    }


    public static void leftRotateElementsByK_Optimal(int nums[], int k) {

        k = k % nums.length; // adding this so that if k rotations is more than length of the array it only needs to do the extra rotation. So if nums length is5 and k is 5, than after rotation the array will be same. If k is 7 than we can divide like 5 + 2 = 7 rotation, so we don't need to do all 7 rotation only 2 rotation and ignore the 5

        if (k > 0) {
            System.out.println("K " + k);

            reverseArray(nums, 0, k - 1);
            reverseArray(nums, k, nums.length - 1);
            reverseArray(nums, 0, nums.length - 1);
        }
        System.out.println("AA " + Arrays.toString(nums));
    }


    // OWN // brute
    public static ArrayList<Integer> leftRotateElementsByKv2(ArrayList<Integer> arr, int k) {

        k = k % arr.size(); // adding this so that if k rotations is more than length of the array it only needs to do the extra rotation. So if arr length is5 and k is 5, than after rotation the array will be same. If k is 7 than we can divide like 5 + 2 = 7 rotation, so we don't need to do all 7 rotation only 2 rotation and ignore the 5

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


    public static int[] leftRotateElementsByK(int arr[], int k) {

        // by 1
        int tempArr[] = new int[k];
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                tempArr[i] = arr[i];
            } else {
                arr[i - k] = arr[i]; // i-k bcz moving the value to front
            }
        }

        for (int j = 0; j < tempArr.length; j++) {
            arr[n - tempArr.length + j] = tempArr[j];
        }

        return arr;
    }

    public static int[] leftRotateElements(int nums[], int n) {
        System.out.println("BB " + Arrays.toString(nums));
        // by 1
        int temp = nums[0];
        for (int i = 1; i <= n - 1; i++) {
            nums[i - 1] = nums[i]; // i-1 bcz moving the value to front
        }
        nums[n - 1] = temp; //rotating the first element by 1
        System.out.println("AA " + Arrays.toString(nums));
        return nums;
    }


    //removeDuplicates and give unique elements count
    public static int removeDuplicatesAndCountUniqueElements(ArrayList<Integer> arr, int n) {
        // 2 pointer approach
//        TC=> O(N)
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
//        TC=> O(N)
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
// FOr finding 2nd Largest, if we add 2nd smallest the TC will be more
        // #Brute : 1. Sort the array.
        //          2. Since the array is sort we know the last element (n-1) is the largest element, we can run the array from (n-2) and check if the value is larger than a(n-1), if it's same value than ignore the update.
        //          3. Here TC => N Log N (For sorting) and N (For loop)
        //          4. Final TC=> O(NLogN + N)
        // #Better :1. Run the loop and compare each element and get largest.
        //          2. Run the loop and compare each element and get sLargest and it shpuld be less than largest.
        //          3. Here TC => N (For first loop) and N (For 2nd loop)
        //          3. Final TC => O(N + N) = O(2N)

//        #Optimal Solution
        int sLargestElement = secondLargest(a); // TC => O(N), single pass of of data and single loop
        int sSmallestElement = secondSmallest(a); // TC => O(N)

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
}
