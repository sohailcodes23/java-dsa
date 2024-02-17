package coderarmy.binarysearch;

public class CountZeroesusingBS {

    public static void main(String[] args) {

        int array[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println("ANS " + countZeroes(array, array.length));
    }

    static int countZeroes(int[] arr, int n) {
        // code here

        int start = 0;
        int end = n - 1;
        int count = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == 0) {
                end = mid - 1; // id a[mid]==0, so we need to find the first 0th element, so we update end to find the first 0 value, and as soon as end < start, loop breaks
            } else if (arr[mid] > 0) {// mid > 0, means all the elements at left are 1, so update end
                start = mid + 1;
            }
        }

        return n - 1 - end; //if you found the first 0th value, then we just need to substract that from n - 1
    }

}
