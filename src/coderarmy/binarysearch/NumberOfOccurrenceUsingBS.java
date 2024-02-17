package coderarmy.binarysearch;

public class NumberOfOccurrenceUsingBS {

    public static void main(String[] args) {

//        int arr[] = {1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3};
        int arr[] = {1, 1, 2, 2, 2, 2, 3};
//        int arr[] = {10, 11};
//        System.out.println("ANS " + findElementUsingBS(arr, 4, arr.length, true));
//        System.out.println("ANS " + findElementUsingBS(arr, 4, arr.length, false));
        System.out.println("ANS " + count(arr, arr.length, 4));
    }

    static int count(int[] arr, int n, int x) {

        //TC=> O(log N)
        //   SC==> O(1)
        int first = findElementUsingBS(arr, x, arr.length, true);
        if (first < 0) {// if first <0 OR == -1,that means we didn't found the first occurence, so there won't be any last occurence as well, so returned 0
            return 0;
        }

        int last = findElementUsingBS(arr, x, arr.length, false);
        return last - first + 1;
    }

    static int findElementUsingBS(int[] array, int x, int n, boolean first) {
        int start = 0;
        int end = n - 1;
        int index = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == x) {
                index = mid;
                if (first) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (array[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return index;
    }

}
